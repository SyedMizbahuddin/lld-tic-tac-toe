package command;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import app.Game;
import model.InputCommand;
import writer.OutputWriter;

@DisplayName(value = "Exit Command")
public class ExitCommandExecutorTest {

	private CommandExecutor commandExecutor;
	private Game game;
	private OutputWriter outputWriter;

	@BeforeEach
	void setUp() {
		game = mock(Game.class);
		outputWriter = mock(OutputWriter.class);
		commandExecutor = new ExitCommandExecutor(game, outputWriter);
	}

	@Test
	@DisplayName(value = "Valid command")
	public void testValidCommand() {
		assertTrue(commandExecutor.populateAndValidate(new InputCommand("exit")).valid());
	}

	@Test
	@DisplayName(value = "Invalid command")
	public void testInvalidCommand() {
		assertFalse(commandExecutor.populateAndValidate(new InputCommand("exit 1")).valid());
		assertFalse(commandExecutor.populateAndValidate(new InputCommand("exit exit")).valid());

	}

	@Test
	@DisplayName(value = "run command")
	public void testCommandExecution() {
		// System exits
//		commandExecutor.run(new InputCommand("exit"));

	}
}
