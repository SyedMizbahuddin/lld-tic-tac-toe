package model;

import writer.OutputWriter;

public class Board {
	PieceType[][] cells;
	int size;

	public Board(int size) {
		super();
		this.size = size;
		this.cells = new PieceType[size][size];
	}

	public void printBoard(OutputWriter writer) {
		writer.println("");

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (j != 0) {
					writer.print(" | ");
				}

				if (cells[i][j] == null) {
					writer.print(" ");
				} else {
					writer.print(cells[i][j].getSymbol() + "");
				}

			}
			writer.println("");
		}
	}

	public void placeMove(int x, int y, PieceType piece) {
		cells[x][y] = piece;
	}

	public boolean canPlay(int x, int y) {
		return x >= 0
				&& y >= 0
				&& x < cells.length
				&& y < cells.length
				&& cells[x][y] == null;
	}

}
