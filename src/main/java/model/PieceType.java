package model;

public enum PieceType {
	X('X'),
	O('O'),
	A('A'),
	B('B'),
	C('C'),
	D('D'),
	E('E'),
	F('F'),
	G('G'),
	H('H'),
	I('I'),
	J('J');

	private char symbol;

	private PieceType(char symbol) {
		this.symbol = symbol;
	}

	public char getSymbol() {
		return symbol;
	}

}
