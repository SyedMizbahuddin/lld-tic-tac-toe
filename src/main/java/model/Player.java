package model;

public class Player {
	String name;
	PieceType piece;
	int id;

	public Player(int id, String name, PieceType piece) {
		super();
		this.id = id;
		this.name = name;
		this.piece = piece;
	}

	public String getName() {
		return name;
	}

	public PieceType getPiece() {
		return piece;
	}

	public int getId() {
		return id;
	}

}
