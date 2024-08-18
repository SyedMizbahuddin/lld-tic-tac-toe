package command;

import java.util.List;

import app.Game;
import model.InputCommand;
import model.ValidationCheck;
import writer.OutputWriter;

public class PlayMoveCommandExecutor extends CommandExecutor {

	int x, y;
	final static String COMMAND_NAME = "play_move";

	public PlayMoveCommandExecutor(Game game, OutputWriter writer) {
		super(game, writer, COMMAND_NAME);
	}

	@Override
	public void execute(InputCommand inputCommand) {
		game.playMove(x, y);
	}

	@Override
	public ValidationCheck populateAndValidate(InputCommand inputCommand) {
		List<String> params = inputCommand.getParams();
		if (params.size() != 2) {
			return invalid("Incorrect Parameters");
		}

		try {
			this.x = Integer.parseInt(params.get(0));
			this.y = Integer.parseInt(params.get(1));
		} catch (NumberFormatException e) {
			return invalid(e.getLocalizedMessage());
		}

		return valid();
	}

}
