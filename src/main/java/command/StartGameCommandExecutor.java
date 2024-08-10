package command;

import java.util.List;

import app.Game;
import model.ValidationCheck;
import writer.OutputWriter;

@Deprecated
public class StartGameCommandExecutor extends CommandExecutor {

	final static String COMMAND_NAME = "start_game";

	public StartGameCommandExecutor(Game game, OutputWriter writer) {
		super(game, writer, COMMAND_NAME);
	}

	@Override
	public void execute(List<String> params) {
		writer.println("Started!!");
		game.start();
	}

	@Override
	public ValidationCheck populateAndValidate(List<String> params) {
		if (params.size() != 0) {
			return invalid("Incorrect Parameters");
		}

		return valid();
	}

}
