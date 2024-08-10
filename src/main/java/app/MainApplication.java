package app;

import writer.OutputWriter;
import writer.SystemWriter;

public class MainApplication {

	public static void main(String[] args) {
		OutputWriter writer = new SystemWriter();
		Game game = new Game(writer);
		game.start();
	}
}
