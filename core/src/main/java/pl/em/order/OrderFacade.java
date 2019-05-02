package pl.em.order;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class OrderFacade {
	
	private final OrderCommandStorage command;
	
	private final OrderQueryStorage query;

}
