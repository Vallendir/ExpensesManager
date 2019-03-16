package pl.expensesmanager.billofsale;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Representation of bill of sale image
 */
@Getter
@RequiredArgsConstructor
public class BillOfSaleImage {
	
	private final String contentType;
	
	private final byte[] imageAsBytes;
	
}
