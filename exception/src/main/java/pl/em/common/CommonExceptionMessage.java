package pl.em.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
enum CommonExceptionMessage {
	ID_IS_NULL("id.is.null", "Id cannot be null."),
	
	ID_IS_INVALID("id.is.invalid", "Id is invalid or has invalid format.");
	
	private final String code;
	
	private final String message;
}
