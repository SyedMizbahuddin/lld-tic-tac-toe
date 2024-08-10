package command;

import java.util.HashMap;
import java.util.Map;

import app.Game;
import exception.CommandNotFoundException;
import writer.OutputWriter;

public class CommandFactory {

	Game game;
	OutputWriter writer;

	Map<String, CommandExecutor> commands;

	public CommandFactory(Game game, OutputWriter writer) {
		super();
		this.game = game;
		this.writer = writer;
		commands = new HashMap<>();

	}

	public CommandExecutor getCommand(String commandName) {

		if (!validCommand(commandName)) {
			throw new CommandNotFoundException("Command not found : " + commandName);
		}
		return commands.get(commandName);
	}

	boolean validCommand(String commandName) {
		return commands.containsKey(commandName);
	}
}
