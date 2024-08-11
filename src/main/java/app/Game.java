package app;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import exception.GameHasFinishedException;
import exception.GameNotInitializeException;
import exception.InvalidMoveException;
import model.Board;
import model.PieceType;
import model.Player;
import writer.OutputWriter;

public class Game {
	private Board board;
	private int boardSize;
	private Deque<Player> players;
	private PieceType[] pieces;
	private boolean initialized;
	private boolean finished;

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
		initialized = true;
		finished = false;

		printPlayers();
		start();
	}

	public void printPlayers() {
		// game started or not?
		isInitialised();

		for (Player player : players) {
			writer.println(player.getName() + " " + player.getPiece());
		}
		writer.println("");
	}

	private void start() {

		writer.println("Starting the game");
		boardStatus();
	}

	public void boardStatus() {
		isInitialised();

		board.printBoard(writer);
		writer.println("Turn of Player " + currPlayer().getId() + " : " + currPlayer().getName());
		writer.println("");
	}

	Player currPlayer() {
		return players.peekFirst();
	}

	public void isInitialised() {
		if (!initialized) {
			throw new GameNotInitializeException("Game not initialized");
		}
	}

	public void isFinished() {
		if (finished) {
			throw new GameHasFinishedException("Game has already finished");
		}
	}

	public void playMove(int x, int y) {
		// game started or not?
		isInitialised();

		// game has finished
		isFinished();

		// Possible/ invalid
		if (!board.canPlay(x, y)) {
			throw new InvalidMoveException("Invalid move");
		}

		board.placeMove(x, y, currPlayer().getPiece());

		if (board.hasWonV1(x, y, currPlayer().getPiece())) {
			// Win
			finished = true;
			board.printBoard(writer);
			writer.println("Game won by Player " + currPlayer().getId() + " : " + currPlayer().getName());
		} else if (!board.hasMoves()) {
			// No more moves
			finished = true;
			board.printBoard(writer);
			writer.println("Game tie, No more moves left !!");
		} else {
			// Move the player
			players.offerLast(players.pollFirst());
			boardStatus();
		}

	}

	private void addPlayer(String name) {
		Player player = new Player(players.size() + 1, name, pieces[players.size()]);
		players.add(player);
	}

}
