package pl.em.product;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class ProductFacade {
	
	private final ProductCommandStorage command;
	
	private final ProductQueryStorage query;

}
