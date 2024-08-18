package command;

import java.util.List;

import app.Game;
import model.InputCommand;
import model.ValidationCheck;
import writer.OutputWriter;

public class ListPlayerCommandExecutor extends CommandExecutor {

	final static String COMMAND_NAME = "list_players";

	public ListPlayerCommandExecutor(Game game, OutputWriter writer) {
		super(game, writer, COMMAND_NAME);
	}

	@Override
	public void execute(InputCommand inputCommand) {
		game.printPlayers();
	}

	@Override
	public ValidationCheck populateAndValidate(InputCommand inputCommand) {
		List<String> params = inputCommand.getParams();
		if (params.size() != 0) {
			return invalid("Incorrect Parameters");
		}

		return valid();
	}

}
