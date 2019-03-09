package pl.expensesmanager.product;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.expensesmanager.AbstractMongoDBTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductOrderRepositoryMongoTest extends AbstractMongoDBTest {
	
	private static final Integer QUANITY_MIN = PRODUCT_QUANITY - 4;
	
	private static final Integer QUANITY_MAX = PRODUCT_QUANITY + 4;
	
	@Mock
	private ProductOrderRepositoryMongo storage;
	
	@Test
	void findByProductName() {
		// Given
		ProductOrderDocument expectedOrder_1 = createProductOrder();
		ProductOrderDocument expectedOrder_2 = createProductOrder();
		
		List<ProductOrderDocument> expectedOrderList = List.of(expectedOrder_1, expectedOrder_2);
		
		when(storage.findByProductName(PRODUCT_NAME)).thenReturn(expectedOrderList);
		
		// When
		List<ProductOrderDocument> actualOrderList = storage.findByProductName(PRODUCT_NAME);
		
		// Then
		productOrderListAssertions(actualOrderList, expectedOrderList, expectedOrder_1, expectedOrder_2);
	}
	
	@Test
	void findByProductNameAndProductPrice() {
		// Given
		ProductOrderDocument expectedOrder_1 = createProductOrder();
		
		when(storage.findByProductNameAndProductPrice(PRODUCT_NAME, PRODUCT_PRICE)).thenReturn(
			Optional.of(expectedOrder_1));
		
		// When
		Optional<ProductOrderDocument> actualOrderList = storage.findByProductNameAndProductPrice(
			PRODUCT_NAME, PRODUCT_PRICE);
		
		// Then
		assertThat(actualOrderList.get()).isEqualTo(expectedOrder_1);
	}
	
	@Test
	void findByQuanityBetween() {
		// Given
		ProductOrderDocument expectedOrder_1 = createProductOrder();
		ProductOrderDocument expectedOrder_2 = createProductOrder();
		
		List<ProductOrderDocument> expectedOrderList = List.of(expectedOrder_1, expectedOrder_2);
		
		when(storage.findByQuanityBetween(QUANITY_MIN, QUANITY_MAX)).thenReturn(expectedOrderList);
		
		// When
		List<ProductOrderDocument> actualOrderList = storage.findByQuanityBetween(QUANITY_MIN, QUANITY_MAX);
		
		// Then
		productOrderListAssertions(actualOrderList, expectedOrderList, expectedOrder_1, expectedOrder_2);
	}
	
	@Test
	void findByQuanityGreaterThan() {
		// Given
		ProductOrderDocument expectedOrder_1 = createProductOrder();
		ProductOrderDocument expectedOrder_2 = createProductOrder();
		
		List<ProductOrderDocument> expectedOrderList = List.of(expectedOrder_1, expectedOrder_2);
		
		when(storage.findByQuanityGreaterThan(QUANITY_MIN)).thenReturn(expectedOrderList);
		
		// When
		List<ProductOrderDocument> actualOrderList = storage.findByQuanityGreaterThan(QUANITY_MIN);
		
		// Then
		productOrderListAssertions(actualOrderList, expectedOrderList, expectedOrder_1, expectedOrder_2);
	}
	
	@Test
	void findByQuanityLessThan() {
		// Given
		ProductOrderDocument expectedOrder_1 = createProductOrder();
		ProductOrderDocument expectedOrder_2 = createProductOrder();
		
		List<ProductOrderDocument> expectedOrderList = List.of(expectedOrder_1, expectedOrder_2);
		
		when(storage.findByQuanityLessThan(QUANITY_MAX)).thenReturn(expectedOrderList);
		
		// When
		List<ProductOrderDocument> actualOrderList = storage.findByQuanityLessThan(QUANITY_MAX);
		
		// Then
		productOrderListAssertions(actualOrderList, expectedOrderList, expectedOrder_1, expectedOrder_2);
	}
	
	@Test
	void add() {
		// Given
		ProductOrderDocument expectedToAdd = createProductOrder();
		
		ProductOrderDocument expectedProduct = createProductOrder();
		
		when(storage.save(expectedToAdd)).thenReturn(expectedProduct);
		
		// When
		ProductOrderDocument actualProduct = storage.save(expectedToAdd);
		
		// Then
		assertThat(actualProduct).isEqualTo(expectedProduct);
	}
	
	@Test
	void findById() {
		// Given
		ProductOrderDocument expectedOrder_1 = createProductOrder();
		
		when(storage.findById(ID)).thenReturn(Optional.of(expectedOrder_1));
		
		// When
		ProductOrderDocument actualProduct = storage.findById(ID)
		                                            .get();
		
		// Then
		assertThat(actualProduct).isEqualTo(expectedOrder_1);
	}
	
	@Test
	void findAll() {
		// Given
		ProductOrderDocument expectedOrder_1 = createProductOrder();
		ProductOrderDocument expectedOrder_2 = createProductOrder();
		
		List<ProductOrderDocument> expectedOrderList = List.of(expectedOrder_1, expectedOrder_2);
		
		when(storage.findAll()).thenReturn(expectedOrderList);
		
		// When
		List<ProductOrderDocument> actualProducts = storage.findAll();
		
		// Then
		assertThat(actualProducts).isEqualTo(expectedOrderList);
		assertThat(actualProducts.size()).isEqualTo(2);
		assertThat(actualProducts).containsExactlyInAnyOrder(expectedOrder_1, expectedOrder_2);
	}
	
	private void productOrderListAssertions(
		List<ProductOrderDocument> actualOrderList, List<ProductOrderDocument> expectedOrderList,
		ProductOrderDocument expectedOrder_1, ProductOrderDocument expectedOrder_2
	) {
		assertThat(actualOrderList).isEqualTo(expectedOrderList);
		assertThat(actualOrderList.size()).isEqualTo(expectedOrderList.size());
		assertThat(actualOrderList).containsExactlyInAnyOrder(expectedOrder_1, expectedOrder_2);
	}
	
}
