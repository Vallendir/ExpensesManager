package pl.em.product;

import lombok.RequiredArgsConstructor;
import pl.em.common.DomainCommand;
import pl.em.common.DomainID;

import java.util.function.Consumer;

@RequiredArgsConstructor
final class RemoveProduct implements DomainCommand<Void> {
	
	private final Consumer<DomainID> removeProduct;
	
	private final DomainID id;
	
	@Override
	public Void execute() {
		removeProduct.accept(id);
		return null;
	}
	
}
