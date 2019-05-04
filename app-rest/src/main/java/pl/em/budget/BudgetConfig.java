package pl.em.budget;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.em.billofsale.BillOfSaleMongoStorageProxy;
import pl.em.common.CQRSHandler;

@Configuration
@RequiredArgsConstructor
class BudgetConfig {
	
	private final BudgetMongoRepository repository;
	
	private final BillOfSaleMongoStorageProxy billProxy;
	
	@Bean
	BudgetFacade budgetFacade() {
		return new BudgetFacade(
			new BudgetCommandMongoStorage(repository, billProxy),
			new BudgetQueryMongoStorage(repository, billProxy),
			new CQRSHandler()
		);
	}
	
	@Bean
	BudgetMongoStorageProxy budgetMongoStorageProxy() {
		return new BudgetMongoStorageProxy(
			new BudgetCommandMongoStorage(repository, billProxy),
			new BudgetQueryMongoStorage(repository, billProxy)
		);
	}
	
}
