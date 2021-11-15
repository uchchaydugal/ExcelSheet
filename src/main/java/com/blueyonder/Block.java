package com.blueyonder;

public class Block {
	public static int numberOfRows;
	public static int numberOfColumns;
	private Cell[][] cells;

	public Block() {
		cells = new Cell[numberOfRows][];
		for (int i = 0; i < Block.numberOfRows; i++) {
			cells[i] = new Cell[numberOfColumns];
			for (int j = 0; j < Block.numberOfColumns; j++) {
				cells[i][j] = new Cell();
			}
		}
	}

	public static void setNumberOfRows(int numberOfRows) {
		Block.numberOfRows = numberOfRows;
	}

	public static void setNumberOfColumns(int numberOfColumns) {
		Block.numberOfColumns = numberOfColumns;
	}

	public Cell getCell(int row, int column) {
		return cells[row][column];
	}

	private void setCell(int row, int column, Object data) {
		cells[row][column] = new Cell(data);
	}

	public void addData(int row, int column, Object data) {
		setCell(row, column, data);
	}


}
