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
	
	@Mock
	private ProductStorage storage;
	
	@Test
	void findByName() {
		// Given
		ProductPort expectedProduct_1 = new ProductNullObject();
		
		when(storage.findByName(expectedProduct_1.getName())).thenReturn(Optional.of(expectedProduct_1));
		
		// When
		ProductPort actualProduct = storage.findByName(expectedProduct_1.getName())
		                                   .get();
		
		// Then
		assertThat(actualProduct).isEqualTo(expectedProduct_1);
	}
	
	@Test
	void findByPrice() {
		// Given
		ProductPort expectedProduct_1 = new ProductNullObject();
		
		when(storage.findByPrice(expectedProduct_1.getPrice())).thenReturn(List.of(expectedProduct_1));
		
		// When
		List<ProductPort> actualProducts = storage.findByPrice(expectedProduct_1.getPrice());
		
		// Then
		assertThat(actualProducts).isEqualTo(List.of(expectedProduct_1));
		assertThat(actualProducts.size()).isEqualTo(1);
		assertThat(actualProducts).containsExactlyInAnyOrder(expectedProduct_1);
	}
	
	@Test
	void findByPriceBetween() {
		// Given
		ProductPort expectedProduct_1 = new ProductNullObject();
		ProductPort expectedProduct_2 = new ProductNullObject();
		
		when(storage.findByPrice(any())).thenReturn(List.of(expectedProduct_1, expectedProduct_2));
		
		// When
		List<ProductPort> actualProducts = storage.findByPrice(5.0);
		
		// Then
		assertThat(actualProducts).isEqualTo(List.of(expectedProduct_1, expectedProduct_2));
		assertThat(actualProducts.size()).isEqualTo(2);
		assertThat(actualProducts).containsExactlyInAnyOrder(expectedProduct_1, expectedProduct_2);
	}
	
	@Test
	void findByPriceGreaterThan() {
		// Given
		ProductPort expectedProduct_1 = new ProductNullObject();
		ProductPort expectedProduct_2 = new ProductNullObject();
		
		when(storage.findByPriceGreaterThan(any())).thenReturn(List.of(expectedProduct_1, expectedProduct_2));
		
		// When
		List<ProductPort> actualProducts = storage.findByPriceGreaterThan(3.0);
		
		// Then
		assertThat(actualProducts).isEqualTo(List.of(expectedProduct_1, expectedProduct_2));
		assertThat(actualProducts.size()).isEqualTo(2);
		assertThat(actualProducts).containsExactlyInAnyOrder(expectedProduct_1, expectedProduct_2);
	}
	
	@Test
	void findByPriceLessThan() {
		// Given
		ProductPort expectedProduct_1 = new ProductNullObject();
		ProductPort expectedProduct_2 = new ProductNullObject();
		
		when(storage.findByPriceLessThan(any())).thenReturn(List.of(expectedProduct_1, expectedProduct_2));
		
		// When
		List<ProductPort> actualProducts = storage.findByPriceLessThan(1.0);
		
		// Then
		assertThat(actualProducts).isEqualTo(List.of(expectedProduct_1, expectedProduct_2));
		assertThat(actualProducts.size()).isEqualTo(2);
		assertThat(actualProducts).containsExactlyInAnyOrder(expectedProduct_1, expectedProduct_2);
	}
	
	@Test
	void findByQuanityBetween() {
		// Given
		ProductPort expectedProduct_1 = new ProductNullObject();
		ProductPort expectedProduct_2 = new ProductNullObject();
		
		when(storage.findByQuanityBetween(any(), any())).thenReturn(List.of(expectedProduct_1, expectedProduct_2));
		
		// When
		List<ProductPort> actualProducts = storage.findByQuanityBetween(1, 3);
		
		// Then
		assertThat(actualProducts).isEqualTo(List.of(expectedProduct_1, expectedProduct_2));
		assertThat(actualProducts.size()).isEqualTo(2);
		assertThat(actualProducts).containsExactlyInAnyOrder(expectedProduct_1, expectedProduct_2);
	}
	
	@Test
	void findByQuanityGreaterThan() {
		// Given
		ProductPort expectedProduct_1 = new ProductNullObject();
		
		when(storage.findByQuanityGreaterThan(any())).thenReturn(List.of(expectedProduct_1));
		
		// When
		List<ProductPort> actualProducts = storage.findByQuanityGreaterThan(1);
		
		// Then
		assertThat(actualProducts).isEqualTo(List.of(expectedProduct_1));
		assertThat(actualProducts.size()).isEqualTo(1);
		assertThat(actualProducts).containsExactlyInAnyOrder(expectedProduct_1);
	}
	
	@Test
	void findByQuanityLessThan() {
		// Given
		ProductPort expectedProduct_1 = new ProductNullObject();
		ProductPort expectedProduct_2 = new ProductNullObject();
		
		when(storage.findByQuanityLessThan(any())).thenReturn(List.of(expectedProduct_1, expectedProduct_2));
		
		// When
		List<ProductPort> actualProducts = storage.findByQuanityLessThan(6);
		
		// Then
		assertThat(actualProducts).isEqualTo(List.of(expectedProduct_1, expectedProduct_2));
		assertThat(actualProducts.size()).isEqualTo(2);
		assertThat(actualProducts).containsExactlyInAnyOrder(expectedProduct_1, expectedProduct_2);
	}
	
	@Test
	void add() {
		// Given
		ProductPort expectedToAdd = new Product();
		expectedToAdd.setId("ID test");
		expectedToAdd.setName("Name test");
		
		ProductPort expectedProduct = new Product();
		expectedProduct.setId("ID test");
		expectedProduct.setName("Name test");
		
		when(storage.add(expectedToAdd)).thenReturn(expectedProduct);
		
		// When
		ProductPort actualProduct = storage.add(expectedToAdd);
		
		// Then
		assertThat(actualProduct).isEqualTo(expectedProduct);
	}
	
	@Test
	void updateByObject() {
		// Given
		ProductPort expectedToChange = new Product();
		expectedToChange.setId("ID test");
		expectedToChange.setName("Name test");
		
		ProductPort expectedProduct = new Product();
		expectedProduct.setId("ID test");
		expectedProduct.setName("Name test");
		expectedProduct.setPrice(21.75);
		
		expectedToChange.setPrice(21.75);
		
		when(storage.update(expectedToChange)).thenReturn(expectedProduct);
		
		// When
		ProductPort actualProduct = storage.update(expectedToChange);
		
		// Then
		assertThat(actualProduct).isEqualTo(expectedProduct);
	}
	
	@Test
	void updateById() {
		// Given
		ProductPort expectedToChange = new Product();
		expectedToChange.setId("ID test");
		expectedToChange.setName("Name test");
		
		ProductPort expectedChanges = new Product();
		expectedChanges.setPrice(1.75);
		
		ProductPort expectedProduct = new Product();
		expectedProduct.setId("ID test");
		expectedProduct.setName("Name test");
		expectedProduct.setPrice(1.75);
		
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
		expectedToChange.setName("Name test");
		
		ProductPort expectedChanges = new Product();
		expectedChanges.setPrice(1.5);
		
		ProductPort expectedProduct = new Product();
		expectedProduct.setName("Name test");
		expectedProduct.setPrice(1.5);
		
		when(storage.update(expectedToChange, expectedChanges)).thenReturn(expectedProduct);
		
		// When
		ProductPort actualProduct = storage.update(expectedToChange, expectedChanges);
		
		// Then
		assertThat(actualProduct).isEqualTo(expectedProduct);
	}
	
	@Test
	void remove() {
		// Given
		ProductPort expectedProduct_1 = new ProductNullObject();
		
		when(storage.remove(expectedProduct_1.getId())).thenReturn(true);
		
		// When
		boolean actualProducts = storage.remove(expectedProduct_1.getId());
		
		// Then
		assertThat(actualProducts).isTrue();
	}
	
	@Test
	void findById() {
		// Given
		ProductPort expectedProduct_1 = new ProductNullObject();
		
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
		ProductPort expectedProduct_1 = new ProductNullObject();
		ProductPort expectedProduct_2 = new ProductNullObject();
		
		when(storage.findAll()).thenReturn(List.of(expectedProduct_1, expectedProduct_2));
		
		// When
		List<ProductPort> actualProducts = storage.findAll();
		
		// Then
		assertThat(actualProducts).isEqualTo(List.of(expectedProduct_1, expectedProduct_2));
		assertThat(actualProducts.size()).isEqualTo(2);
		assertThat(actualProducts).containsExactlyInAnyOrder(expectedProduct_1, expectedProduct_2);
	}
	
}