package pl.expensesmanager.billofsale;

import org.springframework.stereotype.Service;
import pl.expensesmanager.base.BaseService;
import pl.expensesmanager.exception.BusinessLogicExceptionFactory;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.springframework.util.MimeTypeUtils.IMAGE_JPEG_VALUE;
import static org.springframework.util.MimeTypeUtils.IMAGE_PNG_VALUE;
import static pl.expensesmanager.exception.BusinessLogicExceptionFactory.billOfSaleImageContentTypeException;
import static pl.expensesmanager.exception.InternalExceptionFactory.ioExceptionException;
import static pl.expensesmanager.exception.ValidationExceptionFactory.*;
import static pl.expensesmanager.util.CoreValidator.*;

@Service
final class BillOfSaleService extends BaseService<BillOfSale> {
	
	private BillOfSaleStorePort storage;
	
	private BillOfSaleImagePort billOfSaleImagePort;
	
	private static final List<String> AVAILABLE_IMAGE_CONTENT_TYPES = List.of(IMAGE_JPEG_VALUE, IMAGE_PNG_VALUE);
	
	BillOfSaleService(BillOfSaleStorePort storage, BillOfSaleImagePort billOfSaleImagePort) {
		super(storage);
		this.storage = storage;
		this.billOfSaleImagePort = billOfSaleImagePort;
	}
	
	/**
	 * Method to search bill of sale by description.
	 *
	 * @param description - the description of bill of sale
	 * @return found bill of sale as optional
	 */
	Optional<BillOfSale> searchByDescription(String description) {
		return storage.findByDescription(validateBillOfSaleDescription(description));
	}
	
	/**
	 * Method to search bill of sale by bought date.
	 *
	 * @param boughtDate - the bought date of bill of sale
	 * @return found bills of sale list
	 */
	List<BillOfSale> searchAllByBoughtDate(Instant boughtDate) {
		return storage.findByBoughtDate(validateBillOfSaleBoughtDate(boughtDate));
	}
	
	/**
	 * Method to search bill of sale by bought date range.
	 *
	 * @param min - start bought date
	 * @param max - end bought date
	 * @return found bills of sale list
	 */
	List<BillOfSale> searchAllByBoughtDateRange(Instant min, Instant max) {
		validateMinMaxValue(validateBillOfSaleBoughtDate(min), validateBillOfSaleBoughtDate(max));
		
		return storage.findByBoughtDateBetween(min, max);
	}
	
	/**
	 * Method to search bill of sale by id.
	 *
	 * @param id - the id of bill of sale
	 * @return found bills of sale list
	 */
	public BillOfSale searchById(String id) {
		return searchObjectById(id, BusinessLogicExceptionFactory::billOfSaleNotFoundException);
	}
	
	public BillOfSale create(BillOfSale object) {
		return createObject(() -> {
			if (Objects.isNull(object)) {
				throw billOfSaleException();
			}
			
			object.setDescription(validateBillOfSaleDescription(object.getDescription()));
			validateBillOfSaleBoughtDate(object.getBoughtDate());
			
			return object;
		});
	}
	
	public BillOfSale update(BillOfSale originalObject, BillOfSale changes) {
		return updateObject(originalObject, changes);
	}
	
	public BillOfSale update(BillOfSale changes, String id) {
		return updateObject(changes, id, BusinessLogicExceptionFactory::billOfSaleNotFoundException);
	}
	
	String readBillOfSaleImageAsString(BillOfSaleImage billOfSaleImage) {
		if (billOfSaleImage.getImageAsBytes().length == 0) {
			throw ioExceptionException("File as bytes cannot be empty.");
		}
		if (!AVAILABLE_IMAGE_CONTENT_TYPES.contains(billOfSaleImage.getContentType())) {
			throw billOfSaleImageContentTypeException();
		}
		
		return billOfSaleImagePort.readImageAsString(billOfSaleImage);
	}
	
	@Override
	protected void checkChangesIn(BillOfSale changes, BillOfSale originalObject) {
		if (Objects.isNull(originalObject.getDescription()) && Objects.nonNull(changes.getDescription()) ||
		    Objects.nonNull(originalObject.getDescription()) && Objects.nonNull(changes.getDescription())) {
			validateBillOfSaleDescription(changes.getDescription());
		} else if (Objects.nonNull(originalObject.getDescription()) && Objects.isNull(changes.getDescription())) {
			validateBillOfSaleDescription(originalObject.getDescription());
		} else {
			throw billOfSaleDescriptionException();
		}
		
		if (Objects.isNull(originalObject.getBoughtDate()) && Objects.nonNull(changes.getBoughtDate()) ||
		    Objects.nonNull(originalObject.getBoughtDate()) && Objects.nonNull(changes.getBoughtDate())) {
			validateBillOfSaleBoughtDate(changes.getBoughtDate());
		} else if (Objects.nonNull(originalObject.getBoughtDate()) && Objects.isNull(changes.getBoughtDate())) {
			validateBillOfSaleBoughtDate(originalObject.getBoughtDate());
		} else {
			throw dateNullException();
		}
	}
	
}
