package Practise2025.s.cellTable;

public class CellMain {
	
}



/*
Schema 
Cell Table
primary key(excelId*rowId*cellId), value

interface cellTable{
	boolean setCellValue(int row, int column, int value)
	int getCellValue(int row, int column)
}

interface printCellTable{
	printFirstNRows(int n)
}

class Cell{
	int row;
	int coloumn;
	int value;
	
	// getter setter for this
}

class CellImplemenation implements cellTable{
	HashMap<row@Column, Cell> cellMap;
	
	public CellImplentation(HashMap<row@Column, Cell> inputMap){
		this.cellMap = inputMap;
	}
	
	public boolean setCellValue(int row, int column, int value){
		
	}
}

class PrintImplementation implements printCellTable{
	HashMap<row@Column, Cell> cellMap;
	
	public PrintImplementation(HashMap<row@Column, Cell> inputMap){
		this.cellMap = inputMap;
	}
	
	public void printFirstNRows(int n){
		//keep on checking columns till you are getting the best one
	}
}

class GetCellTable{
	//factory design pattern as their can be many implementation for cellTable and print
	//
}
 
class Main{
	psvm(){
		cellTable = GetCellTable.getInstance("firstImplementation");
		printTable = GetCellTable.getInstance("firstPrintImplementation)
	}
}


 





*/
