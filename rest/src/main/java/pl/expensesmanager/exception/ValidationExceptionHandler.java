package pl.expensesmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.expensesmanager.exception.validation.ValidateDateException;
import pl.expensesmanager.exception.validation.ValidateNumberException;
import pl.expensesmanager.exception.validation.ValidateObjectException;
import pl.expensesmanager.exception.validation.ValidateTextException;

@ControllerAdvice
public class ValidationExceptionHandler {
	
	@ResponseBody
	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler(ValidateTextException.class)
	public ExceptionMessage handleTextException(ValidateTextException exception) {
		return exceptionMessage(exception);
	}
	
	@ResponseBody
	@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
	@ExceptionHandler(ValidateObjectException.class)
	public ExceptionMessage handleTextException(ValidateObjectException exception) {
		return exceptionMessage(exception);
	}
	
	@ResponseBody
	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler(ValidateNumberException.class)
	public ExceptionMessage handleTextException(ValidateNumberException exception) {
		return exceptionMessage(exception);
	}
	
	@ResponseBody
	@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
	@ExceptionHandler(ValidateDateException.class)
	public ExceptionMessage handleTextException(ValidateDateException exception) {
		return exceptionMessage(exception);
	}
	
	private ExceptionMessage exceptionMessage(ValidationException exception) {
		return new ExceptionMessage(exception.getMessage(), exception.getErrorCode());
	}
	
}
