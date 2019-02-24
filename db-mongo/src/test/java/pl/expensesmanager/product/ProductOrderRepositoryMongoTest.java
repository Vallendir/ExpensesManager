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
		ProductOrder expectedOrder_1 = createProductOrder();
		ProductOrder expectedOrder_2 = createProductOrder();
		
		List<ProductOrder> expectedOrderList = List.of(expectedOrder_1, expectedOrder_2);
		
		when(storage.findByProductName(PRODUCT_NAME)).thenReturn(expectedOrderList);
		
		// When
		List<ProductOrder> actualOrderList = storage.findByProductName(PRODUCT_NAME);
		
		// Then
		productOrderListAssertions(actualOrderList, expectedOrderList, expectedOrder_1, expectedOrder_2);
	}
	
	@Test
	void findByProductNameAndProductPrice() {
		// Given
		ProductOrder expectedOrder_1 = createProductOrder();
		ProductOrder expectedOrder_2 = createProductOrder();
		
		List<ProductOrder> expectedOrderList = List.of(expectedOrder_1, expectedOrder_2);
		
		when(storage.findByProductNameAndProductPrice(PRODUCT_NAME, PRODUCT_PRICE)).thenReturn(expectedOrderList);
		
		// When
		List<ProductOrder> actualOrderList = storage.findByProductNameAndProductPrice(PRODUCT_NAME, PRODUCT_PRICE);
		
		// Then
		productOrderListAssertions(actualOrderList, expectedOrderList, expectedOrder_1, expectedOrder_2);
	}
	
	@Test
	void findByQuanityBetween() {
		// Given
		ProductOrder expectedOrder_1 = createProductOrder();
		ProductOrder expectedOrder_2 = createProductOrder();
		
		List<ProductOrder> expectedOrderList = List.of(expectedOrder_1, expectedOrder_2);
		
		when(storage.findByQuanityBetween(QUANITY_MIN, QUANITY_MAX)).thenReturn(expectedOrderList);
		
		// When
		List<ProductOrder> actualOrderList = storage.findByQuanityBetween(QUANITY_MIN, QUANITY_MAX);
		
		// Then
		productOrderListAssertions(actualOrderList, expectedOrderList, expectedOrder_1, expectedOrder_2);
	}
	
	@Test
	void findByQuanityGreaterThan() {
		// Given
		ProductOrder expectedOrder_1 = createProductOrder();
		ProductOrder expectedOrder_2 = createProductOrder();
		
		List<ProductOrder> expectedOrderList = List.of(expectedOrder_1, expectedOrder_2);
		
		when(storage.findByQuanityGreaterThan(QUANITY_MIN)).thenReturn(expectedOrderList);
		
		// When
		List<ProductOrder> actualOrderList = storage.findByQuanityGreaterThan(QUANITY_MIN);
		
		// Then
		productOrderListAssertions(actualOrderList, expectedOrderList, expectedOrder_1, expectedOrder_2);
	}
	
	@Test
	void findByQuanityLessThan() {
		// Given
		ProductOrder expectedOrder_1 = createProductOrder();
		ProductOrder expectedOrder_2 = createProductOrder();
		
		List<ProductOrder> expectedOrderList = List.of(expectedOrder_1, expectedOrder_2);
		
		when(storage.findByQuanityLessThan(QUANITY_MAX)).thenReturn(expectedOrderList);
		
		// When
		List<ProductOrder> actualOrderList = storage.findByQuanityLessThan(QUANITY_MAX);
		
		// Then
		productOrderListAssertions(actualOrderList, expectedOrderList, expectedOrder_1, expectedOrder_2);
	}
	
	@Test
	void add() {
		// Given
		ProductOrder expectedToAdd = createProductOrder();
		
		ProductOrder expectedProduct = createProductOrder();
		
		when(storage.save(expectedToAdd)).thenReturn(expectedProduct);
		
		// When
		ProductOrder actualProduct = storage.save(expectedToAdd);
		
		// Then
		assertThat(actualProduct).isEqualTo(expectedProduct);
	}
	
	@Test
	void findById() {
		// Given
		ProductOrder expectedOrder_1 = createProductOrder();
		
		when(storage.findById(ID)).thenReturn(Optional.of(expectedOrder_1));
		
		// When
		ProductOrder actualProduct = storage.findById(ID)
		                                        .get();
		
		// Then
		assertThat(actualProduct).isEqualTo(expectedOrder_1);
	}
	
	@Test
	void findAll() {
		// Given
		ProductOrder expectedOrder_1 = createProductOrder();
		ProductOrder expectedOrder_2 = createProductOrder();
		
		List<ProductOrder> expectedOrderList = List.of(expectedOrder_1, expectedOrder_2);
		
		when(storage.findAll()).thenReturn(expectedOrderList);
		
		// When
		List<ProductOrder> actualProducts = storage.findAll();
		
		// Then
		assertThat(actualProducts).isEqualTo(expectedOrderList);
		assertThat(actualProducts.size()).isEqualTo(2);
		assertThat(actualProducts).containsExactlyInAnyOrder(expectedOrder_1, expectedOrder_2);
	}
	
	private void productOrderListAssertions(
		List<ProductOrder> actualOrderList, List<ProductOrder> expectedOrderList,
		ProductOrder expectedOrder_1, ProductOrder expectedOrder_2
	) {
		assertThat(actualOrderList).isEqualTo(expectedOrderList);
		assertThat(actualOrderList.size()).isEqualTo(expectedOrderList.size());
		assertThat(actualOrderList).containsExactlyInAnyOrder(expectedOrder_1, expectedOrder_2);
		assertThat(actualOrderList.stream()
		                          .mapToDouble(ProductOrder::summaryPrice)
		                          .sum()).isEqualTo(expectedOrderList.stream()
		                                                             .mapToDouble(ProductOrder::summaryPrice)
		                                                             .sum());
	}
	
}