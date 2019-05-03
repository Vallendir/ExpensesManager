package pl.em.common;

import lombok.Getter;

@Getter
public class ExpensesManagerException extends RuntimeException {
	
	private final ExceptionMessage exception;
	
	public ExpensesManagerException(ExceptionMessage exception) {
		super(exception.getMessage());
		this.exception = exception;
	}
	
	public ExpensesManagerException(ExceptionMessage exception, Throwable cause) {
		super(exception.getMessage(), cause);
		this.exception = exception;
	}
	
}
