package pl.expensesmanager.exception;

import lombok.Getter;

/**
 * Basic type of exceptions in system.
 */
class BasicException extends RuntimeException {
	
	@Getter
	private final String errorCode;
	
	BasicException(String message, String errorCode) {
		super(message);
		
		this.errorCode = errorCode;
	}
	
	BasicException(String message, String errorCode, Throwable cause) {
		super(message, cause);
		
		this.errorCode = errorCode;
	}
	
}
