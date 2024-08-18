package command;

import app.Game;
import exception.CommandNotFoundException;
import model.InputCommand;
import writer.OutputWriter;

public class CommandFactory {

	Game game;
	OutputWriter writer;

	public CommandFactory(Game game, OutputWriter writer) {
		super();
		this.game = game;
		this.writer = writer;

	}

	public CommandExecutor getCommand(InputCommand inputCommand) {

		CommandExecutor commandExecutor = null;

		switch (inputCommand.getCommandName()) {

		case CreateBoardCommandExecutor.COMMAND_NAME:
			commandExecutor = new CreateBoardCommandExecutor(game, writer);
			break;

		case ExitCommandExecutor.COMMAND_NAME:
			commandExecutor = new ExitCommandExecutor(game, writer);
			break;

		case PlayMoveCommandExecutor.COMMAND_NAME:
			commandExecutor = new PlayMoveCommandExecutor(game, writer);
			break;

		case ListPlayerCommandExecutor.COMMAND_NAME:
			commandExecutor = new ListPlayerCommandExecutor(game, writer);
			break;

		case BoardStatusCommandExecutor.COMMAND_NAME:
			commandExecutor = new BoardStatusCommandExecutor(game, writer);
			break;

		}

		if (commandExecutor == null) {
			throw new CommandNotFoundException("Command not found : " + inputCommand.getCommandName());
		}

		return commandExecutor;
	}

}
