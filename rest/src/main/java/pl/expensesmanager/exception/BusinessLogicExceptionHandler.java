package pl.expensesmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.expensesmanager.exception.business.CannotUpdateObjectException;
import pl.expensesmanager.exception.business.ObjectNotFoundException;
import pl.expensesmanager.exception.business.PassedValueIsInvalidException;

@ControllerAdvice
public class BusinessLogicExceptionHandler {
	
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(CannotUpdateObjectException.class)
	public ExceptionMessage handleNotUpdatedException(CannotUpdateObjectException exception) {
		return exceptionMessage(exception);
	}
	
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ObjectNotFoundException.class)
	public ExceptionMessage handleNotFoundException(ObjectNotFoundException exception) {
		return exceptionMessage(exception);
	}
	
	@ResponseBody
	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler(PassedValueIsInvalidException.class)
	public ExceptionMessage handleInvalidValueException(PassedValueIsInvalidException exception) {
		return exceptionMessage(exception);
	}
	
	private ExceptionMessage exceptionMessage(BusinessLogicException exception) {
		return new ExceptionMessage(exception.getMessage(), exception.getErrorCode());
	}
	
}
