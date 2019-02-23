package pl.expensesmanager.product;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.expensesmanager.AbstractCoreTest;
import pl.expensesmanager.util.MergeUtil;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest extends AbstractCoreTest {
	
	private static final Double PRICE_MIN = PRODUCT_PRICE - 2;
	
	private static final Double PRICE_MAX = PRODUCT_PRICE + 2;
	
	@Mock
	private ProductStorePort storage;
	
	@InjectMocks
	private ProductService service;
	
	@Test
	void searchForName() {
		// Given
		ProductPort expectedProduct_1 = createProduct();
		
		when(storage.findByName(PRODUCT_NAME)).thenReturn(Optional.of(expectedProduct_1));
		
		// When
		ProductPort actualProduct = service.searchForName(PRODUCT_NAME)
		                                   .get();
		
		// Then
		assertThat(actualProduct).isEqualTo(expectedProduct_1);
	}
	
	@Test
	void searchAllForPriceRange() {
		// Given
		ProductPort expectedProduct_1 = createProduct();
		ProductPort expectedProduct_2 = createProduct(PRODUCT_PRICE + 0.75);
		
		List<ProductPort> expectedProductList = List.of(expectedProduct_1, expectedProduct_2);
		
		when(storage.findByPriceBetween(PRICE_MIN, PRICE_MAX)).thenReturn(expectedProductList);
		
		// When
		List<ProductPort> actualProductList = service.searchAllForPriceRange(PRICE_MIN, PRICE_MAX);
		
		// Then
		productListAssertions(actualProductList, expectedProductList, expectedProduct_1, expectedProduct_2);
	}
	
	@Test
	void searchAllForPriceGreater() {
		// Given
		ProductPort expectedProduct_1 = createProduct(PRODUCT_PRICE + 0.25);
		ProductPort expectedProduct_2 = createProduct(PRODUCT_PRICE + 0.75);
		
		List<ProductPort> expectedProductList = List.of(expectedProduct_1, expectedProduct_2);
		
		when(storage.findByPriceGreaterThan(PRODUCT_PRICE)).thenReturn(expectedProductList);
		
		// When
		List<ProductPort> actualProductList = service.searchAllForPriceGreater(PRODUCT_PRICE);
		
		// Then
		productListAssertions(actualProductList, expectedProductList, expectedProduct_1, expectedProduct_2);
	}
	
	@Test
	void searchAllForPriceLower() {
		// Given
		ProductPort expectedProduct_1 = createProduct();
		ProductPort expectedProduct_2 = createProduct(PRICE_MAX);
		
		List<ProductPort> expectedProductList = List.of(expectedProduct_1, expectedProduct_2);
		
		when(storage.findByPriceLessThan(PRICE_MAX)).thenReturn(expectedProductList);
		
		// When
		List<ProductPort> actualProductList = service.searchAllForPriceLower(PRICE_MAX);
		
		// Then
		productListAssertions(actualProductList, expectedProductList, expectedProduct_1, expectedProduct_2);
	}
	
	@Test
	void create() {
		// Given
		ProductPort expectedToAdd = createProduct();
		ProductPort expectedProduct_1 = createProduct();
		
		when(storage.save(expectedToAdd)).thenReturn(expectedProduct_1);
		
		// When
		ProductPort actualProduct = service.create(expectedToAdd);
		
		// Then
		assertThat(actualProduct).isEqualTo(expectedProduct_1);
	}
	
	@Test
	void updateByObject() {
		// Given
		ProductPort expectedToChange = createProduct(null);
		ProductPort expectedProduct_1 = createProduct(expectedToChange, PRODUCT_PRICE);
		
		when(storage.save(expectedToChange)).thenReturn(expectedProduct_1);
		
		// When
		ProductPort actualProduct = service.update(expectedToChange);
		
		// Then
		assertThat(actualProduct).isEqualTo(expectedProduct_1);
	}
	
	@Test
	void updateById() {
		// Given
		ProductPort expectedToChange = createProduct(null);
		ProductPort expectedChanges = createProduct(expectedToChange, PRICE_MIN);
		ProductPort expectedProduct = createProduct(PRICE_MIN);
		
		when(storage.findById(ID)).thenReturn(Optional.of(expectedProduct));
		when(storage.save(MergeUtil.merge(expectedToChange, expectedChanges))).thenReturn(expectedProduct);
		
		// When
		ProductPort actualProduct = service.update(expectedChanges, expectedToChange.getId());
		
		// Then
		assertThat(actualProduct).isEqualTo(expectedProduct);
	}
	
	@Test
	void updateOriginalAndChanges() {
		// Given
		ProductPort expectedToChange = createProduct(null);
		ProductPort expectedChanges = createProduct(expectedToChange, PRICE_MAX);
		ProductPort expectedProduct = createProduct(PRICE_MAX);
		
		when(storage.save(MergeUtil.merge(expectedToChange, expectedChanges))).thenReturn(expectedProduct);
		
		// When
		ProductPort actualProduct = service.update(expectedToChange, expectedChanges);
		
		// Then
		assertThat(actualProduct).isEqualTo(expectedProduct);
	}
	
	@Test
	void searchForId() {
		// Given
		ProductPort expectedProduct = createProduct();
		
		when(storage.findById(ID)).thenReturn(Optional.of(expectedProduct));
		
		// When
		ProductPort actualProduct = service.searchForId(ID)
		                                   .get();
		
		// Then
		assertThat(actualProduct).isEqualTo(expectedProduct);
	}
	
	@Test
	void searchAll() {
		// Given
		ProductPort expectedProduct_1 = createProduct();
		ProductPort expectedProduct_2 = createProduct(PRICE_MAX);
		
		List<ProductPort> expectedProductList = List.of(expectedProduct_1, expectedProduct_2);
		
		when(storage.findAll()).thenReturn(expectedProductList);
		
		// When
		List<ProductPort> actualProductList = service.searchAll();
		
		// Then
		productListAssertions(actualProductList, expectedProductList, expectedProduct_1, expectedProduct_2);
	}
	
	private void productListAssertions(
		List<ProductPort> actualProductList, List<ProductPort> expectedProductList, ProductPort expectedProduct_1,
		ProductPort expectedProduct_2
	) {
		assertThat(actualProductList).isEqualTo(expectedProductList);
		assertThat(actualProductList.size()).isEqualTo(expectedProductList.size());
		assertThat(actualProductList).containsExactlyInAnyOrder(expectedProduct_1, expectedProduct_2);
	}
	
}