package Practise2025.CompanyS;

import java.util.*;

class CellKey{
	int row;
	int col;
	
	CellKey(int row, int col){
		this.row = row;
		this.col = col;
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof CellKey)) {
			return false;
		}
		CellKey cellObject = (CellKey) o;
		if(cellObject.row == this.row && cellObject.col == this.col) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(row, col);
	}
	
	@Override
	public String toString() {
		return "row" + row + "col" + col;
	}
}

class Cell{
	Integer value;
	String formula;
	List<Cell> dependentList;
	public Cell() {
		this(null, null);
	}
	public Cell(String formula) {
		this(null, formula);
	}
	public Cell(Integer value) {
		this(value, null);
	}
	public Cell(Integer value, String formula) {
		this.formula = formula;
		this.value = value;
		dependentList = new ArrayList<>();
	}
	public void setValue(Integer value) {
		this.value = value;
	}
}

class SpreadSheet{
	
	int columnCount;
	HashMap<CellKey, Cell> cellMap;
	
	public SpreadSheet() {
		columnCount = 0;
		cellMap = new HashMap<>();
	}
	
	public void setValueOrRowCol(int row, int col, String value) {
		if(value.matches("\\d+")) {
			CellKey cellKey = new CellKey(row, col);
			if(cellMap.containsKey(cellKey)) {
				Cell cell = cellMap.get(cellKey);
//				System.out.println(cell.)
			}
		}
	}
}

class CellMain{
	public static void main(String[] args) {
		CellKey ck = new CellKey(1, 2);
		System.out.println(ck.toString());
	}
}
