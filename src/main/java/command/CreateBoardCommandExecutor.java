package command;

import java.util.List;

import app.Game;
import model.ValidationCheck;
import writer.OutputWriter;

public class CreateBoardCommandExecutor extends CommandExecutor {

	public CreateBoardCommandExecutor(Game game, OutputWriter writer) {
		super(game, writer);
	}

	@Override
	public void execute(List<String> params) {
		// TODO Auto-generated method stub

	}

	@Override
	public ValidationCheck validate(List<String> params) {
		// Requires atleast 2 players
		if (params.size() < 4) {

		}
		return null;
	}

}
