package app;

import java.util.List;
import java.util.Scanner;

import model.Board;
import model.Player;
import writer.OutputWriter;

public class Game {
	Board board;
	Scanner in;
	int size;
	List<Player> players;

	OutputWriter writer;

	Game(OutputWriter writer) {
		this.writer = writer;
	}

	void initializeBoard(int boardSize, int playerCount, List<String> playerNames) {

	}

	void start() {
		inputBoardSize();
		inputPlayers();

		board.printBoard();

	}

	void addPlayer(String name) {

		char ch = (char) ('A' + players.size());
		Character symbol = new Character(ch);
		Player player = new Player(name, symbol);
		players.add(player);
	}

	private void inputPlayers() {
		int playerCount = 0;

		while (true) {
			System.out.print("Enter the number player (2 <= N <= board size) : ");
			playerCount = in.nextInt();

			if (validPlayerCount(playerCount)) {
				break;
			}
		}

		for (int i = 0; i < playerCount; i++) {
			System.out.format("Enter player %d name : ", i + 1);
			String name = in.next();
			addPlayer(name);
		}
	}

	private boolean validPlayerCount(int playerCount) {
		if (playerCount < 2) {
			System.out.println("Oops, Number of players should be atleast 2!");
			return false;
		}
		if (playerCount > size) {
			System.out.println("Oops, Number of players should be less than " + size);
			return false;
		}
		return true;
	}

	private void inputBoardSize() {

		while (true) {
			System.out.print("Enter the size of the board (odd and >= 3) : ");
			size = in.nextInt();

			if (validSize()) {
				break;
			}

		}
		System.out.format("The size of the board is %d X %d \n", size, size);

		board = new Board(size);
	}

	private boolean validSize() {
		if (size < 3) {
			System.out.println("Oops, Number should be atleast 3!");
			return false;
		}
		if (size % 2 == 0) {
			System.out.println("Oops, It is an even number!");
			return false;
		}
		if (size > 12) {
			System.out.println("Oops, size should be less than 12");
			return false;
		}
		return true;
	}

}
