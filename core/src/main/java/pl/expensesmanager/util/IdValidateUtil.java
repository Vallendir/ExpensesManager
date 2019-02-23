package pl.expensesmanager.util;

import lombok.experimental.UtilityClass;
import pl.expensesmanager.base.IdValidatorPort;

import static pl.expensesmanager.exception.ValidationExceptionFactory.invalidIdFormatException;

@UtilityClass
public final class IdValidateUtil {
	
	public static void checkIfGivenIdIsValid(IdValidatorPort validator, String id) {
		if (!validator.isValid(id)) {
			throw invalidIdFormatException();
		}
	}
	
}
