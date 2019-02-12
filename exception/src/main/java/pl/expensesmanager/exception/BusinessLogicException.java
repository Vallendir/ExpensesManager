package pl.expensesmanager.exception;

/**
 * Exception to extending by all exceptions of business logic issues
 */
public class BusinessLogicException extends BasicException {
	
	public BusinessLogicException(String message, String errorCode) {
		super(message, errorCode);
	}
	
	public BusinessLogicException(String message, String errorCode, Throwable cause) {
		super(message, errorCode, cause);
	}
	
}
