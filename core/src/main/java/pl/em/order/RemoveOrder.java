package pl.em.order;

import lombok.RequiredArgsConstructor;
import pl.em.common.DomainCommand;
import pl.em.common.DomainID;

import java.util.function.Consumer;

@RequiredArgsConstructor
final class RemoveOrder implements DomainCommand<Void> {
	
	private final Consumer<DomainID> removeOrder;
	
	private final DomainID id;
	
	@Override
	public Void execute() {
		removeOrder.accept(id);
		return null;
	}
	
}
