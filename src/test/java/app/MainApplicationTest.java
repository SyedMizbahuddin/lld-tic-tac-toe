package app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainApplicationTest {

	private InputStream sysInBackup;
	private PrintStream sysOutBackup;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@BeforeEach
	public void setUp() {
		sysInBackup = System.in;
		sysOutBackup = System.out;
		System.setOut(new PrintStream(outContent));
	}

	@AfterEach
	public void tearDown() {
		System.setOut(sysOutBackup);
		System.setIn(sysInBackup);
	}

	@Test
	public void testInteractiveMode() {
		final String commands = "create_board 3 2 syed1 syed2\n"
				+ "list_players\n"
				+ "board_status\n"
				+ "play_move 1 1\n"
				+ "play_move 0 1\n"
				+ "play_move 0 0\n"
				+ "play_move 0 2\n"
				+ "play_move 2 2\n"
				+ "exit\n";

		final String expectedOutput = "ok";

		final ByteArrayInputStream in = new ByteArrayInputStream(commands.getBytes());
		System.setIn(in);

		MainApplication.main(new String[] {});

		sysOutBackup.print(outContent.toString());
		assertEquals(expectedOutput, outContent.toString());
	}

}
