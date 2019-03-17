package pl.expensesmanager.billofsale;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pl.expensesmanager.base.BaseRESTController;

import java.io.IOException;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static pl.expensesmanager.exception.InternalExceptionFactory.ioExceptionException;

@Slf4j
@RestController
class BillOfSaleRESTController extends BaseRESTController<BillOfSale>
	implements BillOfSaleApi, BillOfSaleDocumentation {
	
	private final BillOfSaleService service;
	
	BillOfSaleRESTController(BillOfSaleService service) {
		super(service);
		this.service = service;
	}
	
	public BillOfSale searchForDescription(String description) {
		Optional<BillOfSale> billOfSale = service.searchByDescription(description);
		
		return billOfSale.get();
	}
	
	public List<BillOfSale> searchForBoughtDate(Instant boughtDate) {
		return service.searchAllByBoughtDate(boughtDate);
	}
	
	public List<BillOfSale> searchAllForBoughtDateRange(Instant min, Instant max) {
		return service.searchAllByBoughtDateRange(min, max);
	}
	
	public List<BillOfSale> searchAll() {
		return super.searchAll();
	}
	
	public void delete(String id) {
		super.delete(id);
	}
	
	public BillOfSaleImageAsText uploadBillOfSaleAsImage(MultipartFile file) {
		if (file.isEmpty()) {
			throw ioExceptionException("File cannot be empty.");
		}
		
		BillOfSaleImage billOfSaleImage;
		try {
			billOfSaleImage = new BillOfSaleImage(file.getContentType(), file.getBytes());
		} catch (IOException e) {
			throw ioExceptionException("There is an access errors because the temporary store fails.");
		}
		
		return new BillOfSaleImageAsText(service.readBillOfSaleImageAsString(billOfSaleImage));
	}
	
}
