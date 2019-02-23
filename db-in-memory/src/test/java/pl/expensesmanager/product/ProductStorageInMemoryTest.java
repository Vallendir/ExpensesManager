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
class ProductStorageInMemoryTest extends AbstractDBInMemoryTest {
	
	private static final Double PRICE_MIN = PRODUCT_PRICE - 5;
	
	private static final Double PRICE_MAX = PRODUCT_PRICE + 5;
	
	@Mock
	private ProductStorageInMemory storage;
	
	@Test
	void findByName() {
		// Given
		ProductPort expectedProduct_1 = createProduct();
		
		when(storage.findByName(PRODUCT_NAME)).thenReturn(Optional.of(expectedProduct_1));
		
		// When
		ProductPort actualProduct = storage.findByName(PRODUCT_NAME)
		                                   .get();
		
		// Then
		assertThat(actualProduct).isEqualTo(expectedProduct_1);
	}
	
	@Test
	void findByPrice() {
		// Given
		ProductPort expectedProduct_1 = createProduct();
		ProductPort expectedProduct_2 = createProduct();
		
		List<ProductPort> expectedProductList = List.of(expectedProduct_1, expectedProduct_2);
		
		when(storage.findByPrice(PRODUCT_PRICE)).thenReturn(expectedProductList);
		
		// When
		List<ProductPort> actualProductList = storage.findByPrice(PRODUCT_PRICE);
		
		// Then
		productListAssertions(actualProductList, expectedProductList, expectedProduct_1, expectedProduct_2);
	}
	
	@Test
	void findByPriceBetween() {
		// Given
		ProductPort expectedProduct_1 = createProduct();
		ProductPort expectedProduct_2 = createProduct(PRODUCT_PRICE + 1.75);
		
		List<ProductPort> expectedProductList = List.of(expectedProduct_1, expectedProduct_2);
		
		when(storage.findByPriceBetween(PRICE_MIN, PRICE_MAX)).thenReturn(expectedProductList);
		
		// When
		List<ProductPort> actualProductList = storage.findByPriceBetween(PRICE_MIN, PRICE_MAX);
		
		// Then
		productListAssertions(actualProductList, expectedProductList, expectedProduct_1, expectedProduct_2);
	}
	
	@Test
	void findByPriceGreaterThan() {
		// Given
		ProductPort expectedProduct_1 = createProduct(PRODUCT_PRICE + 1.25);
		ProductPort expectedProduct_2 = createProduct(PRODUCT_PRICE + 1.55);
		
		List<ProductPort> expectedProductList = List.of(expectedProduct_1, expectedProduct_2);
		
		when(storage.findByPriceGreaterThan(PRODUCT_PRICE)).thenReturn(expectedProductList);
		
		// When
		List<ProductPort> actualProductList = storage.findByPriceGreaterThan(PRODUCT_PRICE);
		
		// Then
		productListAssertions(actualProductList, expectedProductList, expectedProduct_1, expectedProduct_2);
	}
	
	@Test
	void findByPriceLessThan() {
		// Given
		ProductPort expectedProduct_1 = createProduct();
		ProductPort expectedProduct_2 = createProduct(PRICE_MAX);
		
		List<ProductPort> expectedProductList = List.of(expectedProduct_1, expectedProduct_2);
		
		when(storage.findByPriceLessThan(PRICE_MAX)).thenReturn(expectedProductList);
		
		// When
		List<ProductPort> actualProductList = storage.findByPriceLessThan(PRICE_MAX);
		
		// Then
		productListAssertions(actualProductList, expectedProductList, expectedProduct_1, expectedProduct_2);
	}
	
	@Test
	void add() {
		// Given
		ProductPort expectedToAdd = createProduct();
		ProductPort expectedProduct = createProduct();
		
		when(storage.save(expectedToAdd)).thenReturn(expectedProduct);
		
		// When
		ProductPort actualProduct = storage.save(expectedToAdd);
		
		// Then
		assertThat(actualProduct).isEqualTo(expectedProduct);
	}
	
	@Test
	void findById() {
		// Given
		ProductPort expectedProduct = createProduct();
		
		when(storage.findById(ID)).thenReturn(Optional.of(expectedProduct));
		
		// When
		ProductPort actualProduct = storage.findById(ID)
		                                   .get();
		
		// Then
		assertThat(actualProduct).isEqualTo(expectedProduct);
	}
	
	@Test
	void findAll() {
		// Given
		ProductPort expectedProduct_1 = createProduct();
		ProductPort expectedProduct_2 = createProduct(PRICE_MAX);
		
		List<ProductPort> expectedProductList = List.of(expectedProduct_1, expectedProduct_2);
		
		when(storage.findAll()).thenReturn(expectedProductList);
		
		// When
		List<ProductPort> actualProductList = storage.findAll();
		
		// Then
		productListAssertions(actualProductList, expectedProductList, expectedProduct_1, expectedProduct_2);
	}
	
	private void productListAssertions(
		List<ProductPort> actualProductList, List<ProductPort> expectedProductList, ProductPort expectedProduct,
		ProductPort secondEpectedProduct
	) {
		assertThat(actualProductList).isEqualTo(expectedProductList);
		assertThat(actualProductList.size()).isEqualTo(2);
		assertThat(actualProductList).containsExactlyInAnyOrder(expectedProduct, secondEpectedProduct);
	}
	
}