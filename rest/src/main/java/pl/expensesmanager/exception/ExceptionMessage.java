package pl.expensesmanager.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public final class ExceptionMessage {
	
	@JsonProperty(value = "message")
	private final String message;
	
	@JsonProperty(value = "errorCode")
	private final String errorCode;
	
}
