package Practise2025.CompanyS;
//
//import java.util.*;
//
//class CellKey{
//	int row;
//	int col;
//	
//	CellKey(int row, int col){
//		this.row = row;
//		this.col = col;
//	}
//	
//	@Override
//	public boolean equals(Object o) {
//		if(!(o instanceof CellKey)) {
//			return false;
//		}
//		CellKey cellObject = (CellKey) o;
//		if(cellObject.row == this.row && cellObject.col == this.col) {
//			return true;
//		}
//		return false;
//	}
//	
//	@Override
//	public int hashCode() {
//		return Objects.hash(row, col);
//	}
//	
//	@Override
//	public String toString() {
//		return "row" + row + "col" + col;
//	}
//}
//
//class Cell{
//	Integer value;
//	String formula;
//	List<Cell> dependentList;
//	public Cell() {
//		this(null, null);
//	}
//	public Cell(String formula) {
//		this(null, formula);
//	}
//	public Cell(Integer value) {
//		this(value, null);
//	}
//	public Cell(Integer value, String formula) {
//		this.formula = formula;
//		this.value = value;
//		dependentList = new ArrayList<>();
//	}
//	public void setValue(Integer value) {
//		this.value = value;
//	}
//}
//
//class SpreadSheet{
//	
//	int columnCount;
//	HashMap<CellKey, Cell> cellMap;
//	
//	public SpreadSheet() {
//		columnCount = 0;
//		cellMap = new HashMap<>();
//	}
//	
//	public void setValueOrRowCol(int row, int col, String value) {
//		if(value.matches("\\d+")) {
//			CellKey cellKey = new CellKey(row, col);
//			if(cellMap.containsKey(cellKey)) {
//				Cell cell = cellMap.get(cellKey);
////				System.out.println(cell.)
//			}
//		}
//	}
//}
//
//class CellMain{
//	public static void main(String[] args) {
//		CellKey ck = new CellKey(1, 2);
//		System.out.println(ck.toString());
//	}
//}

/*
 * 
 * Chat gpt code
 */

import java.util.*;
import java.util.regex.*;

class CellKey {
    int row, col;
    public CellKey(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CellKey)) return false;
        CellKey ck = (CellKey) o;
        return row == ck.row && col == ck.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

    @Override
    public String toString() {
        return "R" + row + "C" + col;
    }
}

class Cell {
    String rawValue; // could be "10" or "=A1+B1"
    Integer evaluatedValue = null;
    Set<CellKey> dependencies = new HashSet<>(); // A1, B1
}

class SeriesMetadata {
    String label;
    String unit;
    String yAxisId;

    public SeriesMetadata(String label, String unit, String yAxisId) {
        this.label = label;
        this.unit = unit;
        this.yAxisId = yAxisId;
    }
}

class Spreadsheet {
    int columnCount;
    Map<CellKey, Cell> cells = new HashMap<>();
    Map<Integer, SeriesMetadata> columnMetadata = new HashMap<>();
    Map<CellKey, Set<CellKey>> dependents = new HashMap<>();

    public Spreadsheet(int columnCount) {
        this.columnCount = columnCount;
    }

    public void setColumnMetadata(int col, String label, String unit, String axisId) {
        columnMetadata.put(col, new SeriesMetadata(label, unit, axisId));
    }

    public void setCellValue(int row, int col, String value) {
        CellKey key = new CellKey(row, col);
        Cell cell = new Cell();
        cell.rawValue = value;

        // Clear previous dependencies
        if (cells.containsKey(key)) {
            for (CellKey dep : cells.get(key).dependencies) {
                dependents.get(dep).remove(key);
            }
        }

        if (value.startsWith("=")) {
            cell.dependencies = parseDependencies(value);
            for (CellKey dep : cell.dependencies) {
                dependents.computeIfAbsent(dep, k -> new HashSet<>()).add(key);
            }
        }

        cells.put(key, cell);
        evaluateAndPropagate(key, new HashSet<>());
    }

    public int getCellValue(int row, int col) {
        CellKey key = new CellKey(row, col);
        Cell cell = cells.getOrDefault(key, null);
        if (cell == null) return 0;
        if (cell.evaluatedValue != null) return cell.evaluatedValue;

        return evaluateFormula(key, cell.rawValue, new HashSet<>());
    }

    public void printFirstNRows(int n) {
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < columnCount; c++) {
                int val = getCellValue(r, c);
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }

    // =A1+B2
    private int evaluateFormula(CellKey self, String formula, Set<CellKey> visited) {
        if (!formula.startsWith("=")) return Integer.parseInt(formula);
        if (visited.contains(self)) throw new RuntimeException("Cycle detected at " + self);
        visited.add(self);

        String expr = formula.substring(1); // Remove '='
        String[] tokens = expr.split("\\+");
        int sum = 0;
        for (String token : tokens) {
            token = token.trim();
            CellKey ref = parseRef(token);
            sum += getCellValue(ref.row, ref.col);
        }

        visited.remove(self);
        return sum;
    }

    private void evaluateAndPropagate(CellKey key, Set<CellKey> visited) {
        Cell cell = cells.get(key);
        cell.evaluatedValue = evaluateFormula(key, cell.rawValue, visited);

        if (dependents.containsKey(key)) {
            for (CellKey dep : dependents.get(key)) {
                evaluateAndPropagate(dep, new HashSet<>(visited));
            }
        }
    }

    private Set<CellKey> parseDependencies(String formula) {
        Set<CellKey> deps = new HashSet<>();
        Matcher matcher = Pattern.compile("[A-Z]+\\d+").matcher(formula);
        while (matcher.find()) {
            deps.add(parseRef(matcher.group()));
        }
        return deps;
    }

    private CellKey parseRef(String ref) {
        ref = ref.toUpperCase();
        int col = ref.charAt(0) - 'A'; // Assume A-Z only
        int row = Integer.parseInt(ref.substring(1));
        return new CellKey(row, col);
    }

    // Aggregates
    public int sumRow(int row) {
        int sum = 0;
        for (int c = 0; c < columnCount; c++) {
            sum += getCellValue(row, c);
        }
        return sum;
    }

    public int sumColumn(int col) {
        int sum = 0;
        for (int r = 0; r < Integer.MAX_VALUE; r++) {
            CellKey key = new CellKey(r, col);
            if (!cells.containsKey(key)) break;
            sum += getCellValue(r, col);
        }
        return sum;
    }

    public double avgRow(int row) {
        return (double) sumRow(row) / columnCount;
    }

    public double avgColumn(int col) {
        int count = 0, sum = 0;
        for (int r = 0; r < Integer.MAX_VALUE; r++) {
            CellKey key = new CellKey(r, col);
            if (!cells.containsKey(key)) break;
            sum += getCellValue(r, col);
            count++;
        }
        return count == 0 ? 0 : (double) sum / count;
    }
}
