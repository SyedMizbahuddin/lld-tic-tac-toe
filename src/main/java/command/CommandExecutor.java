package command;

import app.Game;
import model.InputCommand;
import model.ValidationCheck;
import writer.OutputWriter;

public abstract class CommandExecutor {

	Game game;
	OutputWriter writer;
	final String commandName;

	public CommandExecutor(Game game, OutputWriter writer, String commandName) {
		super();
		this.game = game;
		this.writer = writer;
		this.commandName = commandName;
	}

	public abstract void execute(InputCommand inputCommand);

	public abstract ValidationCheck populateAndValidate(InputCommand inputCommand);

	public ValidationCheck valid() {
		return new ValidationCheck(true, "");
	}

	public ValidationCheck invalid(String message) {
		return new ValidationCheck(false, message);
	}

	public String getCommandName() {
		return commandName;
	}

}
