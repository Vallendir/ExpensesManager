package pl.em.order;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.em.common.CQRSHandler;
import pl.em.product.ProductMongoStorageProxy;

@Configuration
@RequiredArgsConstructor
class OrderConfig {
	
	private final OrderMongoRepository repository;
	
	private final ProductMongoStorageProxy productProxy;
	
	@Bean
	OrderFacade orderFacade() {
		return new OrderFacade(
			new OrderCommandMongoStorage(repository, productProxy),
			new OrderQueryMongoStorage(repository, productProxy),
			new CQRSHandler()
		);
	}
	
	@Bean
	OrderMongoStorageProxy orderMongoStorageProxy() {
		return new OrderMongoStorageProxy(
			new OrderCommandMongoStorage(repository, productProxy),
			new OrderQueryMongoStorage(repository, productProxy)
		);
	}
	
}
