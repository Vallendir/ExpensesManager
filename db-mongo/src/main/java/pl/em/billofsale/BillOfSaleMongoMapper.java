package pl.em.billofsale;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import pl.em.common.DomainID;
import pl.em.product.ProductOrder;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface BillOfSaleMongoMapper {
	
	@Mapping(source = "billId.id", target = "id")
	@Mapping(source = "domain.ordersList", target = "ordersIdsList", qualifiedByName = "ordersToIds")
	BillOfSaleDocument toEntity(BillOfSale domain);
	
	@Mapping(target = "billId", expression = "java(new DomainID(document.getId()))")
	@Mapping(source = "document.ordersIdsList", target = "ordersList", qualifiedByName = "idsToOrders")
	BillOfSale toDomain(BillOfSaleDocument document);
	
	@Named("ordersToIds")
	default List<String> ordersToIds(List<ProductOrder> orders) {
		return orders.stream()
		             .map(order -> order.getOrderId()
		                                .getId())
		             .collect(Collectors.toList());
	}
	
	@Named("idsToOrders")
	default List<ProductOrder> idsToOrders(List<String> ids) {
		return ids.stream()
		          .map(order -> ProductOrder.builder()
		                                    .orderId(new DomainID(order))
		                                    .build())
		          .collect(Collectors.toList());
	}
	
}