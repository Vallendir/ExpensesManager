package pl.expensesmanager.budget;

/*import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;*/
import pl.expensesmanager.util.ObjectIdConverter;

//@Mapper(uses = ObjectIdConverter.class, componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface BudgetMapper {
	
	Budget map(BudgetDocument budget);
	
	BudgetDocument map(Budget budget);
	
}
