package pl.expensesmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.expensesmanager.exception.internal.NoAccessException;

@ControllerAdvice
public class InternalExceptionHandler {
	
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(NoAccessException.class)
	public ExceptionMessage handleNoAccessException(NoAccessException exception) {
		return exceptionMessage(exception);
	}
	
	private ExceptionMessage exceptionMessage(NoAccessException exception) {
		return new ExceptionMessage(exception.getMessage(), exception.getErrorCode());
	}
	
}
