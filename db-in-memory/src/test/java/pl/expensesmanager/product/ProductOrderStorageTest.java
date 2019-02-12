package pl.expensesmanager.product;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.expensesmanager.AbstractDBInMemoryTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductOrderStorageTest extends AbstractDBInMemoryTest {
	
	private static final Integer QUANITY_MIN = PRODUCT_QUANITY - 4;
	
	private static final Integer QUANITY_MAX = PRODUCT_QUANITY + 4;
	
	@Mock
	private ProductOrderStorage storage;
	
	@Test
	void findByProductName() {
		// Given
		ProductOrderPort expectedOrder_1 = createProductOrder();
		ProductOrderPort expectedOrder_2 = createProductOrder();
		
		List<ProductOrderPort> expectedOrderList = List.of(expectedOrder_1, expectedOrder_2);
		
		when(storage.findByProductName(PRODUCT_NAME)).thenReturn(expectedOrderList);
		
		// When
		List<ProductOrderPort> actualOrderList = storage.findByProductName(PRODUCT_NAME);
		
		// Then
		productOrderListAssertions(actualOrderList, expectedOrderList, expectedOrder_1, expectedOrder_2);
	}
	
	@Test
	void findByProductNameAndProductPrice() {
		// Given
		ProductOrderPort expectedOrder_1 = createProductOrder();
		ProductOrderPort expectedOrder_2 = createProductOrder();
		
		List<ProductOrderPort> expectedOrderList = List.of(expectedOrder_1, expectedOrder_2);
		
		when(storage.findByProductNameAndProductPrice(PRODUCT_NAME, PRODUCT_PRICE)).thenReturn(expectedOrderList);
		
		// When
		List<ProductOrderPort> actualOrderList = storage.findByProductNameAndProductPrice(
			PRODUCT_NAME, PRODUCT_PRICE);
		
		// Then
		productOrderListAssertions(actualOrderList, expectedOrderList, expectedOrder_1, expectedOrder_2);
	}
	
	@Test
	void findByQuanityBetween() {
		// Given
		ProductOrderPort expectedOrder_1 = createProductOrder();
		ProductOrderPort expectedOrder_2 = createProductOrder();
		
		List<ProductOrderPort> expectedOrderList = List.of(expectedOrder_1, expectedOrder_2);
		
		when(storage.findByQuanityBetween(QUANITY_MIN, QUANITY_MAX)).thenReturn(expectedOrderList);
		
		// When
		List<ProductOrderPort> actualOrderList = storage.findByQuanityBetween(QUANITY_MIN, QUANITY_MAX);
		
		// Then
		productOrderListAssertions(actualOrderList, expectedOrderList, expectedOrder_1, expectedOrder_2);
	}
	
	@Test
	void findByQuanityGreaterThan() {
		// Given
		ProductOrderPort expectedOrder_1 = createProductOrder();
		ProductOrderPort expectedOrder_2 = createProductOrder();
		
		List<ProductOrderPort> expectedOrderList = List.of(expectedOrder_1, expectedOrder_2);
		
		when(storage.findByQuanityGreaterThan(QUANITY_MIN)).thenReturn(expectedOrderList);
		
		// When
		List<ProductOrderPort> actualOrderList = storage.findByQuanityGreaterThan(QUANITY_MIN);
		
		// Then
		productOrderListAssertions(actualOrderList, expectedOrderList, expectedOrder_1, expectedOrder_2);
	}
	
	@Test
	void findByQuanityLessThan() {
		// Given
		ProductOrderPort expectedOrder_1 = createProductOrder();
		ProductOrderPort expectedOrder_2 = createProductOrder();
		
		List<ProductOrderPort> expectedOrderList = List.of(expectedOrder_1, expectedOrder_2);
		
		when(storage.findByQuanityLessThan(QUANITY_MAX)).thenReturn(expectedOrderList);
		
		// When
		List<ProductOrderPort> actualOrderList = storage.findByQuanityLessThan(QUANITY_MAX);
		
		// Then
		productOrderListAssertions(actualOrderList, expectedOrderList, expectedOrder_1, expectedOrder_2);
	}
	
	@Test
	void add() {
		// Given
		ProductOrderPort expectedToAdd = createProductOrder();
		
		ProductOrderPort expectedProduct = createProductOrder();
		
		when(storage.add(expectedToAdd)).thenReturn(expectedProduct);
		
		// When
		ProductOrderPort actualProduct = storage.add(expectedToAdd);
		
		// Then
		assertThat(actualProduct).isEqualTo(expectedProduct);
	}
	
	@Test
	void updateByObject() {
		// Given
		ProductOrderPort expectedToChange = createProductOrder(null);
		
		ProductOrderPort expectedProduct = createProductOrder();
		
		expectedToChange.setQuanity(PRODUCT_QUANITY);
		
		when(storage.update(expectedToChange)).thenReturn(expectedProduct);
		
		// When
		ProductOrderPort actualProduct = storage.update(expectedToChange);
		
		// Then
		assertThat(actualProduct).isEqualTo(expectedProduct);
	}
	
	@Test
	void updateById() {
		// Given
		ProductOrderPort expectedToChange = createProductOrder(null);
		
		ProductOrderPort expectedChanges = new ProductOrder();
		expectedChanges.setQuanity(PRODUCT_QUANITY);
		
		ProductOrderPort expectedProduct = createProductOrder();
		
		when(storage.update(expectedToChange.getId(), expectedChanges)).thenReturn(expectedProduct);
		
		// When
		ProductOrderPort actualProduct = storage.update(expectedToChange.getId(), expectedChanges);
		
		// Then
		assertThat(actualProduct).isEqualTo(expectedProduct);
	}
	
	@Test
	void updateOriginalAndChanges() {
		// Given
		ProductOrderPort expectedToChange = createProductOrder(null);
		
		ProductOrderPort expectedChanges = new ProductOrder();
		expectedChanges.setQuanity(PRODUCT_QUANITY);
		
		ProductOrderPort expectedProduct = createProductOrder();
		
		when(storage.update(expectedToChange, expectedChanges)).thenReturn(expectedProduct);
		
		// When
		ProductOrderPort actualProduct = storage.update(expectedToChange, expectedChanges);
		
		// Then
		assertThat(actualProduct).isEqualTo(expectedProduct);
	}
	
	@Test
	void remove() {
		// Given
		when(storage.remove(ID)).thenReturn(true);
		
		// When
		boolean actualProducts = storage.remove(ID);
		
		// Then
		assertThat(actualProducts).isTrue();
	}
	
	@Test
	void findById() {
		// Given
		ProductOrderPort expectedOrder_1 = createProductOrder();
		
		when(storage.findById(ID)).thenReturn(Optional.of(expectedOrder_1));
		
		// When
		ProductOrderPort actualProduct = storage.findById(ID)
		                                        .get();
		
		// Then
		assertThat(actualProduct).isEqualTo(expectedOrder_1);
	}
	
	@Test
	void findAll() {
		// Given
		ProductOrderPort expectedOrder_1 = createProductOrder();
		ProductOrderPort expectedOrder_2 = createProductOrder();
		
		List<ProductOrderPort> expectedOrderList = List.of(expectedOrder_1, expectedOrder_2);
		
		when(storage.findAll()).thenReturn(expectedOrderList);
		
		// When
		List<ProductOrderPort> actualProducts = storage.findAll();
		
		// Then
		assertThat(actualProducts).isEqualTo(expectedOrderList);
		assertThat(actualProducts.size()).isEqualTo(2);
		assertThat(actualProducts).containsExactlyInAnyOrder(expectedOrder_1, expectedOrder_2);
	}
	
	private void productOrderListAssertions(
		List<ProductOrderPort> actualOrderList, List<ProductOrderPort> expectedOrderList,
		ProductOrderPort expectedOrder_1, ProductOrderPort expectedOrder_2
	) {
		assertThat(actualOrderList).isEqualTo(expectedOrderList);
		assertThat(actualOrderList.size()).isEqualTo(expectedOrderList.size());
		assertThat(actualOrderList).containsExactlyInAnyOrder(expectedOrder_1, expectedOrder_2);
		assertThat(
			actualOrderList.stream()
			               .mapToDouble(ProductOrderPort::summaryPrice)
			               .sum()
		).isEqualTo(
			expectedOrderList.stream()
			                 .mapToDouble(ProductOrderPort::summaryPrice)
			                 .sum()
		);
	}
	
}