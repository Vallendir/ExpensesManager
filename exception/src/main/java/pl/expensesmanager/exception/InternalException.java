package pl.expensesmanager.exception;

/**
 * Exception to extending by all exceptions of internal issues
 */
public class InternalException extends BasicException {
	
	public InternalException(String message, String errorCode) {
		super(message, errorCode);
	}
	
	public InternalException(String message, String errorCode, Throwable cause) {
		super(message, errorCode, cause);
	}
	
}
