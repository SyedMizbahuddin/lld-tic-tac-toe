package app;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;

import writer.OutputWriter;

public class GameTest {

	private Game game;
	private OutputWriter writer;

	@BeforeEach
	public void setUp() {
		writer = mock(OutputWriter.class);
		game = new Game(writer);
	}

}
