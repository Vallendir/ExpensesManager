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
class ProductRepositoryMongoTest extends AbstractMongoDBTest {
	
	private static final Double PRICE_MIN = PRODUCT_PRICE - 5;
	
	private static final Double PRICE_MAX = PRODUCT_PRICE + 5;
	
	@Mock
	private ProductRepositoryMongo storage;
	
	@Test
	void findByName() {
		// Given
		ProductDocument expectedProduct_1 = createProduct();
		List<ProductDocument> expectedProduct = List.of(expectedProduct_1);
		
		when(storage.findByName(PRODUCT_NAME)).thenReturn(expectedProduct);
		
		// When
		List<ProductDocument> actualProduct = storage.findByName(PRODUCT_NAME);
		
		// Then
		assertThat(actualProduct).isEqualTo(expectedProduct);
	}
	
	@Test
	void findByPrice() {
		// Given
		ProductDocument expectedProduct_1 = createProduct();
		ProductDocument expectedProduct_2 = createProduct();
		
		List<ProductDocument> expectedProductList = List.of(expectedProduct_1, expectedProduct_2);
		
		when(storage.findByPrice(PRODUCT_PRICE)).thenReturn(expectedProductList);
		
		// When
		List<ProductDocument> actualProductList = storage.findByPrice(PRODUCT_PRICE);
		
		// Then
		productListAssertions(actualProductList, expectedProductList, expectedProduct_1, expectedProduct_2);
	}
	
	@Test
	void findByPriceBetween() {
		// Given
		ProductDocument expectedProduct_1 = createProduct();
		ProductDocument expectedProduct_2 = createProduct(PRODUCT_PRICE + 1.75);
		
		List<ProductDocument> expectedProductList = List.of(expectedProduct_1, expectedProduct_2);
		
		when(storage.findByPriceBetween(PRICE_MIN, PRICE_MAX)).thenReturn(expectedProductList);
		
		// When
		List<ProductDocument> actualProductList = storage.findByPriceBetween(PRICE_MIN, PRICE_MAX);
		
		// Then
		productListAssertions(actualProductList, expectedProductList, expectedProduct_1, expectedProduct_2);
	}
	
	@Test
	void findByPriceGreaterThan() {
		// Given
		ProductDocument expectedProduct_1 = createProduct(PRODUCT_PRICE + 1.25);
		ProductDocument expectedProduct_2 = createProduct(PRODUCT_PRICE + 1.55);
		
		List<ProductDocument> expectedProductList = List.of(expectedProduct_1, expectedProduct_2);
		
		when(storage.findByPriceGreaterThan(PRODUCT_PRICE)).thenReturn(expectedProductList);
		
		// When
		List<ProductDocument> actualProductList = storage.findByPriceGreaterThan(PRODUCT_PRICE);
		
		// Then
		productListAssertions(actualProductList, expectedProductList, expectedProduct_1, expectedProduct_2);
	}
	
	@Test
	void findByPriceLessThan() {
		// Given
		ProductDocument expectedProduct_1 = createProduct();
		ProductDocument expectedProduct_2 = createProduct(PRICE_MAX);
		
		List<ProductDocument> expectedProductList = List.of(expectedProduct_1, expectedProduct_2);
		
		when(storage.findByPriceLessThan(PRICE_MAX)).thenReturn(expectedProductList);
		
		// When
		List<ProductDocument> actualProductList = storage.findByPriceLessThan(PRICE_MAX);
		
		// Then
		productListAssertions(actualProductList, expectedProductList, expectedProduct_1, expectedProduct_2);
	}
	
	@Test
	void add() {
		// Given
		ProductDocument expectedToAdd = createProduct();
		ProductDocument expectedProduct = createProduct();
		
		when(storage.save(expectedToAdd)).thenReturn(expectedProduct);
		
		// When
		ProductDocument actualProduct = storage.save(expectedToAdd);
		
		// Then
		assertThat(actualProduct).isEqualTo(expectedProduct);
	}
	
	@Test
	void findById() {
		// Given
		ProductDocument expectedProduct = createProduct();
		
		when(storage.findById(ID)).thenReturn(Optional.of(expectedProduct));
		
		// When
		ProductDocument actualProduct = storage.findById(ID)
		                                       .get();
		
		// Then
		assertThat(actualProduct).isEqualTo(expectedProduct);
	}
	
	@Test
	void findAll() {
		// Given
		ProductDocument expectedProduct_1 = createProduct();
		ProductDocument expectedProduct_2 = createProduct(PRICE_MAX);
		
		List<ProductDocument> expectedProductList = List.of(expectedProduct_1, expectedProduct_2);
		
		when(storage.findAll()).thenReturn(expectedProductList);
		
		// When
		List<ProductDocument> actualProductList = storage.findAll();
		
		// Then
		productListAssertions(actualProductList, expectedProductList, expectedProduct_1, expectedProduct_2);
	}
	
	private void productListAssertions(
		List<ProductDocument> actualProductList, List<ProductDocument> expectedProductList,
		ProductDocument expectedProduct, ProductDocument secondEpectedProduct
	) {
		assertThat(actualProductList).isEqualTo(expectedProductList);
		assertThat(actualProductList.size()).isEqualTo(2);
		assertThat(actualProductList).containsExactlyInAnyOrder(expectedProduct, secondEpectedProduct);
	}
	
}
