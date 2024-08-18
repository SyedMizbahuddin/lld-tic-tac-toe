package command;

import java.util.ArrayList;
import java.util.List;

import app.Game;
import model.InputCommand;
import model.ValidationCheck;
import writer.OutputWriter;

public class CreateBoardCommandExecutor extends CommandExecutor {

	int boardSize;
	int playersCount;
	List<String> playerNames;

	final static String COMMAND_NAME = "create_board";

	public CreateBoardCommandExecutor(Game game, OutputWriter writer) {
		super(game, writer, COMMAND_NAME);
	}

	@Override
	public void execute(InputCommand inputCommand) {
		game.initializeBoard(boardSize, playersCount, playerNames);
	}

	@Override
	public ValidationCheck populateAndValidate(InputCommand inputCommand) {
		List<String> params = inputCommand.getParams();
		// Requires at least 2 players
		if (params.size() < 4) {
			return invalid("Insufficient Parameters");
		}

		try {
			this.boardSize = Integer.parseInt(params.get(0));
			this.playersCount = Integer.parseInt(params.get(1));
		} catch (NumberFormatException e) {
			return invalid(e.getLocalizedMessage());
		}

		ValidationCheck checkSize = validSize();
		if (!checkSize.valid()) {
			return checkSize;
		}

		ValidationCheck checkPlayerCount = validPlayerCount();
		if (!checkPlayerCount.valid()) {
			return checkPlayerCount;
		}

		if (params.size() != this.playersCount + 2) {
			return invalid("Insufficient Players");
		}

		this.playerNames = new ArrayList<>();

		for (int i = 2; i < params.size(); i++) {
			this.playerNames.add(params.get(i));
		}

		return valid();
	}

	ValidationCheck validPlayerCount() {
		if (playersCount < 2) {
			return invalid("Oops, Number of players should be atleast 2!");
		}
		if (playersCount > boardSize) {
			return invalid("Oops, Number of players should be less than " + boardSize);
		}
		return valid();
	}

	ValidationCheck validSize() {
		if (boardSize < 3) {
			return invalid("Oops, Board size should be atleast 3!");
		}
		if (boardSize % 2 == 0) {
			return invalid("Oops, It is an even Board size!");
		}
		if (boardSize > 12) {
			return invalid("Oops, Board size should be less than 12");
		}
		return valid();
	}

}
