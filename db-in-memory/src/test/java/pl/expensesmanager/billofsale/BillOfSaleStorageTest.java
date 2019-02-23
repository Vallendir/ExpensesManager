package pl.expensesmanager.billofsale;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.expensesmanager.AbstractDBInMemoryTest;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BillOfSaleStorageTest extends AbstractDBInMemoryTest {
	
	private static final Instant BOUGHT_DATE_MAX = Instant.now();
	
	@Mock
	private BillOfSaleStorage storage;
	
	@Test
	void findByDescription() {
		// Given
		BillOfSalePort expectedBillOfSale_1 = createBillOfSale();
		
		when(storage.findByDescription(BILL_OF_SALE_DESCRIPTION)).thenReturn(Optional.of(expectedBillOfSale_1));
		
		// When
		BillOfSalePort actualBillOfSale = storage.findByDescription(BILL_OF_SALE_DESCRIPTION)
		                                         .get();
		
		// Then
		assertThat(actualBillOfSale).isEqualTo(expectedBillOfSale_1);
	}
	
	@Test
	void findByBoughtDate() {
		// Given
		BillOfSalePort expectedBillOfSale_1 = createBillOfSale();
		BillOfSalePort expectedBillOfSale_2 = createBillOfSale();
		
		List<BillOfSalePort> expectedBillOfSaleList = List.of(expectedBillOfSale_1, expectedBillOfSale_2);
		
		when(storage.findByBoughtDate(BOUGHT_DATE)).thenReturn(expectedBillOfSaleList);
		
		// When
		List<BillOfSalePort> actualBillOfSaleList = storage.findByBoughtDate(BOUGHT_DATE);
		
		// Then
		billOfSaleListAssertions(
			actualBillOfSaleList, expectedBillOfSaleList, expectedBillOfSale_1, expectedBillOfSale_2);
	}
	
	@Test
	void findByBoughtDateBetween() {
		// Given
		BillOfSalePort expectedBillOfSale_1 = createBillOfSale();
		BillOfSalePort expectedBillOfSale_2 = createBillOfSale();
		
		List<BillOfSalePort> expectedBillOfSaleList = List.of(expectedBillOfSale_1, expectedBillOfSale_2);
		
		when(storage.findByBoughtDateBetween(BOUGHT_DATE, BOUGHT_DATE_MAX)).thenReturn(expectedBillOfSaleList);
		
		// When
		List<BillOfSalePort> actualBillOfSaleList = storage.findByBoughtDateBetween(BOUGHT_DATE, BOUGHT_DATE_MAX);
		
		// Then
		billOfSaleListAssertions(
			actualBillOfSaleList, expectedBillOfSaleList, expectedBillOfSale_1, expectedBillOfSale_2);
	}
	
	@Test
	void add() {
		// Given
		BillOfSalePort expectedToAdd = createBillOfSale();
		
		BillOfSalePort expectedBillOfSale = createBillOfSale();
		
		when(storage.save(expectedToAdd)).thenReturn(expectedBillOfSale);
		
		// When
		BillOfSalePort actualBillOfSale = storage.save(expectedToAdd);
		
		// Then
		assertThat(actualBillOfSale).isEqualTo(expectedBillOfSale);
	}
	
	/*@Test
	void updateByObject() {
		// Given
		BillOfSalePort expectedToChange = new BillOfSale();
		expectedToChange.setId(ID);
		expectedToChange.setDescription(BILL_OF_SALE_DESCRIPTION);
		
		BillOfSalePort expectedBillOfSale = createBillOfSale();
		
		expectedToChange.setBoughtDate(BOUGHT_DATE);
		
		when(storage.update(expectedToChange)).thenReturn(expectedBillOfSale);
		
		// When
		BillOfSalePort actualBillOfSale = storage.update(expectedToChange);
		
		// Then
		assertThat(actualBillOfSale).isEqualTo(expectedBillOfSale);
	}
	
	@Test
	void updateById() {
		// Given
		BillOfSalePort expectedToChange = new BillOfSale();
		expectedToChange.setId(ID);
		expectedToChange.setDescription(BILL_OF_SALE_DESCRIPTION);
		
		BillOfSalePort expectedChanges = new BillOfSale();
		expectedChanges.setBoughtDate(BOUGHT_DATE);
		
		BillOfSalePort expectedBillOfSale = createBillOfSale();
		
		when(storage.update(ID, expectedChanges)).thenReturn(expectedBillOfSale);
		
		// When
		BillOfSalePort actualBillOfSale = storage.update(ID, expectedChanges);
		
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
		BillOfSalePort actualBillOfSale = storage.update(expectedToChange, expectedChanges);
		
		// Then
		assertThat(actualBillOfSale).isEqualTo(expectedBillOfSale);
	}*/
	
	@Test
	void findById() {
		// Given
		BillOfSalePort expectedBillOfSale_1 = createBillOfSale();
		
		when(storage.findById(ID)).thenReturn(Optional.of(expectedBillOfSale_1));
		
		// When
		BillOfSalePort actualBillOfSale = storage.findById(ID)
		                                         .get();
		
		// Then
		assertThat(actualBillOfSale).isEqualTo(expectedBillOfSale_1);
	}
	
	@Test
	void findAll() {
		// Given
		BillOfSalePort expectedBillOfSale_1 = createBillOfSale();
		BillOfSalePort expectedBillOfSale_2 = createBillOfSale();
		
		List<BillOfSalePort> expectedBillOfSaleList = List.of(expectedBillOfSale_1, expectedBillOfSale_2);
		
		when(storage.findAll()).thenReturn(expectedBillOfSaleList);
		
		// When
		List<BillOfSalePort> actualBillOfSaleList = storage.findAll();
		
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
		assertThat(
			actualBillOfSaleList.stream()
			                    .mapToDouble(BillOfSalePort::finalPrice)
			                    .sum()
		).isEqualTo(
			expectedBillOfSaleList.stream()
			                      .mapToDouble(BillOfSalePort::finalPrice)
			                      .sum()
		);
	}
	
}