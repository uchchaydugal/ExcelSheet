package com.blueyonder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sheet {
	private List<List<Block>> blocks;
	private int rowCount;
	private int columnCount;
	Map<String,Integer> blockStore;

	private void createBlockStore() {
		blockStore = new HashMap<>();
		for (int i = 1; i <= Block.numberOfRows; i++) {
			for (int j = 1; j <= Block.numberOfColumns; j++) {
				blockStore.putIfAbsent(""+String.valueOf(i)+","+String.valueOf(j), this.getBlockHashCode(i - 1,j - 1));
			}
		}
	}

	public Sheet(int rows, int columns) {
		this.rowCount = rows;
		this.columnCount = columns;
		Block.numberOfRows = this.rowCount / 2;
		Block.numberOfColumns = this.columnCount / 2;
		blocks = new ArrayList<>(Block.numberOfRows);
		for (int i = 0; i < Block.numberOfRows; i++) {
			blocks.add(i, new ArrayList<>(Block.numberOfColumns));
			for (int j = 0; j < Block.numberOfColumns; j++) {
				blocks.get(i).add(new Block());
			}
		}
		createBlockStore();
	}

	public Object getCellData(int row, int column) {
		int blockRow = (int) Math.ceil(Double.parseDouble(Integer.valueOf(row).toString()) / Double.parseDouble(Integer.valueOf(2).toString()));
		int blockColumn = (int) Math.ceil(Double.parseDouble(Integer.valueOf(column).toString()) / Double.parseDouble(Integer.valueOf(4).toString()));
		// convert 1-based indexing to 0-based indexing
		return blocks.get(blockRow - 1).get(blockColumn - 1).getCell((row % Block.numberOfRows) - 1, (column % Block.numberOfColumns) - 1).getData();
	}
	
	public void addData(int row, int column, Object data) {
		int blockRow = (int) Math.ceil(Double.parseDouble(Integer.valueOf(row).toString()) / Double.parseDouble(Integer.valueOf(2).toString()));
		int blockColumn = (int) Math.ceil(Double.parseDouble(Integer.valueOf(column).toString()) / Double.parseDouble(Integer.valueOf(2).toString()));
		// convert 1-based indexing to 0-based indexing
		blocks.get(blockRow - 1).get(blockColumn - 1).addData(getCorrespondingRow(row) - 1, getCorrespondingColumn(column) - 1, data);
	}

	private int getCorrespondingColumn(int column) {
		return (column % 2) == 0 ? 2 : 1;
	}

	private int getCorrespondingRow(int row) {
		return (row % 2) == 0 ? 2 : 1;
	}

	public int getBlockHashCode(int r, int c) {
		// convert 1-based indexing to 0-based indexing
		return blocks.get(r).get(c).hashCode();
	}
}