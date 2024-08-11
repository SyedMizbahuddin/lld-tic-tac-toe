package model;

import writer.OutputWriter;

public class Board {
	PieceType[][] cells;
	int size;
	int emptyCells;

	public Board(int size) {
		super();
		this.size = size;
		this.cells = new PieceType[size][size];
		this.emptyCells = size * size;
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
		emptyCells--;
	}

	public boolean canPlay(int x, int y) {
		return x >= 0
				&& y >= 0
				&& x < size
				&& y < size
				&& cells[x][y] == null;
	}

	public boolean hasMoves() {
		return emptyCells != 0;
	}

	public boolean hasWonV1(int x, int y, PieceType pieceType) {

		return rowMatch(x, y, pieceType)
				|| colMatch(x, y, pieceType)
				|| diagMatch(x, y, pieceType)
				|| antiDiagMatch(x, y, pieceType);
	}

	public boolean diagMatch(int x, int y, PieceType pieceType) {
		// in the diagonal
		if (x != y) {
			// not on diagonal
			return false;
		}
		for (int j = 0; j < size; j++) {
			if (cells[j][j] != pieceType) {
				return false;
			}
		}
		return true;
	}

	public boolean antiDiagMatch(int x, int y, PieceType pieceType) {
		// in the anti diagonal
		if (x + y != size) {
			// not on anti diagonal
			return false;
		}
		for (int j = 0; j < size; j++) {
			if (cells[j][size - j - 1] != pieceType) {
				return false;
			}
		}
		return true;
	}

	public boolean rowMatch(int x, int y, PieceType pieceType) {
		// in the row
		for (int j = 0; j < size; j++) {
			if (cells[x][j] != pieceType) {
				return false;
			}
		}
		return true;
	}

	public boolean colMatch(int x, int y, PieceType pieceType) {
		// in the col
		for (int i = 0; i < size; i++) {
			if (cells[i][y] != pieceType) {
				return false;
			}
		}
		return true;
	}

}
