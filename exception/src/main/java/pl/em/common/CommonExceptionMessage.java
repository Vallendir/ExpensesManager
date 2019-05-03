package pl.em.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
enum CommonExceptionMessage {
	ID_IS_NULL("id.is.null", "Id cannot be null.");
	
	private final String code;
	
	private final String message;
}
