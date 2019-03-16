package pl.expensesmanager.exception;

import lombok.experimental.UtilityClass;
import pl.expensesmanager.exception.internal.IOProblemException;
import pl.expensesmanager.exception.internal.NoAccessException;

/**
 * Factory of internal exceptions reused in system
 */
@UtilityClass
public final class InternalExceptionFactory {
	
	public static InternalException illegalAccessException(Throwable cause) {
		throw new NoAccessException(ExceptionMessage.ILLEGAL_ACCESS, ErrorCode.ILLEGAL_ACCESS, cause);
	}
	
	public static InternalException ioExceptionException(String message) {
		throw new IOProblemException(message, ErrorCode.IO_EXCEPTION);
	}
	
	public static InternalException ioExceptionException(Throwable cause, String message) {
		throw new IOProblemException(message, ErrorCode.IO_EXCEPTION, cause);
	}
	
	@UtilityClass
	public static final class ErrorCode {
		
		public static final String ILLEGAL_ACCESS = code("illegal.access");
		
		public static final String IO_EXCEPTION = code("io.exception");
		
		private static String code(String code) {
			return "internal." + code;
		}
		
	}
	
	@UtilityClass
	public static final class ExceptionMessage {
		
		public static final String ILLEGAL_ACCESS = "Illegal access recognized.";
		
	}
	
}
