package pl.em.common;

import java.util.Objects;
import java.util.function.Function;

import static pl.em.common.CommonExceptionFactory.idIsInvalid;

public final class CommonValidator {
	
	public static void validateId(Function<String, Boolean> checkId, DomainID id) {
		if (!checkId.apply(id.getId())) {
			throw idIsInvalid();
		}
	}
	
	public static void validateNullObject(Object object, ExpensesManagerException exception) {
		if (Objects.isNull(object)) {
			throw exception;
		}
	}
	
}
