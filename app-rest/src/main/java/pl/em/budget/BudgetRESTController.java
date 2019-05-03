package pl.em.budget;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/budgets")
@RequiredArgsConstructor
class BudgetRESTController implements BudgetApiDocumentation {
	
	private final BudgetFacade service;

}
