package exception;

public class GameNotInitializeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public GameNotInitializeException(String message) {
		super(message);
	}

}
