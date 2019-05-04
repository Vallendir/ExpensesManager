package pl.em.budget;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.em.common.DomainID;

@RestController
@RequestMapping("/budgets")
@RequiredArgsConstructor
class BudgetRESTCommandController implements BudgetApiCommandDocumentation {
	
	private final BudgetFacade service;
	
	private final BudgetRESTMapper mapper;
	
	@PostMapping
	@Override
	public Budget add(Budget budget) {
		return service.createNew(budget);
	}
	
	@DeleteMapping("/{id}")
	@Override
	public void delete(String id) {
		service.remove(new DomainID(id));
	}
	
}
