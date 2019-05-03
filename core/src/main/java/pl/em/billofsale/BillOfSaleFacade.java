package pl.em.billofsale;

import lombok.RequiredArgsConstructor;
import pl.em.common.CQRSHandler;
import pl.em.common.DomainID;

import java.util.Objects;

import static pl.em.billofsale.BillOfSaleExceptionFactory.billOfSaleIsNull;
import static pl.em.common.CommonExceptionFactory.idIsNull;

@RequiredArgsConstructor
public final class BillOfSaleFacade {
	
	private final BillOfSaleCommandStorage command;
	
	private final BillOfSaleQueryStorage query;
	
	private final CQRSHandler handler;
	
	public BillOfSale createNew(BillOfSale billOfSale) {
		if (Objects.isNull(billOfSale)) {
			throw billOfSaleIsNull();
		}
		
		return handler.executeCommand(
			new CreateNewBillOfSale(
				command::create,
				billOfSale,
				new BillOfSaleValidator(billOfSale))
		);
	}
	
	public void remove(DomainID id) {
		if (Objects.isNull(id)) {
			throw idIsNull();
		}
		
		handler.executeCommand(
			new RemoveBillOfSale(command::remove, id)
		);
	}

}
