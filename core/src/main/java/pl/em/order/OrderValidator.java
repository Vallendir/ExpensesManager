package pl.em.order;

import lombok.RequiredArgsConstructor;

import java.util.Objects;

import static pl.em.order.OrderExceptionFactory.orderProductIsNull;
import static pl.em.order.OrderExceptionFactory.orderQuanityIsNull;

@RequiredArgsConstructor
final class OrderValidator {
	
	private final Order order;
	
	void validateQuanity() {
		var name = order.getQuanity();
		
		if (Objects.isNull(name)) {
			throw orderQuanityIsNull();
		}
	}
	
	void validateProduct() {
		var price = order.getProduct();
		
		if (Objects.isNull(price)) {
			throw orderProductIsNull();
		}
	}
	
}
