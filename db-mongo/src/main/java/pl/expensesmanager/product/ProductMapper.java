package pl.expensesmanager.product;

/*import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;*/
import pl.expensesmanager.util.ObjectIdConverter;

//@Mapper(uses = ObjectIdConverter.class, componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ProductMapper {
	
	Product map(ProductDocument product);
	
	ProductDocument map(Product product);
	
	ProductOrder map(ProductOrderDocument order);
	
	ProductOrderDocument map(ProductOrder order);
	
}
