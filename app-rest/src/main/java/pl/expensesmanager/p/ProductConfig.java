package pl.expensesmanager.p;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
class ProductConfig {
	
	private final ProductRepositoryMongo repository;
	
	@Bean
	ProductFacade productFacade() {
		return new ProductFacade(
			new ProductStorageQueryMongo(repository),
			new ProductStorageCommandMongo(repository)
		);
	}
	
}
