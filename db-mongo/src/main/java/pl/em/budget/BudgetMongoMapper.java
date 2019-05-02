package pl.em.budget;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import pl.em.billofsale.BillOfSale;
import pl.em.common.DomainID;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
interface BudgetMongoMapper {
	
	@Mapping(source = "budgetId.id", target = "id")
	@Mapping(source = "domain.billsOfSalseList", target = "billsIdsList", qualifiedByName = "billsToIds")
	BudgetDocument toEntity(Budget domain);
	
	@Mapping(target = "budgetId", expression = "java(new DomainID(document.getId()))")
	@Mapping(source = "document.billsIdsList", target = "billsOfSalseList", qualifiedByName = "idsToBills")
	Budget toDomain(BudgetDocument document);
	
	@Named("billsToIds")
	default List<String> billsToIds(List<BillOfSale> bills) {
		return bills.stream()
		            .map(bill -> bill.getBillId()
		                             .getId())
		            .collect(Collectors.toList());
	}
	
	@Named("idsToBills")
	default List<BillOfSale> idsToBills(List<String> ids) {
		return ids.stream()
		          .map(bill -> BillOfSale.builder()
		                                 .billId(new DomainID(bill))
		                                 .build())
		          .collect(Collectors.toList());
	}
	
}
