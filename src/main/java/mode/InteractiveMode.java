package mode;

import java.util.Scanner;

import command.CommandExecutor;
import command.CommandFactory;
import exception.InvalidCommandException;
import model.InputCommand;
import model.ValidationCheck;

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
			CommandExecutor commandExecutor = commandFactory.getCommand(inputCommand.getCommandName());

			ValidationCheck valid = commandExecutor.populateAndValidate(inputCommand.getParams());
			if (!valid.valid()) {
				throw new InvalidCommandException("Invalid command params : " + valid.message());
			}

			commandExecutor.execute(inputCommand.getParams());

		}
	}

}
