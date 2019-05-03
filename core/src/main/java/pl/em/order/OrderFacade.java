package pl.em.order;

import lombok.RequiredArgsConstructor;
import pl.em.common.CQRSHandler;
import pl.em.common.DomainID;

import java.util.Objects;

import static pl.em.common.CommonExceptionFactory.idIsNull;
import static pl.em.order.OrderExceptionFactory.orderIsNull;

@RequiredArgsConstructor
public final class OrderFacade {
	
	private final OrderCommandStorage command;
	
	private final OrderQueryStorage query;
	
	private final CQRSHandler handler;
	
	public Order createNew(Order order) {
		if (Objects.isNull(order)) {
			throw orderIsNull();
		}
		
		return handler.executeCommand(
			new CreateNewOrder(
				command::create,
				order,
				new OrderValidator(order))
		);
	}
	
	public void remove(DomainID id) {
		if (Objects.isNull(id)) {
			throw idIsNull();
		}
		
		handler.executeCommand(
			new RemoveOrder(command::remove, id)
		);
	}
}
