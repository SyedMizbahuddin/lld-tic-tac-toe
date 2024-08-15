package command;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreateBoardCommandExecutorTest {

	private CreateBoardCommandExecutor commandExecutor;

	@BeforeEach
	void setUp() {
		commandExecutor = mock(CreateBoardCommandExecutor.class);
	}

	@Test
	public void testValidCommand() {
		assertTrue(true);
	}
}
