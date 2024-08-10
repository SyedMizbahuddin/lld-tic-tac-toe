package command;

import java.util.List;

import app.Game;
import model.ValidationCheck;
import writer.OutputWriter;

public abstract class CommandExecutor {

	Game game;
	OutputWriter writer;

	public CommandExecutor(Game game, OutputWriter writer) {
		super();
		this.game = game;
		this.writer = writer;
	}

	public abstract void execute(List<String> params);

	public abstract ValidationCheck validate(List<String> params);

}
