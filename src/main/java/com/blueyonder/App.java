package com.blueyonder;

public class App {

	public static void main( String[] args ) {
		Sheet sheet = new Sheet(100, 200);
		sheet.addData(1, 2, "Row: 1 and Column: 2");
		sheet.addData(50, 100, "Row: 50 and Column: 100");
		sheet.addData(100, 200, "Row: 100 and Column: 200");
	}
}
