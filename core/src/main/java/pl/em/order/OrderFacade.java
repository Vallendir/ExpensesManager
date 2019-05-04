package pl.em.order;

import lombok.RequiredArgsConstructor;
import pl.em.common.CQRSHandler;
import pl.em.common.CommonValidator;
import pl.em.common.DomainID;

import static pl.em.common.CommonExceptionFactory.idIsNull;
import static pl.em.order.OrderExceptionFactory.orderIsNull;

@RequiredArgsConstructor
public final class OrderFacade {
	
	private final OrderCommandStorage command;
	
	private final OrderQueryStorage query;
	
	private final CQRSHandler handler;
	
	public Order createNew(Order order) {
		CommonValidator.validateNullObject(order, orderIsNull());
		
		return handler.executeCommand(
			new CreateNewOrder(
				command::create,
				order,
				new OrderValidator(order)
			)
		);
	}
	
	public void remove(DomainID id) {
		CommonValidator.validateNullObject(id, idIsNull());
		CommonValidator.validateId(command::isIdValid, id);
		
		handler.executeCommand(
			new RemoveOrder(
				command::remove,
				id
			)
		);
	}
}
