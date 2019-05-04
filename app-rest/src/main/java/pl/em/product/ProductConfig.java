package pl.em.product;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.em.common.CQRSHandler;

@Configuration
@RequiredArgsConstructor
class ProductConfig {
	
	private final ProductMongoRepository repository;
	
	@Bean
	ProductFacade productFacade() {
		return new ProductFacade(
			new ProductCommandMongoStorage(repository),
			new ProductQueryMongoStorage(repository),
			new CQRSHandler()
		);
	}
	
	@Bean
	ProductMongoStorageProxy productMongoStorageProxy() {
		return new ProductMongoStorageProxy(
			new ProductCommandMongoStorage(repository),
			new ProductQueryMongoStorage(repository)
		);
	}
	
}
