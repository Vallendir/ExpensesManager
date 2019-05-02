package pl.em.billofsale;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class BillOfSaleFacade {
	
	private final BillOfSaleCommandStorage command;
	
	private final BillOfSaleQueryStorage query;

}
