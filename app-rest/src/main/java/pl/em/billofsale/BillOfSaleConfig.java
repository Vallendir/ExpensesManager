package pl.em.billofsale;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.em.common.CQRSHandler;
import pl.em.order.OrderMongoStorageProxy;

@Configuration
@RequiredArgsConstructor
class BillOfSaleConfig {
	
	private final BillOfSaleMongoRepository repository;
	
	private final OrderMongoStorageProxy orderProxy;
	
	@Bean
	BillOfSaleFacade billOfSaleFacade() {
		return new BillOfSaleFacade(
			new BillOfSaleCommandMongoStorage(repository, orderProxy),
			new BillOfSaleQueryMongoStorage(repository, orderProxy),
			new CQRSHandler()
		);
	}
	
	@Bean
	BillOfSaleMongoStorageProxy billOfSaleMongoStorageProxy() {
		return new BillOfSaleMongoStorageProxy(
			new BillOfSaleCommandMongoStorage(repository, orderProxy),
			new BillOfSaleQueryMongoStorage(repository, orderProxy)
		);
	}
	
}
