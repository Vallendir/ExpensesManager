package pl.em.billofsale;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

import static pl.em.billofsale.BillOfSaleExceptionFactory.*;

@RequiredArgsConstructor
final class BillOfSaleValidator {
	
	private final BillOfSale billOfSale;
	
	void validateDescription() {
		var description = billOfSale.getDescription();
		
		if (Objects.isNull(description)) {
			throw billOfSaleDescriptionIsNull();
		}
		
		if (StringUtils.isBlank(description)) {
			throw billOfSaleDescriptionIsEmpty();
		}
	}
	
	void validateBoughtDate() {
		var boughtDate = billOfSale.getBoughtDate();
		
		if (Objects.isNull(boughtDate)) {
			throw billOfSaleDateIsNull();
		}
	}
	
	void validateOrders() {
		var orders = billOfSale.getOrdersList();
		
		if (Objects.isNull(orders)) {
			throw billOfSaleOrdersListIsNull();
		}
	}
	
}
