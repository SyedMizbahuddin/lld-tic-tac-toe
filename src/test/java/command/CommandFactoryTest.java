package command;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import app.Game;
import exception.CommandNotFoundException;
import model.InputCommand;
import writer.OutputWriter;

@DisplayName(value = "CommandFactory test")
public class CommandFactoryTest {

	private CommandFactory commandFactory;
	private Game game;
	private OutputWriter outputWriter;

	@BeforeEach
	public void init() {
		game = mock(Game.class);
		outputWriter = mock(OutputWriter.class);
		commandFactory = new CommandFactory(game, outputWriter);
	}

	@Test
	@DisplayName(value = "Valid Command Name")
	public void testValidCommandName() {
		CommandExecutor commandExecutor = commandFactory.getCommand(new InputCommand("play_move 1 1"));
		assertNotNull(commandExecutor);
		assertTrue(commandExecutor instanceof PlayMoveCommandExecutor);
	}

	@Test
	@DisplayName(value = "InValid Command Name")
	public void testInValidCommandName() {
		assertThrows(CommandNotFoundException.class, () -> commandFactory.getCommand(new InputCommand(
				"some-command some-param")));
	}

}
