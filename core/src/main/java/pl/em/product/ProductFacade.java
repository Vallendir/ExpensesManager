package pl.em.product;

import lombok.RequiredArgsConstructor;
import pl.em.common.CQRSHandler;
import pl.em.common.DomainID;

import java.util.Objects;

import static pl.em.common.CommonExceptionFactory.idIsNull;
import static pl.em.product.ProductExceptionFactory.productIsNull;

@RequiredArgsConstructor
public final class ProductFacade {
	
	private final ProductCommandStorage command;
	
	private final ProductQueryStorage query;
	
	private final CQRSHandler handler;
	
	public Product createNew(Product product) {
		if (Objects.isNull(product)) {
			throw productIsNull();
		}
		
		return handler.executeCommand(
			new CreateNewProduct(
				command::create,
				product,
				new ProductValidator(product))
		);
	}
	
	public void remove(DomainID id) {
		if (Objects.isNull(id)) {
			throw idIsNull();
		}
		
		var idToRemoveBy = id.getId();
		command.isIdValid(idToRemoveBy);
		
		handler.executeCommand(
			new RemoveProduct(command::remove, id)
		);
	}
	
}
