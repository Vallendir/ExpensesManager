package pl.em.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
enum OrderExceptionMessage {
	ORDER_IS_NULL("order.is.null", "Order cannot be null."),
	ORDER_NOT_SAVED("order.not.saved", "Order cannot be saved."),
	
	ORDER_QUANITY_IS_NULL("order.quanity.is.null", "Order quanity cannot be null."),
	
	ORDER_PRODUCT_IS_NULL("order.product.is.null", "Order has null product. Order cannot exists without product.");
	
	private final String code;
	
	private final String message;
}
