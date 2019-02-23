package pl.expensesmanager.billofsale;

/*import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;*/
import pl.expensesmanager.util.ObjectIdConverter;

//@Mapper(uses = ObjectIdConverter.class, componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface BillOfSaleMapper {
	
	BillOfSale map(BillOfSaleDocument billOfSale);
	
	BillOfSaleDocument map(BillOfSale billOfSale);
	
}
