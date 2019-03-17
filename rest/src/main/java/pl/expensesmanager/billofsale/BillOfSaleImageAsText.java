package pl.expensesmanager.billofsale;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * REST representation of text read from iamge.
 */
@Getter
@RequiredArgsConstructor
public class BillOfSaleImageAsText {
	
	@JsonProperty("textFromImage")
	private final String textFromImage;
	
}
