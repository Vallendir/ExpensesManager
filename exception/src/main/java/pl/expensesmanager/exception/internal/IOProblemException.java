package pl.expensesmanager.exception.internal;

import pl.expensesmanager.exception.InternalException;

/**
 * Internal exception when there is some issue with IO oeprations
 */
public final class IOProblemException extends InternalException {
	
	public IOProblemException(String message, String errorCode) {
		super(message, errorCode);
	}
	
	public IOProblemException(String message, String errorCode, Throwable cause) {
		super(message, errorCode, cause);
	}
	
}
