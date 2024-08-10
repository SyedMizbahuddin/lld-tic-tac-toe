package app;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import model.Board;
import model.Player;
import writer.OutputWriter;

public class Game {
	Board board;
	int boardSize;
	Deque<Player> players;

	OutputWriter writer;

	Game(OutputWriter writer) {
		this.writer = writer;
	}

	public void initializeBoard(int boardSize, int playerCount, List<String> playerNames) {
		this.boardSize = boardSize;
		this.players = new LinkedList<>();
		this.board = new Board(boardSize);

		for (String name : playerNames) {
			addPlayer(name);
		}
	}

	void start() {
		board.printBoard();
	}

	void addPlayer(String name) {

		char ch = (char) ('A' + players.size());
		Character symbol = new Character(ch);
		Player player = new Player(name, symbol);
		players.add(player);
	}

}
