package app;

import command.CommandFactory;
import mode.InteractiveMode;
import mode.Mode;
import writer.OutputWriter;
import writer.SystemWriter;

public class MainApplication {

	public static void main(String[] args) {
		OutputWriter writer = new SystemWriter();
		Game game = new Game(writer);

		CommandFactory commandFactory = new CommandFactory(game, writer);

		Mode mode = new InteractiveMode(commandFactory);
		mode.start();

	}
}
