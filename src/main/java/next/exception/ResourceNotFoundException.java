package next.exception;

public class ResourceNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public  ResourceNotFoundException() {
		super();
	}

	public ResourceNotFoundException(String message, Throwable rootCause) {
		super(message, rootCause);
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}

	public ResourceNotFoundException(Throwable rootCause) {
		super(rootCause);
	}
}
