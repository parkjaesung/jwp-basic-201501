package next.exception;

public class ExistedAnotherUserException extends Exception {
	private static final long serialVersionUID = 1L;

	public  ExistedAnotherUserException() {
		super();
	}

	public ExistedAnotherUserException(String message, Throwable rootCause) {
		super(message, rootCause);
	}

	public ExistedAnotherUserException(String message) {
		super(message);
	}

	public ExistedAnotherUserException(Throwable rootCause) {
		super(rootCause);
	}
}
