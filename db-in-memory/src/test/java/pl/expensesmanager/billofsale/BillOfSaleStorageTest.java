package pl.expensesmanager.billofsale;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BillOfSaleStorageTest {
	
	@Mock
	private BillOfSaleStorage storage;
	
	@Test
	void findByDescription() {
		// Given
		BillOfSalePort expectedBillOfSale_1 = new BillOfSaleNullObject();
		
		when(storage.findByDescription(expectedBillOfSale_1.getDescription())).thenReturn(
			Optional.of(expectedBillOfSale_1));
		
		// When
		BillOfSalePort actualBillOfSale = storage.findByDescription(expectedBillOfSale_1.getDescription())
		                                         .get();
		
		// Then
		assertThat(actualBillOfSale).isEqualTo(expectedBillOfSale_1);
	}
	
	@Test
	void findByBoughtDate() {
		// Given
		Instant date = Instant.now();
		
		BillOfSalePort expectedBillOfSale_1 = new BillOfSale();
		expectedBillOfSale_1.setBoughtDate(date);
		
		List<BillOfSalePort> expectedBillOfSale = List.of(expectedBillOfSale_1);
		
		when(storage.findByBoughtDate(date)).thenReturn(List.of(expectedBillOfSale_1));
		
		// When
		List<BillOfSalePort> actualBillOfSale = storage.findByBoughtDate(date);
		
		// Then
		assertThat(actualBillOfSale).isEqualTo(expectedBillOfSale);
	}
	
	@Test
	void findByBoughtDateBetween() {
		// Given
		Instant dateMin = Instant.now();
		Instant dateMax = Instant.now();
		
		BillOfSalePort expectedBillOfSale_1 = new BillOfSale();
		expectedBillOfSale_1.setBoughtDate(dateMin);
		
		List<BillOfSalePort> expectedBillOfSaleList = List.of(expectedBillOfSale_1);
		
		when(storage.findByBoughtDateBetween(dateMin, dateMax)).thenReturn(List.of(expectedBillOfSale_1));
		
		// When
		List<BillOfSalePort> actualBillOfSale = storage.findByBoughtDateBetween(dateMin, dateMax);
		
		// Then
		assertThat(actualBillOfSale).isEqualTo(expectedBillOfSaleList);
	}
	
	@Test
	void add() {
		// Given
		Instant date = Instant.now();
		
		BillOfSalePort expectedToAdd = new BillOfSale();
		expectedToAdd.setId("ID test");
		expectedToAdd.setDescription("Description test");
		expectedToAdd.setBoughtDate(date);
		
		BillOfSalePort expectedBillOfSale = new BillOfSale();
		expectedBillOfSale.setId("ID test");
		expectedBillOfSale.setDescription("Description test");
		expectedBillOfSale.setBoughtDate(date);
		
		when(storage.add(expectedToAdd)).thenReturn(expectedBillOfSale);
		
		// When
		BillOfSalePort actualBillOfSale = storage.add(expectedToAdd);
		
		// Then
		assertThat(actualBillOfSale).isEqualTo(expectedBillOfSale);
	}
	
	@Test
	void updateByObject() {
		// Given
		Instant date = Instant.now();
		
		BillOfSalePort expectedToChange = new BillOfSale();
		expectedToChange.setId("ID test");
		expectedToChange.setDescription("Description test");
		
		BillOfSalePort expectedBillOfSale = new BillOfSale();
		expectedBillOfSale.setId("ID test");
		expectedBillOfSale.setDescription("Description test");
		expectedBillOfSale.setBoughtDate(date);
		
		expectedToChange.setBoughtDate(date);
		
		when(storage.update(expectedToChange)).thenReturn(expectedBillOfSale);
		
		// When
		BillOfSalePort actualBillOfSale = storage.update(expectedToChange);
		
		// Then
		assertThat(actualBillOfSale).isEqualTo(expectedBillOfSale);
	}
	
	@Test
	void updateById() {
		// Given
		Instant date = Instant.now();
		
		BillOfSalePort expectedToChange = new BillOfSale();
		expectedToChange.setId("ID test");
		expectedToChange.setDescription("Description test");
		
		BillOfSalePort expectedChanges = new BillOfSale();
		expectedChanges.setBoughtDate(date);
		
		BillOfSalePort expectedBillOfSale = new BillOfSale();
		expectedBillOfSale.setId("ID test");
		expectedBillOfSale.setDescription("Description test");
		expectedBillOfSale.setBoughtDate(date);
		
		when(storage.update(expectedToChange.getId(), expectedChanges)).thenReturn(expectedBillOfSale);
		
		// When
		BillOfSalePort actualBillOfSale = storage.update(expectedToChange.getId(), expectedChanges);
		
		// Then
		assertThat(actualBillOfSale).isEqualTo(expectedBillOfSale);
	}
	
	@Test
	void updateOriginalAndChanges() {
		// Given
		Instant date = Instant.now();
		
		BillOfSalePort expectedToChange = new BillOfSale();
		expectedToChange.setDescription("Description test");
		
		BillOfSalePort expectedChanges = new BillOfSale();
		expectedChanges.setBoughtDate(date);
		
		BillOfSalePort expectedBillOfSale = new BillOfSale();
		expectedBillOfSale.setDescription("Description test");
		expectedBillOfSale.setBoughtDate(date);
		
		when(storage.update(expectedToChange, expectedChanges)).thenReturn(expectedBillOfSale);
		
		// When
		BillOfSalePort actualBillOfSale = storage.update(expectedToChange, expectedChanges);
		
		// Then
		assertThat(actualBillOfSale).isEqualTo(expectedBillOfSale);
	}
	
	@Test
	void remove() {
		// Given
		BillOfSalePort expectedBillOfSale_1 = new BillOfSaleNullObject();
		
		when(storage.remove(expectedBillOfSale_1.getId())).thenReturn(true);
		
		// When
		boolean actualBillOfSales = storage.remove(expectedBillOfSale_1.getId());
		
		// Then
		assertThat(actualBillOfSales).isTrue();
	}
	
	@Test
	void findById() {
		// Given
		BillOfSalePort expectedBillOfSale_1 = new BillOfSaleNullObject();
		
		when(storage.findById(expectedBillOfSale_1.getId())).thenReturn(Optional.of(expectedBillOfSale_1));
		
		// When
		BillOfSalePort actualBillOfSale = storage.findById(expectedBillOfSale_1.getId())
		                                         .get();
		
		// Then
		assertThat(actualBillOfSale).isEqualTo(expectedBillOfSale_1);
	}
	
	@Test
	void findAll() {
		// Given
		BillOfSalePort expectedBillOfSale_1 = new BillOfSaleNullObject();
		BillOfSalePort expectedBillOfSale_2 = new BillOfSaleNullObject();
		
		when(storage.findAll()).thenReturn(List.of(expectedBillOfSale_1, expectedBillOfSale_2));
		
		// When
		List<BillOfSalePort> actualBillOfSales = storage.findAll();
		
		// Then
		assertThat(actualBillOfSales).isEqualTo(List.of(expectedBillOfSale_1, expectedBillOfSale_2));
		assertThat(actualBillOfSales.size()).isEqualTo(2);
		assertThat(actualBillOfSales).containsExactlyInAnyOrder(expectedBillOfSale_1, expectedBillOfSale_2);
	}
	
}