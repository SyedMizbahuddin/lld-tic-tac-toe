package command;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import app.Game;
import model.InputCommand;
import writer.OutputWriter;

@DisplayName(value = "list_players Command")
public class ListPlayerCommandExecutorTest {

	private CommandExecutor commandExecutor;
	private Game game;
	private OutputWriter outputWriter;

	@BeforeEach
	void setUp() {
		game = mock(Game.class);
		outputWriter = mock(OutputWriter.class);
		commandExecutor = new ListPlayerCommandExecutor(game, outputWriter);
	}

	@Test
	@DisplayName(value = "Valid command")
	public void testValidCommand() {
		assertTrue(commandExecutor.populateAndValidate(new InputCommand("list_players")).valid());
	}

	@Test
	@DisplayName(value = "Invalid command")
	public void testInvalidCommand() {
		assertFalse(commandExecutor.populateAndValidate(new InputCommand("list_players s")).valid());
		assertFalse(commandExecutor.populateAndValidate(new InputCommand("list_players 1")).valid());
	}

	@Test
	@DisplayName(value = "run command")
	public void testCommandExecution() {
		commandExecutor.run(new InputCommand("list_players"));
		verify(game).printPlayers();
	}

}
