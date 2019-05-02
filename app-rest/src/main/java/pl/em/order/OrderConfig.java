package pl.em.order;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
class OrderConfig {
	
	private final OrderMongoRepository repository;
	
	@Bean
	OrderFacade orderFacade() {
		return new OrderFacade(
			new OrderCommandMongoStorage(repository),
			new OrderQueryMongoStorage(repository)
		);
	}
	
}
