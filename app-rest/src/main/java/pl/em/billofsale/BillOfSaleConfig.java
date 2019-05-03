package pl.em.billofsale;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.em.common.CQRSHandler;

@Configuration
@RequiredArgsConstructor
class BillOfSaleConfig {
	
	private final BillOfSaleMongoRepository repository;
	
	@Bean
	BillOfSaleFacade billOfSaleFacade() {
		return new BillOfSaleFacade(
			new BillOfSaleCommandMongoStorage(repository),
			new BillOfSaleQueryMongoStorage(repository),
			new CQRSHandler()
		);
	}
	
}
