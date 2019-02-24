package pl.expensesmanager.product;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.expensesmanager.AbstractCoreTest;
import pl.expensesmanager.exception.BusinessLogicExceptionFactory;
import pl.expensesmanager.exception.ValidationExceptionFactory.ExceptionMessage;
import pl.expensesmanager.util.MergeUtil;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static pl.expensesmanager.exception.ValidationExceptionFactory.ErrorCode;

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
		Product expectedProduct_1 = createProduct();
		
		when(storage.findByName(PRODUCT_NAME)).thenReturn(Optional.of(expectedProduct_1));
		
		// When
		Product actualProduct = service.searchByName(PRODUCT_NAME)
		                               .get();
		
		// Then
		assertThat(actualProduct).isEqualTo(expectedProduct_1);
	}
	
	@Test
	void searchAllForPriceRange() {
		// Given
		Product expectedProduct_1 = createProduct();
		Product expectedProduct_2 = createProduct(PRODUCT_PRICE + 0.75);
		
		List<Product> expectedProductList = List.of(expectedProduct_1, expectedProduct_2);
		
		when(storage.findByPriceBetween(PRICE_MIN, PRICE_MAX)).thenReturn(expectedProductList);
		
		// When
		List<Product> actualProductList = service.searchAllByPriceRange(PRICE_MIN, PRICE_MAX);
		
		// Then
		productListAssertions(actualProductList, expectedProductList, expectedProduct_1, expectedProduct_2);
	}
	
	@Test
	void searchAllForPriceRange_throwMinIsBiggerThanMax() {
		// Then
		ThrowingCallable throwable = () -> service.searchAllByPriceRange(PRICE_MAX, PRICE_MIN);
		
		// Then
		assertThatThrownByPassedValueIsInvalidException(
			throwable, BusinessLogicExceptionFactory.ExceptionMessage.MIN_BIGGER_THAN_MAX,
			BusinessLogicExceptionFactory.ErrorCode.MIN_BIGGER_THAN_MAX
		);
	}
	
	@Test
	void searchAllForPriceGreater() {
		// Given
		Product expectedProduct_1 = createProduct(PRODUCT_PRICE + 0.25);
		Product expectedProduct_2 = createProduct(PRODUCT_PRICE + 0.75);
		
		List<Product> expectedProductList = List.of(expectedProduct_1, expectedProduct_2);
		
		when(storage.findByPriceGreaterThan(PRODUCT_PRICE)).thenReturn(expectedProductList);
		
		// When
		List<Product> actualProductList = service.searchAllExpensiveThan(PRODUCT_PRICE);
		
		// Then
		productListAssertions(actualProductList, expectedProductList, expectedProduct_1, expectedProduct_2);
	}
	
	@Test
	void searchAllForPriceLower() {
		// Given
		Product expectedProduct_1 = createProduct();
		Product expectedProduct_2 = createProduct(PRICE_MAX);
		
		List<Product> expectedProductList = List.of(expectedProduct_1, expectedProduct_2);
		
		when(storage.findByPriceLessThan(PRICE_MAX)).thenReturn(expectedProductList);
		
		// When
		List<Product> actualProductList = service.searchAllCheaperThan(PRICE_MAX);
		
		// Then
		productListAssertions(actualProductList, expectedProductList, expectedProduct_1, expectedProduct_2);
	}
	
	@Test
	void create() {
		// Given
		Product expectedToAdd = createProduct();
		Product expectedProduct_1 = createProduct();
		
		when(storage.save(expectedToAdd)).thenReturn(expectedProduct_1);
		
		// When
		Product actualProduct = service.create(expectedToAdd);
		
		// Then
		assertThat(actualProduct).isEqualTo(expectedProduct_1);
	}
	
	@Test
	void updateByObject() {
		// Given
		Product expectedToChange = createProduct(null);
		Product expectedProduct_1 = createProduct(expectedToChange, PRODUCT_PRICE);
		
		when(storage.save(expectedToChange)).thenReturn(expectedProduct_1);
		
		// When
		Product actualProduct = service.update(expectedToChange);
		
		// Then
		assertThat(actualProduct).isEqualTo(expectedProduct_1);
	}
	
	@Test
	void updateById() {
		// Given
		Product expectedToChange = createProduct(null);
		Product expectedChanges = createProduct(expectedToChange, PRICE_MIN);
		Product expectedProduct = createProduct(PRICE_MIN);
		
		when(storage.isValid(ID)).thenReturn(true);
		when(storage.findById(ID)).thenReturn(Optional.of(expectedProduct));
		when(storage.save(MergeUtil.merge(expectedToChange, expectedChanges))).thenReturn(expectedProduct);
		
		// When
		Product actualProduct = service.update(expectedChanges, expectedToChange.getId());
		
		// Then
		assertThat(actualProduct).isEqualTo(expectedProduct);
	}
	
	@Test
	void updateById_throw() {
		// When
		Product expectedToChange = createProduct(null);
		Product expectedChanges = createProduct(expectedToChange, PRICE_MIN);
		
		when(storage.isValid(ID)).thenReturn(true);
		when(storage.findById(ID)).thenReturn(Optional.empty());
		ThrowingCallable throwable = () -> service.update(expectedChanges, ID);
		
		// Then
		assertThatThrownByNotFoundException(
			throwable, BusinessLogicExceptionFactory.ExceptionMessage.PRODUCT_NOT_FOUND,
			BusinessLogicExceptionFactory.ErrorCode.PRODUCT_NOT_FOUND
		);
	}
	
	@Test
	void updateOriginalAndChanges() {
		// Given
		Product expectedToChange = createProduct(null);
		Product expectedChanges = createProduct(expectedToChange, PRICE_MAX);
		Product expectedProduct = createProduct(PRICE_MAX);
		
		when(storage.save(MergeUtil.merge(expectedToChange, expectedChanges))).thenReturn(expectedProduct);
		
		// When
		Product actualProduct = service.update(expectedToChange, expectedChanges);
		
		// Then
		assertThat(actualProduct).isEqualTo(expectedProduct);
	}
	
	@Test
	void searchForId() {
		// Given
		Product expectedProduct = createProduct();
		
		when(storage.findById(ID)).thenReturn(Optional.of(expectedProduct));
		when(storage.isValid(ID)).thenReturn(true);
		
		// When
		Product actualProduct = service.searchById(ID)
		                               .get();
		
		// Then
		assertThat(actualProduct).isEqualTo(expectedProduct);
	}
	
	@Test
	void ifIdIsNotValid_throw() {
		// Given
		when(storage.isValid(ID)).thenReturn(false);
		
		// When
		ThrowingCallable throwable = () -> service.searchById(ID)
		                                          .get();
		
		// Then
		assertThatThrownByValidateIdException(
			throwable, ExceptionMessage.INVALID_ID_FORMAT, ErrorCode.INVALID_ID_FORMAT);
	}
	
	@Test
	void searchAll() {
		// Given
		Product expectedProduct_1 = createProduct();
		Product expectedProduct_2 = createProduct(PRICE_MAX);
		
		List<Product> expectedProductList = List.of(expectedProduct_1, expectedProduct_2);
		
		when(storage.findAll()).thenReturn(expectedProductList);
		
		// When
		List<Product> actualProductList = service.searchAll();
		
		// Then
		productListAssertions(actualProductList, expectedProductList, expectedProduct_1, expectedProduct_2);
	}
	
	private void productListAssertions(
		List<Product> actualProductList, List<Product> expectedProductList, Product expectedProduct_1,
		Product expectedProduct_2
	) {
		assertThat(actualProductList).isEqualTo(expectedProductList);
		assertThat(actualProductList.size()).isEqualTo(expectedProductList.size());
		assertThat(actualProductList).containsExactlyInAnyOrder(expectedProduct_1, expectedProduct_2);
	}
	
}