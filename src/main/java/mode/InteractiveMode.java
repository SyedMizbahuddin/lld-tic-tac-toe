package mode;

import java.util.Scanner;

import command.CommandExecutor;
import command.CommandFactory;
import model.InputCommand;

public class InteractiveMode extends Mode {

	Scanner in;

	public InteractiveMode(CommandFactory commandFactory) {
		super(commandFactory);
		in = new Scanner(System.in);
	}

	@Override
	public void start() {

		String line = "";
		while (true) {
			line = in.nextLine();

			InputCommand inputCommand = new InputCommand(line);
			CommandExecutor commandExecutor = commandFactory.getCommand(inputCommand);

			commandExecutor.run(inputCommand);

		}
	}

}
