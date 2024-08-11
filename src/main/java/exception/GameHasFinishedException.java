package exception;

public class GameHasFinishedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public GameHasFinishedException(String message) {
		super(message);
	}

}
