package pl.expensesmanager.billofsale;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.expensesmanager.AbstractCoreTest;
import pl.expensesmanager.util.MergeUtil;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BillOfSaleServiceTest extends AbstractCoreTest {
	
	private static final Instant BOUGHT_DATE_MAX = Instant.now();
	
	@Mock
	private BillOfSaleStorePort storage;
	
	@InjectMocks
	private BillOfSaleService service;
	
	@Test
	void searchForDescription() {
		// Given
		BillOfSalePort expectedBillOfSale_1 = createBillOfSale();
		
		when(storage.findByDescription(BILL_OF_SALE_DESCRIPTION)).thenReturn(Optional.of(expectedBillOfSale_1));
		
		// When
		BillOfSalePort actualBillOfSale = service.searchForDescription(BILL_OF_SALE_DESCRIPTION)
		                                         .get();
		
		// Then
		assertThat(actualBillOfSale).isEqualTo(expectedBillOfSale_1);
	}
	
	@Test
	void searchForBoughtDate() {
		// Given
		BillOfSalePort expectedBillOfSale_1 = createBillOfSale();
		BillOfSalePort expectedBillOfSale_2 = createBillOfSale();
		
		List<BillOfSalePort> expectedBillOfSaleList = List.of(expectedBillOfSale_1, expectedBillOfSale_2);
		
		when(storage.findByBoughtDate(BOUGHT_DATE)).thenReturn(expectedBillOfSaleList);
		
		// When
		List<BillOfSalePort> actualBillOfSaleList = service.searchForBoughtDate(BOUGHT_DATE);
		
		// Then
		billOfSaleListAssertions(
			actualBillOfSaleList, expectedBillOfSaleList, expectedBillOfSale_1, expectedBillOfSale_2);
	}
	
	@Test
	void searchAllForBoughtDateRange() {
		// Given
		BillOfSalePort expectedBillOfSale_1 = createBillOfSale();
		BillOfSalePort expectedBillOfSale_2 = createBillOfSale();
		
		List<BillOfSalePort> expectedBillOfSaleList = List.of(expectedBillOfSale_1, expectedBillOfSale_2);
		
		when(storage.findByBoughtDateBetween(BOUGHT_DATE, BOUGHT_DATE_MAX)).thenReturn(expectedBillOfSaleList);
		
		// When
		List<BillOfSalePort> actualBillOfSaleList = service.searchAllForBoughtDateRange(BOUGHT_DATE, BOUGHT_DATE_MAX);
		
		// Then
		billOfSaleListAssertions(
			actualBillOfSaleList, expectedBillOfSaleList, expectedBillOfSale_1, expectedBillOfSale_2);
	}
	
	@Test
	void create() {
		// Given
		BillOfSalePort expectedToAdd = createBillOfSale();
		
		BillOfSalePort expectedBillOfSaleList = createBillOfSale();
		
		when(storage.save(expectedToAdd)).thenReturn(expectedBillOfSaleList);
		
		// When
		BillOfSalePort actualBillOfSaleList = service.create(expectedToAdd);
		
		// Then
		assertThat(actualBillOfSaleList).isEqualTo(expectedBillOfSaleList);
	}
	
	@Test
	void updateByObject() {
		// Given
		BillOfSalePort expectedToChange = new BillOfSale();
		expectedToChange.setId(ID);
		expectedToChange.setDescription(BILL_OF_SALE_DESCRIPTION);
		
		BillOfSalePort expectedBillOfSaleList = createBillOfSale();
		
		expectedToChange.setBoughtDate(BOUGHT_DATE);
		
		when(storage.save(expectedToChange)).thenReturn(expectedBillOfSaleList);
		
		// When
		BillOfSalePort actualBillOfSaleList = service.update(expectedToChange);
		
		// Then
		assertThat(actualBillOfSaleList).isEqualTo(expectedBillOfSaleList);
	}
	
	@Test
	void updateById() {
		// Given
		BillOfSalePort expectedToChange = new BillOfSale();
		expectedToChange.setId(ID);
		expectedToChange.setDescription(BILL_OF_SALE_DESCRIPTION);
		expectedToChange.setProductList(List.of(createProductOrder()));
		
		BillOfSalePort expectedChanges = new BillOfSale();
		expectedChanges.setBoughtDate(BOUGHT_DATE);
		
		BillOfSalePort expectedBillOfSaleList = createBillOfSale();
		
		when(storage.findById(ID)).thenReturn(Optional.of(expectedBillOfSaleList));
		when(storage.save(MergeUtil.merge(expectedToChange, expectedChanges))).thenReturn(expectedBillOfSaleList);
		
		// When
		BillOfSalePort actualBillOfSaleList = service.update(expectedChanges, ID);
		
		// Then
		assertThat(actualBillOfSaleList).isEqualTo(expectedBillOfSaleList);
	}
	
	@Test
	void updateOriginalAndChanges() {
		// Given
		BillOfSalePort expectedToChange = new BillOfSale();
		expectedToChange.setDescription(BILL_OF_SALE_DESCRIPTION);
		
		BillOfSalePort expectedChanges = new BillOfSale();
		expectedChanges.setBoughtDate(BOUGHT_DATE);
		
		BillOfSalePort expectedBillOfSaleList = createBillOfSale();
		
		when(storage.save(MergeUtil.merge(expectedToChange, expectedChanges))).thenReturn(expectedBillOfSaleList);
		
		// When
		BillOfSalePort actualBillOfSaleList = service.update(expectedToChange, expectedChanges);
		
		// Then
		assertThat(actualBillOfSaleList).isEqualTo(expectedBillOfSaleList);
	}
	
	@Test
	void searchForId() {
		// Given
		BillOfSalePort expectedBillOfSale_1 = createBillOfSale();
		
		when(storage.findById(ID)).thenReturn(Optional.of(expectedBillOfSale_1));
		
		// When
		BillOfSalePort actualBillOfSale = service.searchForId(ID)
		                                         .get();
		
		// Then
		assertThat(actualBillOfSale).isEqualTo(expectedBillOfSale_1);
	}
	
	@Test
	void searchAll() {
		// Given
		BillOfSalePort expectedBillOfSale_1 = createBillOfSale();
		BillOfSalePort expectedBillOfSale_2 = createBillOfSale();
		
		List<BillOfSalePort> expectedBillOfSaleList = List.of(expectedBillOfSale_1, expectedBillOfSale_2);
		
		when(storage.findAll()).thenReturn(expectedBillOfSaleList);
		
		// When
		List<BillOfSalePort> actualBillOfSaleList = service.searchAll();
		
		// Then
		billOfSaleListAssertions(
			actualBillOfSaleList, expectedBillOfSaleList, expectedBillOfSale_1, expectedBillOfSale_2);
	}
	
	private void billOfSaleListAssertions(
		List<BillOfSalePort> actualBillOfSaleList, List<BillOfSalePort> expectedBillOfSaleList,
		BillOfSalePort expectedBillOfSale_1, BillOfSalePort expectedBillOfSale_2
	) {
		assertThat(actualBillOfSaleList).isEqualTo(expectedBillOfSaleList);
		assertThat(actualBillOfSaleList.size()).isEqualTo(expectedBillOfSaleList.size());
		assertThat(actualBillOfSaleList).containsExactlyInAnyOrder(expectedBillOfSale_1, expectedBillOfSale_2);
		assertThat(actualBillOfSaleList.stream()
		                               .mapToDouble(BillOfSalePort::finalPrice)
		                               .sum()).isEqualTo(expectedBillOfSaleList.stream()
		                                                                       .mapToDouble(BillOfSalePort::finalPrice)
		                                                                       .sum());
	}
	
}