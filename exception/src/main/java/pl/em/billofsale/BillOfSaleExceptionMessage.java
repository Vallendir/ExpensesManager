package pl.em.billofsale;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
enum BillOfSaleExceptionMessage {
	BILL_OF_SALE_IS_NULL("billofsale.is.null", "Bill of sale cannot be null."),
	BILL_OF_SALE_NOT_SAVED("billofsale.not.saved", "Bill of sale cannot be saved."),
	
	BILL_OF_SALE_DESCRIPTION_IS_NULL("billofsale.description.is.null", "Bill of sale description cannot be null."),
	BILL_OF_SALE_DESCRIPTION_IS_EMPTY("billofsale.description.is.empty", "Bill of sale description cannot be empty."),
	
	BILL_OF_SALE_DATE_IS_NULL("billofsale.date.is.null", "Bill of sale date cannot be null."),
	
	BILL_OF_SALE_ORDERS_IS_NULL("billofsale.orders.is.null", "Bill of sale orders list cannot be null.");
	
	private final String code;
	
	private final String message;
}
