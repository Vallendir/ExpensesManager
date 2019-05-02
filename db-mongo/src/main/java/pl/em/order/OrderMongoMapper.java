package pl.em.order;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
interface OrderMongoMapper {
	
	@Mapping(source = "orderId.id", target = "id")
	@Mapping(source = "product.productId.id", target = "productId")
	OrderDocument toEntity(Order domain);
	
	@Mapping(target = "orderId", expression = "java(new DomainID(document.getId()))")
	@Mapping(target = "product", expression = "java(Product.builder().productId(new DomainID(document.getProductId())).build())")
	Order toDomain(OrderDocument document);
	
}
