package app;

import java.util.ArrayList;
import java.util.List;

public class Board {
	Cell[][] cells;
	List<Player> players;

	public Board(int size) {
		super();
		this.cells = new Cell[size][size];
		this.players = new ArrayList<>();
	}

	void addPlayer(Player player) {
		players.add(player);
	}

}
