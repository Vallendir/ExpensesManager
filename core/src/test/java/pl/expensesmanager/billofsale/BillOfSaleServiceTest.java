package pl.expensesmanager.billofsale;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.expensesmanager.AbstractCoreTest;
import pl.expensesmanager.exception.BusinessLogicExceptionFactory;
import pl.expensesmanager.exception.ValidationExceptionFactory;
import pl.expensesmanager.util.MergeUtil;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BillOfSaleServiceTest extends AbstractCoreTest {
	
	private static final Instant BOUGHT_DATE_MAX = Instant.now();
	
	@Mock
	private BillOfSaleStorePort storage;
	
	@InjectMocks
	private BillOfSaleService service;
	
	@Test
	void searchForDescription() {
		// Given
		BillOfSale expectedBillOfSale_1 = createBillOfSale();
		
		when(storage.findByDescription(BILL_OF_SALE_DESCRIPTION)).thenReturn(Optional.of(expectedBillOfSale_1));
		
		// When
		BillOfSale actualBillOfSale = service.searchByDescription(BILL_OF_SALE_DESCRIPTION)
		                                     .get();
		
		// Then
		assertThat(actualBillOfSale).isEqualTo(expectedBillOfSale_1);
	}
	
	@Test
	void searchForBoughtDate() {
		// Given
		BillOfSale expectedBillOfSale_1 = createBillOfSale();
		BillOfSale expectedBillOfSale_2 = createBillOfSale();
		
		List<BillOfSale> expectedBillOfSaleList = List.of(expectedBillOfSale_1, expectedBillOfSale_2);
		
		when(storage.findByBoughtDate(BOUGHT_DATE)).thenReturn(expectedBillOfSaleList);
		
		// When
		List<BillOfSale> actualBillOfSaleList = service.searchAllByBoughtDate(BOUGHT_DATE);
		
		// Then
		billOfSaleListAssertions(
			actualBillOfSaleList, expectedBillOfSaleList, expectedBillOfSale_1, expectedBillOfSale_2);
	}
	
	@Test
	void searchAllForBoughtDateRange() {
		// Given
		BillOfSale expectedBillOfSale_1 = createBillOfSale();
		BillOfSale expectedBillOfSale_2 = createBillOfSale();
		
		List<BillOfSale> expectedBillOfSaleList = List.of(expectedBillOfSale_1, expectedBillOfSale_2);
		
		when(storage.findByBoughtDateBetween(BOUGHT_DATE, BOUGHT_DATE_MAX)).thenReturn(expectedBillOfSaleList);
		
		// When
		List<BillOfSale> actualBillOfSaleList = service.searchAllByBoughtDateRange(BOUGHT_DATE, BOUGHT_DATE_MAX);
		
		// Then
		billOfSaleListAssertions(
			actualBillOfSaleList, expectedBillOfSaleList, expectedBillOfSale_1, expectedBillOfSale_2);
	}
	
	@Test
	void searchAllForBoughtDateRange_throwMinIsBiggerThanMax() {
		// Then
		ThrowingCallable throwable = () -> service.searchAllByBoughtDateRange(
			BOUGHT_DATE_MAX.plusMillis(56456465), BOUGHT_DATE);
		
		// Then
		assertThatThrownByPassedValueIsInvalidException(throwable,
		                                                BusinessLogicExceptionFactory.ExceptionMessage.MIN_BIGGER_THAN_MAX,
		                                                BusinessLogicExceptionFactory.ErrorCode.MIN_BIGGER_THAN_MAX
		);
	}
	
	@Test
	void create() {
		// Given
		BillOfSale expectedToAdd = createBillOfSale();
		
		BillOfSale expectedBillOfSaleList = createBillOfSale();
		
		when(storage.save(expectedToAdd)).thenReturn(expectedBillOfSaleList);
		
		// When
		BillOfSale actualBillOfSaleList = service.create(expectedToAdd);
		
		// Then
		assertThat(actualBillOfSaleList).isEqualTo(expectedBillOfSaleList);
	}
	
	@Test
	void updateByObject() {
		// Given
		BillOfSale expectedToChange = new BillOfSale();
		expectedToChange.setId(ID);
		expectedToChange.setDescription(BILL_OF_SALE_DESCRIPTION);
		
		BillOfSale expectedBillOfSaleList = createBillOfSale();
		
		expectedToChange.setBoughtDate(BOUGHT_DATE);
		
		when(storage.save(expectedToChange)).thenReturn(expectedBillOfSaleList);
		
		// When
		BillOfSale actualBillOfSaleList = service.update(expectedToChange);
		
		// Then
		assertThat(actualBillOfSaleList).isEqualTo(expectedBillOfSaleList);
	}
	
	@Test
	void updateById() {
		// Given
		BillOfSale expectedToChange = new BillOfSale();
		expectedToChange.setId(ID);
		expectedToChange.setDescription(BILL_OF_SALE_DESCRIPTION);
		expectedToChange.setProductList(List.of(createProductOrder()));
		
		BillOfSale expectedChanges = new BillOfSale();
		expectedChanges.setBoughtDate(BOUGHT_DATE);
		
		BillOfSale expectedBillOfSaleList = createBillOfSale();
		
		when(storage.isValid(ID)).thenReturn(true);
		when(storage.findById(ID)).thenReturn(Optional.of(expectedBillOfSaleList));
		when(storage.save(MergeUtil.merge(expectedToChange, expectedChanges))).thenReturn(expectedBillOfSaleList);
		
		// When
		BillOfSale actualBillOfSaleList = service.update(expectedChanges, ID);
		
		// Then
		assertThat(actualBillOfSaleList).isEqualTo(expectedBillOfSaleList);
	}
	
	@Test
	void updateById_throw() {
		// When
		BillOfSale expectedChanges = new BillOfSale();
		
		when(storage.isValid(ID)).thenReturn(true);
		when(storage.findById(ID)).thenReturn(Optional.empty());
		ThrowingCallable throwable = () -> service.update(expectedChanges, ID);
		
		// Then
		assertThatThrownByNotFoundException(throwable,
		                                    BusinessLogicExceptionFactory.ExceptionMessage.BILL_OF_SALE_NOT_FOUND,
		                                    BusinessLogicExceptionFactory.ErrorCode.BILL_OF_SALE_NOT_FOUND
		);
	}
	
	@Test
	void ifIdIsNotValid_throw() {
		// Given
		when(storage.isValid(ID)).thenReturn(false);
		
		// When
		ThrowingCallable throwable = () -> service.searchById(ID)
		                                          .get();
		
		// Then
		assertThatThrownByValidateIdException(throwable, ValidationExceptionFactory.ExceptionMessage.INVALID_ID_FORMAT,
		                                      ValidationExceptionFactory.ErrorCode.INVALID_ID_FORMAT
		);
	}
	
	@Test
	void updateOriginalAndChanges() {
		// Given
		BillOfSale expectedToChange = new BillOfSale();
		expectedToChange.setDescription(BILL_OF_SALE_DESCRIPTION);
		
		BillOfSale expectedChanges = new BillOfSale();
		expectedChanges.setBoughtDate(BOUGHT_DATE);
		
		BillOfSale expectedBillOfSaleList = createBillOfSale();
		
		when(storage.save(MergeUtil.merge(expectedToChange, expectedChanges))).thenReturn(expectedBillOfSaleList);
		
		// When
		BillOfSale actualBillOfSaleList = service.update(expectedToChange, expectedChanges);
		
		// Then
		assertThat(actualBillOfSaleList).isEqualTo(expectedBillOfSaleList);
	}
	
	@Test
	void searchForId() {
		// Given
		BillOfSale expectedBillOfSale_1 = createBillOfSale();
		
		when(storage.isValid(ID)).thenReturn(true);
		when(storage.findById(ID)).thenReturn(Optional.of(expectedBillOfSale_1));
		
		// When
		BillOfSale actualBillOfSale = service.searchById(ID)
		                                     .get();
		
		// Then
		assertThat(actualBillOfSale).isEqualTo(expectedBillOfSale_1);
	}
	
	@Test
	void searchAll() {
		// Given
		BillOfSale expectedBillOfSale_1 = createBillOfSale();
		BillOfSale expectedBillOfSale_2 = createBillOfSale();
		
		List<BillOfSale> expectedBillOfSaleList = List.of(expectedBillOfSale_1, expectedBillOfSale_2);
		
		when(storage.findAll()).thenReturn(expectedBillOfSaleList);
		
		// When
		List<BillOfSale> actualBillOfSaleList = service.searchAll();
		
		// Then
		billOfSaleListAssertions(
			actualBillOfSaleList, expectedBillOfSaleList, expectedBillOfSale_1, expectedBillOfSale_2);
	}
	
	private void billOfSaleListAssertions(
		List<BillOfSale> actualBillOfSaleList, List<BillOfSale> expectedBillOfSaleList, BillOfSale expectedBillOfSale_1,
		BillOfSale expectedBillOfSale_2
	) {
		assertThat(actualBillOfSaleList).isEqualTo(expectedBillOfSaleList);
		assertThat(actualBillOfSaleList.size()).isEqualTo(expectedBillOfSaleList.size());
		assertThat(actualBillOfSaleList).containsExactlyInAnyOrder(expectedBillOfSale_1, expectedBillOfSale_2);
		assertThat(actualBillOfSaleList.stream()
		                               .mapToDouble(BillOfSale::finalPrice)
		                               .sum()).isEqualTo(expectedBillOfSaleList.stream()
		                                                                       .mapToDouble(BillOfSale::finalPrice)
		                                                                       .sum());
	}
	
}