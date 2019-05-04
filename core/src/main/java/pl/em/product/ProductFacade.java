package pl.em.product;

import lombok.RequiredArgsConstructor;
import pl.em.common.CQRSHandler;
import pl.em.common.CommonValidator;
import pl.em.common.DomainID;

import static pl.em.common.CommonExceptionFactory.idIsNull;
import static pl.em.product.ProductExceptionFactory.productIsNull;

@RequiredArgsConstructor
public final class ProductFacade {
	
	private final ProductCommandStorage command;
	
	private final ProductQueryStorage query;
	
	private final CQRSHandler handler;
	
	public Product createNew(Product product) {
		CommonValidator.validateNullObject(product, productIsNull());
		
		return handler.executeCommand(
			new CreateNewProduct(
				command::create,
				product,
				new ProductValidator(product)
			)
		);
	}
	
	public void remove(DomainID id) {
		CommonValidator.validateNullObject(id, idIsNull());
		CommonValidator.validateId(command::isIdValid, id);
		
		handler.executeCommand(
			new RemoveProduct(
				command::remove,
				id
			)
		);
	}
	
}
