package pl.em.budget;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.em.common.CQRSHandler;

@Configuration
@RequiredArgsConstructor
class BudgetConfig {
	
	private final BudgetMongoRepository repository;
	
	@Bean
	BudgetFacade budgetFacade() {
		return new BudgetFacade(
			new BudgetCommandMongoStorage(repository),
			new BudgetQueryMongoStorage(repository),
			new CQRSHandler()
		);
	}
	
}
