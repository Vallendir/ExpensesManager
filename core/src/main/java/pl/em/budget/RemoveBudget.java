package pl.em.budget;

import lombok.RequiredArgsConstructor;
import pl.em.common.DomainCommand;
import pl.em.common.DomainID;

import java.util.function.Consumer;

@RequiredArgsConstructor
final class RemoveBudget implements DomainCommand<Void> {
	
	private final Consumer<DomainID> removeBudget;
	
	private final DomainID id;
	
	@Override
	public Void execute() {
		removeBudget.accept(id);
		return null;
	}
	
}
