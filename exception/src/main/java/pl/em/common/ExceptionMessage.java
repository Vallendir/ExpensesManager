package pl.em.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public final class ExceptionMessage {
	
	private final String errorCode;
	
	private final String message;
	
}
