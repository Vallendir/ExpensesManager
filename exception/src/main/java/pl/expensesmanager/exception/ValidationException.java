package pl.expensesmanager.exception;

/**
 * Exception to extending by all exceptions of validation issues
 */
public class ValidationException extends BasicException {
	
	public ValidationException(String message, String errorCode) {
		super(message, errorCode);
	}
	
	public ValidationException(String message, String errorCode, Throwable cause) {
		super(message, errorCode, cause);
	}
	
}
