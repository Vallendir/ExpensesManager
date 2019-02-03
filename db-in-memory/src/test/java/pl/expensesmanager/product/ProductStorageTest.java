package pl.expensesmanager.product;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductStorageTest {
	
	private static final String PRODUCT_ID = "ID_TEST";
	
	private static final String PRODUCT_NAME = "NAME_TEST";
	
	private static final Double PRODUCT_PRICE = 5.75;
	
	@Mock
	private ProductStorage storage;
	
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
		
		when(storage.findByPrice(PRODUCT_PRICE)).thenReturn(List.of(expectedProduct_1));
		
		// When
		List<ProductPort> actualProducts = storage.findByPrice(PRODUCT_PRICE);
		
		// Then
		assertThat(actualProducts).isEqualTo(List.of(expectedProduct_1));
		assertThat(actualProducts.size()).isEqualTo(1);
		assertThat(actualProducts).containsExactlyInAnyOrder(expectedProduct_1);
	}
	
	@Test
	void findByPriceBetween() {
		// Given
		ProductPort expectedProduct_1 = createProduct();
		ProductPort expectedProduct_2 = createProduct(5.32);
		
		when(storage.findByPriceBetween(any(), any())).thenReturn(List.of(expectedProduct_1, expectedProduct_2));
		
		// When
		List<ProductPort> actualProducts = storage.findByPriceBetween(5.0, 6.0);
		
		// Then
		assertThat(actualProducts).isEqualTo(List.of(expectedProduct_1, expectedProduct_2));
		assertThat(actualProducts.size()).isEqualTo(2);
		assertThat(actualProducts).containsExactlyInAnyOrder(expectedProduct_1, expectedProduct_2);
	}
	
	@Test
	void findByPriceGreaterThan() {
		// Given
		ProductPort expectedProduct_1 = createProduct();
		ProductPort expectedProduct_2 = createProduct(5.8);
		
		when(storage.findByPriceGreaterThan(any())).thenReturn(List.of(expectedProduct_1, expectedProduct_2));
		
		// When
		List<ProductPort> actualProducts = storage.findByPriceGreaterThan(5.0);
		
		// Then
		assertThat(actualProducts).isEqualTo(List.of(expectedProduct_1, expectedProduct_2));
		assertThat(actualProducts.size()).isEqualTo(2);
		assertThat(actualProducts).containsExactlyInAnyOrder(expectedProduct_1, expectedProduct_2);
	}
	
	@Test
	void findByPriceLessThan() {
		// Given
		ProductPort expectedProduct_1 = createProduct();
		ProductPort expectedProduct_2 = createProduct();
		
		when(storage.findByPriceLessThan(any())).thenReturn(List.of(expectedProduct_1, expectedProduct_2));
		
		// When
		List<ProductPort> actualProducts = storage.findByPriceLessThan(6.0);
		
		// Then
		assertThat(actualProducts).isEqualTo(List.of(expectedProduct_1, expectedProduct_2));
		assertThat(actualProducts.size()).isEqualTo(2);
		assertThat(actualProducts).containsExactlyInAnyOrder(expectedProduct_1, expectedProduct_2);
	}
	
	@Test
	void add() {
		// Given
		ProductPort expectedToAdd = createProduct();
		
		ProductPort expectedProduct = createProduct();
		
		when(storage.add(expectedToAdd)).thenReturn(expectedProduct);
		
		// When
		ProductPort actualProduct = storage.add(expectedToAdd);
		
		// Then
		assertThat(actualProduct).isEqualTo(expectedProduct);
	}
	
	@Test
	void updateByObject() {
		// Given
		ProductPort expectedToChange = createProduct(null);
		
		ProductPort expectedProduct = createProduct();
		
		expectedToChange.setPrice(PRODUCT_PRICE);
		
		when(storage.update(expectedToChange)).thenReturn(expectedProduct);
		
		// When
		ProductPort actualProduct = storage.update(expectedToChange);
		
		// Then
		assertThat(actualProduct).isEqualTo(expectedProduct);
	}
	
	@Test
	void updateById() {
		// Given
		ProductPort expectedToChange = createProduct(null);
		
		ProductPort expectedChanges = new Product();
		expectedChanges.setPrice(PRODUCT_PRICE);
		
		ProductPort expectedProduct = createProduct();
		
		when(storage.update(expectedToChange.getId(), expectedChanges)).thenReturn(expectedProduct);
		
		// When
		ProductPort actualProduct = storage.update(expectedToChange.getId(), expectedChanges);
		
		// Then
		assertThat(actualProduct).isEqualTo(expectedProduct);
	}
	
	@Test
	void updateOriginalAndChanges() {
		// Given
		ProductPort expectedToChange = new Product();
		expectedToChange.setName(PRODUCT_NAME);
		
		ProductPort expectedChanges = new Product();
		expectedChanges.setPrice(PRODUCT_PRICE);
		
		ProductPort expectedProduct = new Product();
		expectedProduct.setName(PRODUCT_NAME);
		expectedProduct.setPrice(PRODUCT_PRICE);
		
		when(storage.update(expectedToChange, expectedChanges)).thenReturn(expectedProduct);
		
		// When
		ProductPort actualProduct = storage.update(expectedToChange, expectedChanges);
		
		// Then
		assertThat(actualProduct).isEqualTo(expectedProduct);
	}
	
	@Test
	void remove() {
		// Given
		ProductPort expectedProduct_1 = createProduct();
		
		when(storage.remove(expectedProduct_1.getId())).thenReturn(true);
		
		// When
		boolean actualProducts = storage.remove(expectedProduct_1.getId());
		
		// Then
		assertThat(actualProducts).isTrue();
	}
	
	@Test
	void findById() {
		// Given
		ProductPort expectedProduct_1 = createProduct();
		
		when(storage.findById(expectedProduct_1.getId())).thenReturn(Optional.of(expectedProduct_1));
		
		// When
		ProductPort actualProduct = storage.findById(expectedProduct_1.getId())
		                                   .get();
		
		// Then
		assertThat(actualProduct).isEqualTo(expectedProduct_1);
	}
	
	@Test
	void findAll() {
		// Given
		ProductPort expectedProduct_1 = createProduct();
		ProductPort expectedProduct_2 = createProduct();
		
		when(storage.findAll()).thenReturn(List.of(expectedProduct_1, expectedProduct_2));
		
		// When
		List<ProductPort> actualProducts = storage.findAll();
		
		// Then
		assertThat(actualProducts).isEqualTo(List.of(expectedProduct_1, expectedProduct_2));
		assertThat(actualProducts.size()).isEqualTo(2);
		assertThat(actualProducts).containsExactlyInAnyOrder(expectedProduct_1, expectedProduct_2);
	}
	
	private ProductPort createProduct(String id, String name, Double price) {
		ProductPort expectedProduct = new Product();
		expectedProduct.setId(id);
		expectedProduct.setName(name);
		expectedProduct.setPrice(price);
		
		return expectedProduct;
	}
	
	private ProductPort createProduct(Double price) {
		return createProduct(PRODUCT_ID, PRODUCT_NAME, price);
	}
	
	private ProductPort createProduct() {
		return createProduct(PRODUCT_ID, PRODUCT_NAME, PRODUCT_PRICE);
	}
	
}