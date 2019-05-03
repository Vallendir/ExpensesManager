package pl.em.common;

public final class ObjectIsNullException extends ExpensesManagerException {
	
	public ObjectIsNullException(ExceptionMessage message) {
		super(message);
	}
	
	public ObjectIsNullException(ExceptionMessage message, Throwable cause) {
		super(message, cause);
	}
	
}
