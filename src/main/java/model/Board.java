package model;

public class Board {
	Cell[][] cells;

	public Board(int size) {
		super();
		this.cells = new Cell[size][size];
	}

	public void printBoard() {
		System.out.println("Printing board");
	}

}
