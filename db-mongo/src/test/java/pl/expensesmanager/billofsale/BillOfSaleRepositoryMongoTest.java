package pl.expensesmanager.billofsale;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.expensesmanager.AbstractMongoDBTest;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BillOfSaleRepositoryMongoTest extends AbstractMongoDBTest {
	
	private static final Instant BOUGHT_DATE_MAX = Instant.now();
	
	@Mock
	private BillOfSaleRepositoryMongo storage;
	
	@Test
	void findByDescription() {
		// Given
		BillOfSale expectedBillOfSale_1 = createBillOfSale();
		
		when(storage.findByDescription(BILL_OF_SALE_DESCRIPTION)).thenReturn(Optional.of(expectedBillOfSale_1));
		
		// When
		BillOfSale actualBillOfSale = storage.findByDescription(BILL_OF_SALE_DESCRIPTION)
		                                         .get();
		
		// Then
		assertThat(actualBillOfSale).isEqualTo(expectedBillOfSale_1);
	}
	
	@Test
	void findByBoughtDate() {
		// Given
		BillOfSale expectedBillOfSale_1 = createBillOfSale();
		BillOfSale expectedBillOfSale_2 = createBillOfSale();
		
		List<BillOfSale> expectedBillOfSaleList = List.of(expectedBillOfSale_1, expectedBillOfSale_2);
		
		when(storage.findByBoughtDate(BOUGHT_DATE)).thenReturn(expectedBillOfSaleList);
		
		// When
		List<BillOfSale> actualBillOfSaleList = storage.findByBoughtDate(BOUGHT_DATE);
		
		// Then
		billOfSaleListAssertions(
			actualBillOfSaleList, expectedBillOfSaleList, expectedBillOfSale_1, expectedBillOfSale_2);
	}
	
	@Test
	void findByBoughtDateBetween() {
		// Given
		BillOfSale expectedBillOfSale_1 = createBillOfSale();
		BillOfSale expectedBillOfSale_2 = createBillOfSale();
		
		List<BillOfSale> expectedBillOfSaleList = List.of(expectedBillOfSale_1, expectedBillOfSale_2);
		
		when(storage.findByBoughtDateBetween(BOUGHT_DATE, BOUGHT_DATE_MAX)).thenReturn(expectedBillOfSaleList);
		
		// When
		List<BillOfSale> actualBillOfSaleList = storage.findByBoughtDateBetween(BOUGHT_DATE, BOUGHT_DATE_MAX);
		
		// Then
		billOfSaleListAssertions(
			actualBillOfSaleList, expectedBillOfSaleList, expectedBillOfSale_1, expectedBillOfSale_2);
	}
	
	@Test
	void add() {
		// Given
		BillOfSale expectedToAdd = createBillOfSale();
		
		BillOfSale expectedBillOfSale = createBillOfSale();
		
		when(storage.save(expectedToAdd)).thenReturn(expectedBillOfSale);
		
		// When
		BillOfSale actualBillOfSale = storage.save(expectedToAdd);
		
		// Then
		assertThat(actualBillOfSale).isEqualTo(expectedBillOfSale);
	}
	
	@Test
	void findById() {
		// Given
		BillOfSale expectedBillOfSale_1 = createBillOfSale();
		
		when(storage.findById(ID)).thenReturn(Optional.of(expectedBillOfSale_1));
		
		// When
		BillOfSale actualBillOfSale = storage.findById(ID)
		                                         .get();
		
		// Then
		assertThat(actualBillOfSale).isEqualTo(expectedBillOfSale_1);
	}
	
	@Test
	void findAll() {
		// Given
		BillOfSale expectedBillOfSale_1 = createBillOfSale();
		BillOfSale expectedBillOfSale_2 = createBillOfSale();
		
		List<BillOfSale> expectedBillOfSaleList = List.of(expectedBillOfSale_1, expectedBillOfSale_2);
		
		when(storage.findAll()).thenReturn(expectedBillOfSaleList);
		
		// When
		List<BillOfSale> actualBillOfSaleList = storage.findAll();
		
		// Then
		billOfSaleListAssertions(
			actualBillOfSaleList, expectedBillOfSaleList, expectedBillOfSale_1, expectedBillOfSale_2);
	}
	
	private void billOfSaleListAssertions(
		List<BillOfSale> actualBillOfSaleList, List<BillOfSale> expectedBillOfSaleList,
		BillOfSale expectedBillOfSale_1, BillOfSale expectedBillOfSale_2
	) {
		assertThat(actualBillOfSaleList).isEqualTo(expectedBillOfSaleList);
		assertThat(actualBillOfSaleList.size()).isEqualTo(expectedBillOfSaleList.size());
		assertThat(actualBillOfSaleList).containsExactlyInAnyOrder(expectedBillOfSale_1, expectedBillOfSale_2);
		assertThat(actualBillOfSaleList.stream()
		                               .mapToDouble(BillOfSale::finalPrice)
		                               .sum()).isEqualTo(expectedBillOfSaleList.stream()
		                                                                       .mapToDouble(BillOfSale::finalPrice)
		                                                                       .sum());
	}
	
}