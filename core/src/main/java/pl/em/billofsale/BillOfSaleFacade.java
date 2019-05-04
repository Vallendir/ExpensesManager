package pl.em.billofsale;

import lombok.RequiredArgsConstructor;
import pl.em.common.CQRSHandler;
import pl.em.common.CommonValidator;
import pl.em.common.DomainID;

import static pl.em.billofsale.BillOfSaleExceptionFactory.billOfSaleIsNull;
import static pl.em.common.CommonExceptionFactory.idIsNull;

@RequiredArgsConstructor
public final class BillOfSaleFacade {
	
	private final BillOfSaleCommandStorage command;
	
	private final BillOfSaleQueryStorage query;
	
	private final CQRSHandler handler;
	
	public BillOfSale createNew(BillOfSale billOfSale) {
		CommonValidator.validateNullObject(billOfSale, billOfSaleIsNull());
		
		return handler.executeCommand(
			new CreateNewBillOfSale(
				command::create,
				billOfSale,
				new BillOfSaleValidator(billOfSale)
			)
		);
	}
	
	public void remove(DomainID id) {
		CommonValidator.validateNullObject(id, idIsNull());
		CommonValidator.validateId(command::isIdValid, id);
		
		handler.executeCommand(
			new RemoveBillOfSale(
				command::remove,
				id
			)
		);
	}

}
