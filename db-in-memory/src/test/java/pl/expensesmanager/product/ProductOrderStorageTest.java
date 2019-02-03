package pl.expensesmanager.product;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.expensesmanager.AbstractDBInMemoryTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductOrderStorageTest extends AbstractDBInMemoryTest {
	
	@Mock
	private ProductOrderStorage storage;
	
	@Test
	void findByProductName() {
		// Given
		ProductOrderPort expectedProduct_1 = createProductOrder();
		
		when(storage.findByProductName(any())).thenReturn(List.of(expectedProduct_1));
		
		// When
		List<ProductOrderPort> actualProducts = storage.findByProductName(PRODUCT_NAME);
		
		// Then
		assertThat(actualProducts).isEqualTo(List.of(expectedProduct_1));
		assertThat(actualProducts.size()).isEqualTo(1);
		assertThat(actualProducts).containsExactlyInAnyOrder(expectedProduct_1);
	}
	
	@Test
	void findByProductNameAndProductPrice() {
		// Given
		ProductOrderPort expectedProduct_1 = createProductOrder();
		
		when(storage.findByProductNameAndProductPrice(any(), any())).thenReturn(List.of(expectedProduct_1));
		
		// When
		List<ProductOrderPort> actualProducts = storage.findByProductNameAndProductPrice(PRODUCT_NAME, PRODUCT_PRICE);
		
		// Then
		assertThat(actualProducts).isEqualTo(List.of(expectedProduct_1));
		assertThat(actualProducts.size()).isEqualTo(1);
		assertThat(actualProducts).containsExactlyInAnyOrder(expectedProduct_1);
	}
	
	@Test
	void findByQuanityBetween() {
		// Given
		ProductOrderPort expectedProduct_1 = createProductOrder();
		ProductOrderPort expectedProduct_2 = createProductOrder();
		
		when(storage.findByQuanityBetween(any(), any())).thenReturn(List.of(expectedProduct_1, expectedProduct_2));
		
		// When
		List<ProductOrderPort> actualProducts = storage.findByQuanityBetween(1, 3);
		
		// Then
		assertThat(actualProducts).isEqualTo(List.of(expectedProduct_1, expectedProduct_2));
		assertThat(actualProducts.size()).isEqualTo(2);
		assertThat(actualProducts).containsExactlyInAnyOrder(expectedProduct_1, expectedProduct_2);
	}
	
	@Test
	void findByQuanityGreaterThan() {
		// Given
		ProductOrderPort expectedProduct_1 = createProductOrder();
		
		when(storage.findByQuanityGreaterThan(any())).thenReturn(List.of(expectedProduct_1));
		
		// When
		List<ProductOrderPort> actualProducts = storage.findByQuanityGreaterThan(1);
		
		// Then
		assertThat(actualProducts).isEqualTo(List.of(expectedProduct_1));
		assertThat(actualProducts.size()).isEqualTo(1);
		assertThat(actualProducts).containsExactlyInAnyOrder(expectedProduct_1);
	}
	
	@Test
	void findByQuanityLessThan() {
		// Given
		ProductOrderPort expectedProduct_1 = createProductOrder();
		ProductOrderPort expectedProduct_2 = createProductOrder();
		
		when(storage.findByQuanityLessThan(any())).thenReturn(List.of(expectedProduct_1, expectedProduct_2));
		
		// When
		List<ProductOrderPort> actualProducts = storage.findByQuanityLessThan(6);
		
		// Then
		assertThat(actualProducts).isEqualTo(List.of(expectedProduct_1, expectedProduct_2));
		assertThat(actualProducts.size()).isEqualTo(2);
		assertThat(actualProducts).containsExactlyInAnyOrder(expectedProduct_1, expectedProduct_2);
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
		ProductOrderPort expectedProduct_1 = createProductOrder();
		
		when(storage.remove(expectedProduct_1.getId())).thenReturn(true);
		
		// When
		boolean actualProducts = storage.remove(expectedProduct_1.getId());
		
		// Then
		assertThat(actualProducts).isTrue();
	}
	
	@Test
	void findById() {
		// Given
		ProductOrderPort expectedProduct_1 = createProductOrder();
		
		when(storage.findById(expectedProduct_1.getId())).thenReturn(Optional.of(expectedProduct_1));
		
		// When
		ProductOrderPort actualProduct = storage.findById(expectedProduct_1.getId())
		                                        .get();
		
		// Then
		assertThat(actualProduct).isEqualTo(expectedProduct_1);
	}
	
	@Test
	void findAll() {
		// Given
		ProductOrderPort expectedProduct_1 = createProductOrder();
		ProductOrderPort expectedProduct_2 = createProductOrder();
		
		when(storage.findAll()).thenReturn(List.of(expectedProduct_1, expectedProduct_2));
		
		// When
		List<ProductOrderPort> actualProducts = storage.findAll();
		
		// Then
		assertThat(actualProducts).isEqualTo(List.of(expectedProduct_1, expectedProduct_2));
		assertThat(actualProducts.size()).isEqualTo(2);
		assertThat(actualProducts).containsExactlyInAnyOrder(expectedProduct_1, expectedProduct_2);
	}
	
}