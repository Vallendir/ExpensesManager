package pl.expensesmanager.product;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.expensesmanager.AbstractCoreTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductOrderServiceTest extends AbstractCoreTest {
	
	private static final Integer QUANITY_MIN = PRODUCT_QUANITY - 2;
	
	private static final Integer QUANITY_MAX = PRODUCT_QUANITY + 2;
	
	@Mock
	private ProductOrderStorePort storage;
	
	@InjectMocks
	private ProductOrderService service;
	
	@Test
	void searchAllForProductName() {
		// Given
		ProductOrderPort expectedOrder_1 = createProductOrder();
		ProductOrderPort expectedOrder_2 = createProductOrder();
		
		List<ProductOrderPort> expectedOrderList = List.of(expectedOrder_1, expectedOrder_2);
		
		when(storage.findByProductName(PRODUCT_NAME)).thenReturn(expectedOrderList);
		
		// When
		List<ProductOrderPort> actualOrderList = service.searchAllForProductName(PRODUCT_NAME);
		
		// Then
		productOrderListAssertions(actualOrderList, expectedOrderList, expectedOrder_1, expectedOrder_2);
	}
	
	@Test
	void searchAllForProductNameAndProductPrice() {
		// Given
		ProductOrderPort expectedOrder_1 = createProductOrder();
		ProductOrderPort expectedOrder_2 = createProductOrder();
		
		List<ProductOrderPort> expectedOrderList = List.of(expectedOrder_1, expectedOrder_2);
		
		when(storage.findByProductNameAndProductPrice(PRODUCT_NAME, PRODUCT_PRICE)).thenReturn(expectedOrderList);
		
		// When
		List<ProductOrderPort> actualOrderList = service.searchAllForProductNameAndProductPrice(
			PRODUCT_NAME, PRODUCT_PRICE);
		
		// Then
		productOrderListAssertions(actualOrderList, expectedOrderList, expectedOrder_1, expectedOrder_2);
	}
	
	@Test
	void searchAllForQuanityRange() {
		// Given
		ProductOrderPort expectedOrder_1 = createProductOrder();
		ProductOrderPort expectedOrder_2 = createProductOrder();
		
		List<ProductOrderPort> expectedOrderList = List.of(expectedOrder_1, expectedOrder_2);
		
		when(storage.findByQuanityBetween(QUANITY_MIN, QUANITY_MAX)).thenReturn(expectedOrderList);
		
		// When
		List<ProductOrderPort> actualOrderList = service.searchAllForQuanityRange(QUANITY_MIN, QUANITY_MAX);
		
		// Then
		productOrderListAssertions(actualOrderList, expectedOrderList, expectedOrder_1, expectedOrder_2);
	}
	
	@Test
	void searchAllForQuanityGreater() {
		// Given
		ProductOrderPort expectedOrder_1 = createProductOrder();
		ProductOrderPort expectedOrder_2 = createProductOrder();
		
		List<ProductOrderPort> expectedOrderList = List.of(expectedOrder_1, expectedOrder_2);
		
		when(storage.findByQuanityGreaterThan(QUANITY_MIN)).thenReturn(expectedOrderList);
		
		// When
		List<ProductOrderPort> actualOrderList = service.searchAllForQuanityGreater(QUANITY_MIN);
		
		// Then
		productOrderListAssertions(actualOrderList, expectedOrderList, expectedOrder_1, expectedOrder_2);
	}
	
	@Test
	void searchAllForQuanityLower() {
		// Given
		ProductOrderPort expectedOrder_1 = createProductOrder();
		ProductOrderPort expectedOrder_2 = createProductOrder();
		
		List<ProductOrderPort> expectedOrderList = List.of(expectedOrder_1, expectedOrder_2);
		
		when(storage.findByQuanityLessThan(QUANITY_MAX)).thenReturn(expectedOrderList);
		
		// When
		List<ProductOrderPort> actualOrderList = service.searchAllForQuanityLower(QUANITY_MAX);
		
		// Then
		productOrderListAssertions(actualOrderList, expectedOrderList, expectedOrder_1, expectedOrder_2);
	}
	
	@Test
	void create() {
		// Given
		ProductOrderPort expectedToAdd = createProductOrder();
		ProductOrderPort expectedOrder = createProductOrder();
		
		when(storage.add(expectedToAdd)).thenReturn(expectedOrder);
		
		// When
		ProductOrderPort actualOrder = service.create(expectedToAdd);
		
		// Then
		assertThat(actualOrder).isEqualTo(expectedOrder);
	}
	
	@Test
	void updateByObject() {
		// Given
		ProductOrderPort expectedToChange = createProductOrder(null);
		ProductOrderPort expectedOrder = createProductOrder();
		expectedToChange.setQuanity(PRODUCT_QUANITY);
		
		when(storage.update(expectedToChange)).thenReturn(expectedOrder);
		
		// When
		ProductOrderPort actualOrder = service.update(expectedToChange);
		
		// Then
		assertThat(actualOrder).isEqualTo(expectedOrder);
	}
	
	@Test
	void updateById() {
		// Given
		ProductOrderPort expectedToChange = createProductOrder(null);
		ProductOrderPort expectedChanges = new ProductOrder();
		expectedChanges.setQuanity(PRODUCT_QUANITY);
		
		ProductOrderPort expectedOrder = createProductOrder();
		
		when(storage.update(expectedToChange.getId(), expectedChanges)).thenReturn(expectedOrder);
		
		// When
		ProductOrderPort actualOrder = service.update(expectedChanges, expectedToChange.getId());
		
		// Then
		assertThat(actualOrder).isEqualTo(expectedOrder);
	}
	
	@Test
	void updateOriginalAndChanges() {
		// Given
		ProductOrderPort expectedToChange = createProductOrder(null);
		ProductOrderPort expectedChanges = new ProductOrder();
		expectedChanges.setQuanity(PRODUCT_QUANITY);
		ProductOrderPort expectedOrder = createProductOrder();
		
		when(storage.update(expectedToChange, expectedChanges)).thenReturn(expectedOrder);
		
		// When
		ProductOrderPort actualOrder = service.update(expectedToChange, expectedChanges);
		
		// Then
		assertThat(actualOrder).isEqualTo(expectedOrder);
	}
	
	@Test
	void delete() {
		// Given
		when(storage.remove(ID)).thenReturn(true);
		
		// When
		boolean actualOrderList = service.delete(ID);
		
		// Then
		assertThat(actualOrderList).isTrue();
	}
	
	@Test
	void searchForId() {
		// Given
		ProductOrderPort expectedOrder_1 = createProductOrder();
		
		when(storage.findById(ID)).thenReturn(Optional.of(expectedOrder_1));
		
		// When
		ProductOrderPort actualOrder = service.searchForId(ID)
		                                      .get();
		
		// Then
		assertThat(actualOrder).isEqualTo(expectedOrder_1);
	}
	
	@Test
	void searchAll() {
		// Given
		ProductOrderPort expectedOrder_1 = createProductOrder();
		ProductOrderPort expectedOrder_2 = createProductOrder();
		
		List<ProductOrderPort> expectedOrderList = List.of(expectedOrder_1, expectedOrder_2);
		
		when(storage.findAll()).thenReturn(expectedOrderList);
		
		// When
		List<ProductOrderPort> actualOrderList = service.searchAll();
		
		// Then
		productOrderListAssertions(actualOrderList, expectedOrderList, expectedOrder_1, expectedOrder_2);
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