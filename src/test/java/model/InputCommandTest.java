package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import exception.CommandNotFoundException;

public class InputCommandTest {

	@Test
	public void testCommandParsingFromInput() {
		validateCommandParsing("my_command 1 2 3", "my_command", Arrays.asList("1", "2", "3"));
		validateCommandParsing("my_command   1  2 ", "my_command", Arrays.asList("1", "2"));
		validateCommandParsing("my_command", "my_command", Collections.emptyList());
		validateCommandParsing("  my_command     ", "my_command", Collections.emptyList());
	}

	@Test
	public void testCommandParsingFromInputHavingOnlySpaces() {
		assertThrows(CommandNotFoundException.class, () -> new InputCommand("   "));
	}

	@Test
	public void testCommandParsingFromEmptyInput() {
		assertThrows(CommandNotFoundException.class, () -> new InputCommand(""));
	}

	/**
	 * Helper method to validate command parsing.
	 *
	 * @param input               Input line.
	 * @param expectedCommandName Expected command name from input.
	 * @param expectedParams      Expected command params from inout.
	 */
	private void validateCommandParsing(
			final String input, final String expectedCommandName, final List expectedParams) {
		InputCommand command = new InputCommand(input);
		assertNotNull(command);
		assertEquals(expectedCommandName, command.getCommandName());
		assertEquals(expectedParams, command.getParams());
	}
}
