package model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import exception.CommandNotFoundException;

public class InputCommand {
	private String commandName;
	private List<String> params;
	final String SPACE = " ";

	public InputCommand(String line) {
		params = Arrays.stream(line.trim().split(SPACE))
				.map(String::trim)
				.collect(Collectors.toList());

		if (params.size() == 0) {
			throw new CommandNotFoundException("Command not valid");
		}

		commandName = params.get(0);
		params.remove(0);
	}

	public String getCommandName() {
		return commandName;
	}

	public List<String> getParams() {
		return params;
	}

}
