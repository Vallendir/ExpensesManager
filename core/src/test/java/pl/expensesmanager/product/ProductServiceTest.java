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
class ProductServiceTest {
	
	private static final String PRODUCT_ID = "PRODUCT_ID_TEST";
	
	private static final String PRODUCT_NAME = "PRODUCT_NAME_TEST";
	
	private static final Double PRODUCT_PRICE = 10.25;
	
	@Mock
	private ProductStorePort storage;
	
	@InjectMocks
	private ProductService service;
	
	@Test
	void searchForName() {
		// Given
		ProductPort expectedProduct = createProduct();
		
		when(storage.findByName(PRODUCT_NAME)).thenReturn(Optional.of(expectedProduct));
		
		// When
		ProductPort actualProduct = service.searchForName(PRODUCT_NAME)
		                                   .get();
		
		// Then
		assertThat(actualProduct).isEqualTo(expectedProduct);
	}
	
	@Test
	void searchAllForPriceRange() {
		// Given
		ProductPort expectedProduct = createProduct();
		ProductPort secondEpectedProduct = createProduct(8.95);
		
		when(storage.findByPriceBetween(any(), any())).thenReturn(List.of(expectedProduct, secondEpectedProduct));
		
		// When
		List<ProductPort> actualProducts = service.searchAllForPriceRange(8.0, 11.0);
		
		// Then
		assertThat(actualProducts).isEqualTo(List.of(expectedProduct, secondEpectedProduct));
		assertThat(actualProducts.size()).isEqualTo(2);
		assertThat(actualProducts).containsExactlyInAnyOrder(expectedProduct, secondEpectedProduct);
	}
	
	@Test
	void searchAllForPriceGreater() {
		// Given
		ProductPort expectedProduct = createProduct();
		ProductPort secondEpectedProduct = createProduct(10.35);
		
		when(storage.findByPriceGreaterThan(any())).thenReturn(List.of(expectedProduct, secondEpectedProduct));
		
		// When
		List<ProductPort> actualProducts = service.searchAllForPriceGreater(10.20);
		
		// Then
		assertThat(actualProducts).isEqualTo(List.of(expectedProduct, secondEpectedProduct));
		assertThat(actualProducts.size()).isEqualTo(2);
		assertThat(actualProducts).containsExactlyInAnyOrder(expectedProduct, secondEpectedProduct);
	}
	
	@Test
	void searchAllForPriceLower() {
		// Given
		ProductPort expectedProduct = createProduct();
		ProductPort secondEpectedProduct = createProduct();
		
		when(storage.findByPriceLessThan(any())).thenReturn(List.of(expectedProduct, secondEpectedProduct));
		
		// When
		List<ProductPort> actualProducts = service.searchAllForPriceLower(15.0);
		
		// Then
		assertThat(actualProducts).isEqualTo(List.of(expectedProduct, secondEpectedProduct));
		assertThat(actualProducts.size()).isEqualTo(2);
		assertThat(actualProducts).containsExactlyInAnyOrder(expectedProduct, secondEpectedProduct);
	}
	
	@Test
	void create() {
		// Given
		ProductPort expectedToAdd = createProduct();
		
		ProductPort expectedProduct = createProduct();
		
		when(storage.add(expectedToAdd)).thenReturn(expectedProduct);
		
		// When
		ProductPort actualProduct = service.create(expectedToAdd);
		
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
		ProductPort actualProduct = service.update(expectedToChange);
		
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
		ProductPort actualProduct = service.update(expectedChanges, expectedToChange.getId());
		
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
		ProductPort actualProduct = service.update(expectedToChange, expectedChanges);
		
		// Then
		assertThat(actualProduct).isEqualTo(expectedProduct);
	}
	
	@Test
	void delete() {
		// Given
		ProductPort expectedProduct = createProduct();
		
		when(storage.remove(expectedProduct.getId())).thenReturn(true);
		
		// When
		boolean actualProducts = service.delete(expectedProduct.getId());
		
		// Then
		assertThat(actualProducts).isTrue();
	}
	
	@Test
	void searchForId() {
		// Given
		ProductPort expectedProduct = createProduct();
		
		when(storage.findById(expectedProduct.getId())).thenReturn(Optional.of(expectedProduct));
		
		// When
		ProductPort actualProduct = service.searchForId(expectedProduct.getId())
		                                   .get();
		
		// Then
		assertThat(actualProduct).isEqualTo(expectedProduct);
	}
	
	@Test
	void searchAll() {
		// Given
		ProductPort expectedProduct = createProduct();
		ProductPort secondEpectedProduct = createProduct();
		
		when(storage.findAll()).thenReturn(List.of(expectedProduct, secondEpectedProduct));
		
		// When
		List<ProductPort> actualProducts = service.searchAll();
		
		// Then
		assertThat(actualProducts).isEqualTo(List.of(expectedProduct, secondEpectedProduct));
		assertThat(actualProducts.size()).isEqualTo(2);
		assertThat(actualProducts).containsExactlyInAnyOrder(expectedProduct, secondEpectedProduct);
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