package command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import app.Game;
import model.InputCommand;
import model.ValidationCheck;
import writer.OutputWriter;

@DisplayName(value = "create_board Command")
public class CreateBoardCommandExecutorTest {

	private CreateBoardCommandExecutor commandExecutor;
	private Game game;
	private OutputWriter outputWriter;

	@BeforeEach
	void setUp() {
		game = mock(Game.class);
		outputWriter = mock(OutputWriter.class);
		commandExecutor = new CreateBoardCommandExecutor(game, outputWriter);
	}

	@Test
	@DisplayName(value = "Valid command")
	public void testValidCommand() {
		ValidationCheck check = commandExecutor.populateAndValidate(new InputCommand("create_board 3 2 syed1 syed2"));
		assertTrue(check.valid());
	}

	@Test
	@DisplayName(value = "Invalid command")
	public void testInvalidCommand() {
		ValidationCheck check1 = commandExecutor.populateAndValidate(new InputCommand("create_board -3 2 syed1 syed2"));
		assertFalse(check1.valid());

		ValidationCheck check2 = commandExecutor.populateAndValidate(new InputCommand("create_board 3 1 syed1"));
		assertFalse(check2.valid());

		ValidationCheck check3 = commandExecutor.populateAndValidate(new InputCommand("create_board 15 2 syed1 syed2"));
		assertFalse(check3.valid());

		ValidationCheck check4 = commandExecutor.populateAndValidate(new InputCommand("create_board 3 4 syed1 syed2"));
		assertFalse(check4.valid());

		ValidationCheck check5 = commandExecutor.populateAndValidate(new InputCommand("create_board 3 2 syed1"));
		assertFalse(check5.valid());

		ValidationCheck check6 = commandExecutor.populateAndValidate(new InputCommand(
				"create_board 4 4 syed1 syed2 syed3 syed4"));
		assertFalse(check6.valid());

		ValidationCheck check7 = commandExecutor.populateAndValidate(new InputCommand(
				"create_board 3 0 syed1 syed2 syed3"));
		assertFalse(check7.valid());

		ValidationCheck check8 = commandExecutor.populateAndValidate(new InputCommand(
				"create_board 3 2 syed1 syed2 syed3 syed5"));
		assertFalse(check8.valid());
	}

	@Test
	@DisplayName(value = "run command")
	public void testCommandExecution() {

		commandExecutor.run(new InputCommand("create_board 3 2 syed1 syed2"));
		ArgumentCaptor<List<String>> playerNameArgCaptor = ArgumentCaptor.forClass(List.class);
		verify(game).initializeBoard(anyInt(), anyInt(), playerNameArgCaptor.capture());
		assertEquals(2, playerNameArgCaptor.getValue().size());
		assertEquals("syed1", playerNameArgCaptor.getValue().get(0));
		assertEquals("syed2", playerNameArgCaptor.getValue().get(1));

	}
}
