package pl.em.product;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductOrderMongoMapper {
	
	@Mapping(source = "orderId.id", target = "id")
	@Mapping(source = "product.productId.id", target = "productId")
	ProductOrderDocument toEntity(ProductOrder domain);
	
	@Mapping(target = "orderId", expression = "java(new DomainID(document.getId()))")
	@Mapping(target = "product", expression = "java(Product.builder().productId(new DomainID(document.getProductId())).build())")
	ProductOrder toDomain(ProductOrderDocument document);
	
}
