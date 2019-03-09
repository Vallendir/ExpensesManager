package pl.expensesmanager.exception;

import lombok.experimental.UtilityClass;
import pl.expensesmanager.exception.internal.NoAccessException;

/**
 * Factory of internal exceptions reused in system
 */
@UtilityClass
public final class InternalExceptionFactory {
	
	public static InternalException illegalAccessException(Throwable cause) {
		throw new NoAccessException(ExceptionMessage.ILLEGAL_ACCESS, ErrorCode.ILLEGAL_ACCESS, cause);
	}
	
	@UtilityClass
	public static final class ErrorCode {
		
		public static final String ILLEGAL_ACCESS = code("illegal.access");
		
		private static String code(String code) {
			return "internal." + code;
		}
		
	}
	
	@UtilityClass
	public static final class ExceptionMessage {
		
		public static final String ILLEGAL_ACCESS = "Illegal access recognized.";
		
	}
	
}
