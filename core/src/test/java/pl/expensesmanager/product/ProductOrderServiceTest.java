package pl.expensesmanager.product;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductOrderServiceTest {
	
	private static final Integer PRODUCT_ORDER_QUANITY = 10;
	
	private static final String PRODUCT_NAME = "Test name";
	
	private static final Double PRODUCT_PRICE = 13.2;
	
	@Mock
	private ProductOrderStorePort storage;
	
	@InjectMocks
	private ProductOrderService service;
	
	@Test
	void searchAllForProductName() {
		// Given
		ProductOrderPort expectedOrder = createProductOrder();
		
		when(storage.findByProductName(any())).thenReturn(List.of(expectedOrder));
		
		// When
		List<ProductOrderPort> actualOrders = service.searchAllForProductName(PRODUCT_NAME);
		
		// Then
		assertThat(actualOrders).isEqualTo(List.of(expectedOrder));
		assertThat(actualOrders.size()).isEqualTo(1);
		assertThat(actualOrders).containsExactlyInAnyOrder(expectedOrder);
	}
	
	@Test
	void searchAllForProductNameAndProductPrice() {
		// Given
		ProductOrderPort expectedOrder = createProductOrder();
		
		when(storage.findByProductNameAndProductPrice(any(), any())).thenReturn(List.of(expectedOrder));
		
		// When
		List<ProductOrderPort> actualOrders = service.searchAllForProductNameAndProductPrice(
			PRODUCT_NAME, PRODUCT_PRICE);
		
		// Then
		assertThat(actualOrders).isEqualTo(List.of(expectedOrder));
		assertThat(actualOrders.size()).isEqualTo(1);
		assertThat(actualOrders).containsExactlyInAnyOrder(expectedOrder);
	}
	
	@Test
	void searchAllForQuanityRange() {
		// Given
		ProductOrderPort expectedOrder = createProductOrder();
		ProductOrderPort secondExpectedOrder = createProductOrder();
		
		when(storage.findByQuanityBetween(any(), any())).thenReturn(List.of(expectedOrder, secondExpectedOrder));
		
		// When
		List<ProductOrderPort> actualOrders = service.searchAllForQuanityRange(1, 3);
		
		// Then
		assertThat(actualOrders).isEqualTo(List.of(expectedOrder, secondExpectedOrder));
		assertThat(actualOrders.size()).isEqualTo(2);
		assertThat(actualOrders).containsExactlyInAnyOrder(expectedOrder, secondExpectedOrder);
	}
	
	@Test
	void searchAllForQuanityGreater() {
		// Given
		ProductOrderPort expectedOrder = createProductOrder();
		
		when(storage.findByQuanityGreaterThan(any())).thenReturn(List.of(expectedOrder));
		
		// When
		List<ProductOrderPort> actualOrders = service.searchAllForQuanityGreater(1);
		
		// Then
		assertThat(actualOrders).isEqualTo(List.of(expectedOrder));
		assertThat(actualOrders.size()).isEqualTo(1);
		assertThat(actualOrders).containsExactlyInAnyOrder(expectedOrder);
	}
	
	@Test
	void searchAllForQuanityLower() {
		// Given
		ProductOrderPort expectedOrder = createProductOrder();
		ProductOrderPort secondExpectedOrder = createProductOrder();
		
		when(storage.findByQuanityLessThan(any())).thenReturn(List.of(expectedOrder, secondExpectedOrder));
		
		// When
		List<ProductOrderPort> actualOrders = service.searchAllForQuanityLower(6);
		
		// Then
		assertThat(actualOrders).isEqualTo(List.of(expectedOrder, secondExpectedOrder));
		assertThat(actualOrders.size()).isEqualTo(2);
		assertThat(actualOrders).containsExactlyInAnyOrder(expectedOrder, secondExpectedOrder);
	}
	
	@Test
	void create() {
		// Given
		ProductOrderPort expectedToAdd = createProductOrder();
		
		ProductOrderPort expectedProduct = createProductOrder();
		
		when(storage.add(expectedToAdd)).thenReturn(expectedProduct);
		
		// When
		ProductOrderPort actualOrder = service.create(expectedToAdd);
		
		// Then
		assertThat(actualOrder).isEqualTo(expectedProduct);
	}
	
	@Test
	void updateByObject() {
		// Given
		ProductOrderPort expectedToChange = createProductOrder(null);
		
		ProductOrderPort expectedProduct = createProductOrder();
		
		expectedToChange.setQuanity(PRODUCT_ORDER_QUANITY);
		
		when(storage.update(expectedToChange)).thenReturn(expectedProduct);
		
		// When
		ProductOrderPort actualOrder = service.update(expectedToChange);
		
		// Then
		assertThat(actualOrder).isEqualTo(expectedProduct);
	}
	
	@Test
	void updateById() {
		// Given
		ProductOrderPort expectedToChange = createProductOrder(null);
		
		ProductOrderPort expectedChanges = new ProductOrder();
		expectedChanges.setQuanity(PRODUCT_ORDER_QUANITY);
		
		ProductOrderPort expectedProduct = createProductOrder();
		
		when(storage.update(expectedToChange.getId(), expectedChanges)).thenReturn(expectedProduct);
		
		// When
		ProductOrderPort actualOrder = service.update(expectedChanges, expectedToChange.getId());
		
		// Then
		assertThat(actualOrder).isEqualTo(expectedProduct);
	}
	
	@Test
	void updateOriginalAndChanges() {
		// Given
		ProductOrderPort expectedToChange = createProductOrder(null);
		
		ProductOrderPort expectedChanges = new ProductOrder();
		expectedChanges.setQuanity(PRODUCT_ORDER_QUANITY);
		
		ProductOrderPort expectedProduct = createProductOrder();
		
		when(storage.update(expectedToChange, expectedChanges)).thenReturn(expectedProduct);
		
		// When
		ProductOrderPort actualOrder = service.update(expectedToChange, expectedChanges);
		
		// Then
		assertThat(actualOrder).isEqualTo(expectedProduct);
	}
	
	@Test
	void delete() {
		// Given
		ProductOrderPort expectedOrder = createProductOrder();
		
		when(storage.remove(expectedOrder.getId())).thenReturn(true);
		
		// When
		boolean actualOrders = service.delete(expectedOrder.getId());
		
		// Then
		assertThat(actualOrders).isTrue();
	}
	
	@Test
	void searchForId() {
		// Given
		ProductOrderPort expectedOrder = createProductOrder();
		
		when(storage.findById(expectedOrder.getId())).thenReturn(Optional.of(expectedOrder));
		
		// When
		ProductOrderPort actualOrder = service.searchForId(expectedOrder.getId())
		                                      .get();
		
		// Then
		assertThat(actualOrder).isEqualTo(expectedOrder);
	}
	
	@Test
	void searchAll() {
		// Given
		ProductOrderPort expectedOrder = createProductOrder();
		ProductOrderPort secondExpectedOrder = createProductOrder();
		
		when(storage.findAll()).thenReturn(List.of(expectedOrder, secondExpectedOrder));
		
		// When
		List<ProductOrderPort> actualOrders = service.searchAll();
		
		// Then
		assertThat(actualOrders).isEqualTo(List.of(expectedOrder, secondExpectedOrder));
		assertThat(actualOrders.size()).isEqualTo(2);
		assertThat(actualOrders).containsExactlyInAnyOrder(expectedOrder, secondExpectedOrder);
	}
	
	private ProductOrderPort createProductOrder(Integer quanity) {
		ProductPort product = new Product();
		product.setName(PRODUCT_NAME);
		product.setPrice(PRODUCT_PRICE);
		
		return new ProductOrder(product, quanity);
	}
	
	private ProductOrderPort createProductOrder() {
		return createProductOrder(PRODUCT_ORDER_QUANITY);
	}
	
}