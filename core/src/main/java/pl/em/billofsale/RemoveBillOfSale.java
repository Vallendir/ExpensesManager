package pl.em.billofsale;

import lombok.RequiredArgsConstructor;
import pl.em.common.DomainCommand;
import pl.em.common.DomainID;

import java.util.function.Consumer;

@RequiredArgsConstructor
final class RemoveBillOfSale implements DomainCommand<Void> {
	
	private final Consumer<DomainID> removeBillOfSale;
	
	private final DomainID id;
	
	@Override
	public Void execute() {
		removeBillOfSale.accept(id);
		return null;
	}
	
}
