package pl.em.common;

public final class CommonExceptionFactory {
	
	public static ExpensesManagerException idIsNull() {
		return new ObjectIsNullException(message(CommonExceptionMessage.ID_IS_NULL));
	}
	
	public static ExpensesManagerException idIsInvalid() {
		return new ObjectIsNullException(message(CommonExceptionMessage.ID_IS_INVALID));
	}
	
	private static ExceptionMessage message(CommonExceptionMessage message) {
		return new ExceptionMessage(message.getCode(), message.getMessage());
	}
	
}
