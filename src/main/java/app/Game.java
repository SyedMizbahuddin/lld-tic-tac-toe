package app;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import exception.GameNotInitializeException;
import model.Board;
import model.PieceType;
import model.Player;
import writer.OutputWriter;

public class Game {
	Board board;
	int boardSize;
	Deque<Player> players;
	PieceType[] pieces;
	boolean initialized;

	OutputWriter writer;

	Game(OutputWriter writer) {
		pieces = new PieceType[] {
				PieceType.X,
				PieceType.O,
				PieceType.A,
				PieceType.B,
				PieceType.C,
				PieceType.D,
				PieceType.E,
				PieceType.F };
		this.writer = writer;
	}

	public void initializeBoard(int boardSize, int playerCount, List<String> playerNames) {
		this.boardSize = boardSize;
		this.players = new LinkedList<>();
		this.board = new Board(boardSize);

		for (String name : playerNames) {
			addPlayer(name);
		}

		writer.println("CREATED");
		for (Player player : players) {
			writer.println(player.getName() + " " + player.getPiece());
		}
		writer.println("");
		start();
	}

	public void start() {
		initialized = true;
		writer.println("Starting game");
		board.printBoard(writer);
		writer.println("Turn of Player " + currPlayer().getId() + " : " + currPlayer().getName());
	}

	Player currPlayer() {
		return players.peekFirst();
	}

	public void playMove(int x, int y) {
		// game started or not?
		if (!initialized) {
			throw new GameNotInitializeException("Game not initialized");
		}

		// TODO Possible
		board.placeMove(x, y, currPlayer().getPiece());
		// TODO Win

		// Move the player
		players.offerLast(players.pollFirst());

		board.printBoard(writer);
		writer.println("Turn of Player " + currPlayer().getId() + " : " + currPlayer().getName());
	}

	private void addPlayer(String name) {
		Player player = new Player(players.size() + 1, name, pieces[players.size()]);
		players.add(player);
	}

}
