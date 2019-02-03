package pl.expensesmanager.billofsale;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.expensesmanager.AbstractCoreTest;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BillOfSaleServiceTest extends AbstractCoreTest {
	
	@Mock
	private BillOfSaleStorePort storage;
	
	@InjectMocks
	private BillOfSaleService service;
	
	@Test
	void searchForDescription() {
		// Given
		BillOfSalePort expectedBillOfSale_1 = createBillOfSale();
		
		when(storage.findByDescription(expectedBillOfSale_1.getDescription())).thenReturn(
			Optional.of(expectedBillOfSale_1));
		
		// When
		BillOfSalePort actualBillOfSale = service.searchForDescription(expectedBillOfSale_1.getDescription())
		                                         .get();
		
		// Then
		assertThat(actualBillOfSale).isEqualTo(expectedBillOfSale_1);
	}
	
	@Test
	void searchForBoughtDate() {
		// Given
		BillOfSalePort expectedBillOfSale_1 = createBillOfSale();
		
		List<BillOfSalePort> expectedBillOfSale = List.of(expectedBillOfSale_1);
		
		when(storage.findByBoughtDate(BOUGHT_DATE)).thenReturn(List.of(expectedBillOfSale_1));
		
		// When
		List<BillOfSalePort> actualBillOfSale = service.searchForBoughtDate(BOUGHT_DATE);
		
		// Then
		assertThat(actualBillOfSale).isEqualTo(expectedBillOfSale);
	}
	
	@Test
	void searchAllForBoughtDateRange() {
		// Given
		Instant dateMax = Instant.now();
		
		BillOfSalePort expectedBillOfSale_1 = createBillOfSale();
		
		List<BillOfSalePort> expectedBillOfSaleList = List.of(expectedBillOfSale_1);
		
		when(storage.findByBoughtDateBetween(BOUGHT_DATE, dateMax)).thenReturn(List.of(expectedBillOfSale_1));
		
		// When
		List<BillOfSalePort> actualBillOfSale = service.searchAllForBoughtDateRange(BOUGHT_DATE, dateMax);
		
		// Then
		assertThat(actualBillOfSale).isEqualTo(expectedBillOfSaleList);
	}
	
	@Test
	void create() {
		// Given
		BillOfSalePort expectedToAdd = createBillOfSale();
		
		BillOfSalePort expectedBillOfSale = createBillOfSale();
		
		when(storage.add(expectedToAdd)).thenReturn(expectedBillOfSale);
		
		// When
		BillOfSalePort actualBillOfSale = service.create(expectedToAdd);
		
		// Then
		assertThat(actualBillOfSale).isEqualTo(expectedBillOfSale);
	}
	
	@Test
	void updateByObject() {
		// Given
		BillOfSalePort expectedToChange = new BillOfSale();
		expectedToChange.setId(PRODUCT_ID);
		expectedToChange.setDescription(BILL_OF_SALE_DESCRIPTION);
		
		BillOfSalePort expectedBillOfSale = createBillOfSale();
		
		expectedToChange.setBoughtDate(BOUGHT_DATE);
		
		when(storage.update(expectedToChange)).thenReturn(expectedBillOfSale);
		
		// When
		BillOfSalePort actualBillOfSale = service.update(expectedToChange);
		
		// Then
		assertThat(actualBillOfSale).isEqualTo(expectedBillOfSale);
	}
	
	@Test
	void updateById() {
		// Given
		BillOfSalePort expectedToChange = new BillOfSale();
		expectedToChange.setId(PRODUCT_ID);
		expectedToChange.setDescription(BILL_OF_SALE_DESCRIPTION);
		
		BillOfSalePort expectedChanges = new BillOfSale();
		expectedChanges.setBoughtDate(BOUGHT_DATE);
		
		BillOfSalePort expectedBillOfSale = createBillOfSale();
		
		when(storage.update(expectedToChange.getId(), expectedChanges)).thenReturn(expectedBillOfSale);
		
		// When
		BillOfSalePort actualBillOfSale = service.update(expectedChanges, expectedToChange.getId());
		
		// Then
		assertThat(actualBillOfSale).isEqualTo(expectedBillOfSale);
	}
	
	@Test
	void updateOriginalAndChanges() {
		// Given
		BillOfSalePort expectedToChange = new BillOfSale();
		expectedToChange.setDescription(BILL_OF_SALE_DESCRIPTION);
		
		BillOfSalePort expectedChanges = new BillOfSale();
		expectedChanges.setBoughtDate(BOUGHT_DATE);
		
		BillOfSalePort expectedBillOfSale = createBillOfSale();
		
		when(storage.update(expectedToChange, expectedChanges)).thenReturn(expectedBillOfSale);
		
		// When
		BillOfSalePort actualBillOfSale = service.update(expectedToChange, expectedChanges);
		
		// Then
		assertThat(actualBillOfSale).isEqualTo(expectedBillOfSale);
	}
	
	@Test
	void delete() {
		// Given
		BillOfSalePort expectedBillOfSale_1 = createBillOfSale();
		
		when(storage.remove(expectedBillOfSale_1.getId())).thenReturn(true);
		
		// When
		boolean actualBillOfSales = service.delete(expectedBillOfSale_1.getId());
		
		// Then
		assertThat(actualBillOfSales).isTrue();
	}
	
	@Test
	void searchForId() {
		// Given
		BillOfSalePort expectedBillOfSale_1 = createBillOfSale();
		
		when(storage.findById(expectedBillOfSale_1.getId())).thenReturn(Optional.of(expectedBillOfSale_1));
		
		// When
		BillOfSalePort actualBillOfSale = service.searchForId(expectedBillOfSale_1.getId())
		                                         .get();
		
		// Then
		assertThat(actualBillOfSale).isEqualTo(expectedBillOfSale_1);
	}
	
	@Test
	void searchAll() {
		// Given
		BillOfSalePort expectedBillOfSale_1 = createBillOfSale();
		BillOfSalePort expectedBillOfSale_2 = createBillOfSale();
		
		when(storage.findAll()).thenReturn(List.of(expectedBillOfSale_1, expectedBillOfSale_2));
		
		// When
		List<BillOfSalePort> actualBillOfSales = service.searchAll();
		
		// Then
		assertThat(actualBillOfSales).isEqualTo(List.of(expectedBillOfSale_1, expectedBillOfSale_2));
		assertThat(actualBillOfSales.size()).isEqualTo(2);
		assertThat(actualBillOfSales).containsExactlyInAnyOrder(expectedBillOfSale_1, expectedBillOfSale_2);
	}
	
}