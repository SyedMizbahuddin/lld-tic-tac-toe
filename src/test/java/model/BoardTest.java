package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import writer.OutputWriter;

public class BoardTest {

	private OutputWriter outputWriter;
	private Board board;

	@BeforeEach
	public void setUp() {
		outputWriter = mock(OutputWriter.class);
		board = new Board(3);
	}

	@Test
	public void testCanPlay() {
		assertTrue(board.canPlay(0, 0));
		assertTrue(board.canPlay(1, 1));
		assertTrue(board.canPlay(2, 2));

		assertFalse(board.canPlay(4, 2));
		assertFalse(board.canPlay(0, -2));
		assertFalse(board.canPlay(-1, -1));
		assertFalse(board.canPlay(100, 100));
	}

	@Test
	public void testPlaceMove() {
		board.placeMove(0, 0, PieceType.X);
		assertEquals(board.getPiece(0, 0), PieceType.X);

		board.placeMove(0, 2, PieceType.A);
		assertEquals(board.getPiece(0, 2), PieceType.A);
	}

	@Test
	public void testPrintBoard() {
		board.printBoard(outputWriter);

		// got error too many invocations
		verify(outputWriter, atLeastOnce()).println(anyString());
		verify(outputWriter, atLeastOnce()).print(anyString());
	}

	@Test
	public void testHasMoves() {
		board.placeMove(0, 0, PieceType.X);
		board.placeMove(0, 1, PieceType.O);
		board.placeMove(0, 2, PieceType.X);
		assertTrue(board.hasMoves());

		board.placeMove(1, 0, PieceType.O);
		board.placeMove(1, 1, PieceType.X);
		board.placeMove(1, 2, PieceType.O);
		assertTrue(board.hasMoves());

		board.placeMove(2, 0, PieceType.X);
		board.placeMove(2, 1, PieceType.O);
		board.placeMove(2, 2, PieceType.X);
		assertFalse(board.hasMoves());

	}

	@Test
	public void testHasWon() {
		board.placeMove(0, 0, PieceType.X);
		board.placeMove(0, 1, PieceType.O);
		board.placeMove(0, 2, PieceType.X);
		assertFalse(board.hasWonV1(0, 2, PieceType.X));

		board.placeMove(1, 0, PieceType.O);
		board.placeMove(1, 1, PieceType.X);
		board.placeMove(1, 2, PieceType.O);
		assertFalse(board.hasWonV1(1, 2, PieceType.O));

		board.placeMove(2, 0, PieceType.X);

		assertTrue(board.hasWonV1(2, 0, PieceType.X));
	}

}
