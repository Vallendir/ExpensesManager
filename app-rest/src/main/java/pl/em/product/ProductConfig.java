package pl.em.product;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
class ProductConfig {
	
	private final ProductMongoRepository repository;
	
	@Bean
	ProductFacade productFacade() {
		return new ProductFacade(
			new ProductCommandMongoStorage(repository),
			new ProductQueryMongoStorage(repository)
		);
	}
	
}
