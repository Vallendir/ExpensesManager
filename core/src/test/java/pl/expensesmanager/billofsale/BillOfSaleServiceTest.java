package pl.expensesmanager.billofsale;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.expensesmanager.AbstractCoreTest;
import pl.expensesmanager.exception.BusinessLogicExceptionFactory;
import pl.expensesmanager.exception.InternalExceptionFactory;
import pl.expensesmanager.exception.ValidationExceptionFactory;
import pl.expensesmanager.util.MergeUtil;

import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BillOfSaleServiceTest extends AbstractCoreTest {
	
	private static final Instant BOUGHT_DATE_MAX = Instant.now();
	
	private static final List<String> AVAILABLE_IMAGE_CONTENT_TYPES = List.of("image/jpeg", "image/png");
	
	@Mock
	private BillOfSaleStorePort storage;
	
	@Mock
	private BillOfSaleImagePort billOfSaleImagePort;
	
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
		BillOfSale actualBillOfSaleList = service.create(expectedToChange);
		
		// Then
		assertThat(actualBillOfSaleList).isEqualTo(expectedBillOfSaleList);
	}
	
	@Test
	void updateById() {
		// Given
		BillOfSale toChange = BillOfSale.builder()
		                                .description(BILL_OF_SALE_DESCRIPTION)
		                                .build();
		toChange.setId(ID);
		
		BillOfSale changes = BillOfSale.builder()
		                               .boughtDate(BOUGHT_DATE)
		                               .build();
		
		BillOfSale expected = BillOfSale.builder()
		                                .description(BILL_OF_SALE_DESCRIPTION)
		                                .boughtDate(BOUGHT_DATE)
		                                .build();
		expected.setId(ID);
		
		when(storage.isValid(ID)).thenReturn(true);
		when(storage.findById(ID)).thenReturn(Optional.of(expected));
		when(storage.save(MergeUtil.merge(toChange, changes))).thenReturn(expected);
		
		// When
		BillOfSale actualBillOfSaleList = service.update(changes, ID);
		
		// Then
		assertThat(actualBillOfSaleList).isEqualTo(expected);
	}
	
	@Test
	void updateById_throwObjectNotFound() {
		// When
		BillOfSale expectedChanges = new BillOfSale();
		
		when(storage.isValid(ID)).thenReturn(true);
		
		ThrowingCallable throwable = () -> service.update(expectedChanges, ID);
		
		// Then
		assertThatThrownByNotFoundException(throwable,
		                                    BusinessLogicExceptionFactory.ExceptionMessage.BILL_OF_SALE_NOT_FOUND,
		                                    BusinessLogicExceptionFactory.ErrorCode.BILL_OF_SALE_NOT_FOUND
		);
	}
	
	@Test
	void updateById_throwInvalidIdFormat() {
		// When
		BillOfSale expectedChanges = new BillOfSale();
		
		ThrowingCallable throwable = () -> service.update(expectedChanges, ID);
		
		// Then
		assertThatThrownByValidateIdException(throwable, ValidationExceptionFactory.ExceptionMessage.INVALID_ID_FORMAT,
		                                      ValidationExceptionFactory.ErrorCode.INVALID_ID_FORMAT
		);
	}
	
	@Test
	void ifIdIsNotValid_throw() {
		// Given
		when(storage.isValid(ID)).thenReturn(false);
		
		// When
		ThrowingCallable throwable = () -> service.searchById(ID);
		
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
		BillOfSale actualBillOfSale = service.searchById(ID);
		
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
		List<BillOfSale> actualBillOfSaleList = service.searchAllObjects();
		
		// Then
		billOfSaleListAssertions(
			actualBillOfSaleList, expectedBillOfSaleList, expectedBillOfSale_1, expectedBillOfSale_2);
	}
	
	@Test
	void searchAll_throwListNotFound() {
		// Given
		when(storage.findAll()).thenReturn(Collections.emptyList());
		
		// When
		ThrowingCallable throwable = () -> service.searchAllObjects();
		
		// Then
		assertThatThrownByNotFoundException(throwable, BusinessLogicExceptionFactory.ExceptionMessage.LIST_NOT_FOUND,
		                                    BusinessLogicExceptionFactory.ErrorCode.LIST_NOT_FOUND
		);
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
	
	@Test
	void readBillOfSaleImageAsString_JPEG_okay() {
		// Given
		String expectedText = "TEST";
		byte[] bytes = new byte[1];
		
		BillOfSaleImage billOfSaleImage = new BillOfSaleImage(AVAILABLE_IMAGE_CONTENT_TYPES.get(0), bytes);
		when(billOfSaleImagePort.readImageAsString(billOfSaleImage)).thenReturn(expectedText);
		
		// When
		String actualText = service.readBillOfSaleImageAsString(billOfSaleImage);
		
		// Then
		assertThat(actualText).isEqualTo(expectedText);
	}
	
	@Test
	void readBillOfSaleImageAsString_PNG_okay() {
		// Given
		String expectedText = "TEST";
		byte[] bytes = new byte[1];
		
		BillOfSaleImage billOfSaleImage = new BillOfSaleImage(AVAILABLE_IMAGE_CONTENT_TYPES.get(1), bytes);
		when(billOfSaleImagePort.readImageAsString(billOfSaleImage)).thenReturn(expectedText);
		
		// When
		String actualText = service.readBillOfSaleImageAsString(billOfSaleImage);
		
		// Then
		assertThat(actualText).isEqualTo(expectedText);
	}
	
	@Test
	void readBillOfSaleImageAsString_bytesZero_throwIOException() {
		// Given
		byte[] bytes = new byte[0];
		
		BillOfSaleImage billOfSaleImage = new BillOfSaleImage(AVAILABLE_IMAGE_CONTENT_TYPES.get(1), bytes);
		
		// When
		ThrowingCallable calalble = () -> service.readBillOfSaleImageAsString(billOfSaleImage);
		
		// Then
		assertThatThrownByIOProblemException(
			calalble, "File as bytes cannot be empty.", InternalExceptionFactory.ErrorCode.IO_EXCEPTION);
	}
	
	@Test
	void readBillOfSaleImageAsString_IllegalContentType_throwIOException() {
		// Given
		String contentType = "image/gif";
		byte[] bytes = new byte[1];
		
		BillOfSaleImage billOfSaleImage = new BillOfSaleImage(contentType, bytes);
		
		// When
		ThrowingCallable calalble = () -> service.readBillOfSaleImageAsString(billOfSaleImage);
		
		// Then
		assertThatThrownByPassedValueIsInvalidException(
			calalble, BusinessLogicExceptionFactory.ExceptionMessage.BILL_OF_SALE_IMAGE_CONTENT_TYPE,
			BusinessLogicExceptionFactory.ErrorCode.BILL_OF_SALE_IMAGE_CONTENT_TYPE
		);
	}
	
}