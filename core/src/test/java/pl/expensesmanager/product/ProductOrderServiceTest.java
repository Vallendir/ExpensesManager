package pl.expensesmanager.product;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.expensesmanager.AbstractCoreTest;
import pl.expensesmanager.exception.BusinessLogicExceptionFactory;
import pl.expensesmanager.util.MergeUtil;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductOrderServiceTest extends AbstractCoreTest {
	
	private static final Integer QUANITY_MIN = PRODUCT_QUANITY - 2;
	
	private static final Integer QUANITY_MAX = PRODUCT_QUANITY + 2;
	
	@Mock
	private ProductOrderStorePort storage;
	
	@InjectMocks
	private ProductOrderService service;
	
	@Test
	void searchAllForProductName() {
		// Given
		ProductOrder expectedOrder_1 = createProductOrder();
		ProductOrder expectedOrder_2 = createProductOrder();
		
		List<ProductOrder> expectedOrderList = List.of(expectedOrder_1, expectedOrder_2);
		
		when(storage.findByProductName(PRODUCT_NAME)).thenReturn(expectedOrderList);
		
		// When
		List<ProductOrder> actualOrderList = service.searchAllByProductName(PRODUCT_NAME);
		
		// Then
		productOrderListAssertions(actualOrderList, expectedOrderList, expectedOrder_1, expectedOrder_2);
	}
	
	@Test
	void searchAllForProductNameAndProductPrice() {
		// Given
		ProductOrder expectedOrder_1 = createProductOrder();
		ProductOrder expectedOrder_2 = createProductOrder();
		
		List<ProductOrder> expectedOrderList = List.of(expectedOrder_1, expectedOrder_2);
		
		when(storage.findByProductNameAndProductPrice(PRODUCT_NAME, PRODUCT_PRICE)).thenReturn(expectedOrderList);
		
		// When
		List<ProductOrder> actualOrderList = service.searchAllByProductNameAndPrice(PRODUCT_NAME, PRODUCT_PRICE);
		
		// Then
		productOrderListAssertions(actualOrderList, expectedOrderList, expectedOrder_1, expectedOrder_2);
	}
	
	@Test
	void searchAllForQuanityRange() {
		// Given
		ProductOrder expectedOrder_1 = createProductOrder();
		ProductOrder expectedOrder_2 = createProductOrder();
		
		List<ProductOrder> expectedOrderList = List.of(expectedOrder_1, expectedOrder_2);
		
		when(storage.findByQuanityBetween(QUANITY_MIN, QUANITY_MAX)).thenReturn(expectedOrderList);
		
		// When
		List<ProductOrder> actualOrderList = service.searchAllByQuanityRange(QUANITY_MIN, QUANITY_MAX);
		
		// Then
		productOrderListAssertions(actualOrderList, expectedOrderList, expectedOrder_1, expectedOrder_2);
	}
	
	@Test
	void searchAllForQuanityRange_throwMinIsBiggerThanMax() {
		// Then
		ThrowableAssert.ThrowingCallable throwable = () -> service.searchAllByQuanityRange(QUANITY_MAX, QUANITY_MIN);
		
		// Then
		assertThatThrownByPassedValueIsInvalidException(throwable,
		                                                BusinessLogicExceptionFactory.ExceptionMessage.MIN_BIGGER_THAN_MAX,
		                                                BusinessLogicExceptionFactory.ErrorCode.MIN_BIGGER_THAN_MAX
		);
	}
	
	@Test
	void searchAllForQuanityGreater() {
		// Given
		ProductOrder expectedOrder_1 = createProductOrder();
		ProductOrder expectedOrder_2 = createProductOrder();
		
		List<ProductOrder> expectedOrderList = List.of(expectedOrder_1, expectedOrder_2);
		
		when(storage.findByQuanityGreaterThan(QUANITY_MIN)).thenReturn(expectedOrderList);
		
		// When
		List<ProductOrder> actualOrderList = service.searchAllByBiggerQuanityThan(QUANITY_MIN);
		
		// Then
		productOrderListAssertions(actualOrderList, expectedOrderList, expectedOrder_1, expectedOrder_2);
	}
	
	@Test
	void searchAllForQuanityLower() {
		// Given
		ProductOrder expectedOrder_1 = createProductOrder();
		ProductOrder expectedOrder_2 = createProductOrder();
		
		List<ProductOrder> expectedOrderList = List.of(expectedOrder_1, expectedOrder_2);
		
		when(storage.findByQuanityLessThan(QUANITY_MAX)).thenReturn(expectedOrderList);
		
		// When
		List<ProductOrder> actualOrderList = service.searchAllByLessQuanityThan(QUANITY_MAX);
		
		// Then
		productOrderListAssertions(actualOrderList, expectedOrderList, expectedOrder_1, expectedOrder_2);
	}
	
	@Test
	void create() {
		// Given
		ProductOrder expectedToAdd = createProductOrder();
		ProductOrder expectedOrder = createProductOrder();
		
		when(storage.save(expectedToAdd)).thenReturn(expectedOrder);
		
		// When
		ProductOrder actualOrder = service.create(expectedToAdd);
		
		// Then
		assertThat(actualOrder).isEqualTo(expectedOrder);
	}
	
	@Test
	void updateByObject() {
		// Given
		ProductOrder expectedToChange = createProductOrder(null);
		ProductOrder expectedOrder = createProductOrder();
		expectedToChange.setQuanity(PRODUCT_QUANITY);
		
		when(storage.save(expectedToChange)).thenReturn(expectedOrder);
		
		// When
		ProductOrder actualOrder = service.update(expectedToChange);
		
		// Then
		assertThat(actualOrder).isEqualTo(expectedOrder);
	}
	
	@Test
	void updateById() {
		// Given
		ProductOrder expectedToChange = createProductOrder(null);
		ProductOrder expectedChanges = new ProductOrder();
		expectedChanges.setQuanity(PRODUCT_QUANITY);
		
		ProductOrder expectedOrder = createProductOrder();
		
		when(storage.isValid(ID)).thenReturn(true);
		when(storage.findById(ID)).thenReturn(Optional.of(expectedOrder));
		when(storage.save(MergeUtil.merge(expectedToChange, expectedChanges))).thenReturn(expectedOrder);
		
		// When
		ProductOrder actualOrder = service.update(expectedChanges, expectedToChange.getId());
		
		// Then
		assertThat(actualOrder).isEqualTo(expectedOrder);
	}
	
	@Test
	void updateById_throw() {
		// When
		ProductOrder expectedChanges = new ProductOrder();
		
		when(storage.isValid(ID)).thenReturn(true);
		when(storage.findById(ID)).thenReturn(Optional.empty());
		ThrowableAssert.ThrowingCallable throwable = () -> service.update(expectedChanges, ID);
		
		// Then
		assertThatThrownByNotFoundException(throwable,
		                                    BusinessLogicExceptionFactory.ExceptionMessage.PRODUCT_ORDER_NOT_FOUND,
		                                    BusinessLogicExceptionFactory.ErrorCode.PRODUCT_ORDER_NOT_FOUND
		);
	}
	
	@Test
	void updateOriginalAndChanges() {
		// Given
		ProductOrder expectedToChange = createProductOrder(null);
		ProductOrder expectedChanges = new ProductOrder();
		expectedChanges.setQuanity(PRODUCT_QUANITY);
		ProductOrder expectedOrder = createProductOrder();
		
		when(storage.save(MergeUtil.merge(expectedToChange, expectedChanges))).thenReturn(expectedOrder);
		
		// When
		ProductOrder actualOrder = service.update(expectedToChange, expectedChanges);
		
		// Then
		assertThat(actualOrder).isEqualTo(expectedOrder);
	}
	
	@Test
	void searchForId() {
		// Given
		ProductOrder expectedOrder_1 = createProductOrder();
		
		when(storage.isValid(ID)).thenReturn(true);
		when(storage.findById(ID)).thenReturn(Optional.of(expectedOrder_1));
		
		// When
		ProductOrder actualOrder = service.searchById(ID)
		                                  .get();
		
		// Then
		assertThat(actualOrder).isEqualTo(expectedOrder_1);
	}
	
	@Test
	void searchAll() {
		// Given
		ProductOrder expectedOrder_1 = createProductOrder();
		ProductOrder expectedOrder_2 = createProductOrder();
		
		List<ProductOrder> expectedOrderList = List.of(expectedOrder_1, expectedOrder_2);
		
		when(storage.findAll()).thenReturn(expectedOrderList);
		
		// When
		List<ProductOrder> actualOrderList = service.searchAll();
		
		// Then
		productOrderListAssertions(actualOrderList, expectedOrderList, expectedOrder_1, expectedOrder_2);
	}
	
	private void productOrderListAssertions(
		List<ProductOrder> actualOrderList, List<ProductOrder> expectedOrderList, ProductOrder expectedOrder_1,
		ProductOrder expectedOrder_2
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