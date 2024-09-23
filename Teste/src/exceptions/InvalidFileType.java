package exceptions;

public class InvalidFileType extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidFileType(String message) {
		super(message);
	}
}
