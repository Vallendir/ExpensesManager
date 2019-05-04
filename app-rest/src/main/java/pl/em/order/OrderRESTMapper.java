package pl.em.order;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(implementationName = "OrderMapperREST", componentModel = "spring")
interface OrderRESTMapper {
	
	@Mapping(target = "product", expression = "java(Product.builder().productId(new DomainID(request.getProductId())).build())")
	Order requestToDomain(RequestNewOrder request);
	
	@Mapping(source = "domain.orderId.id", target = "id")
	@Mapping(source = "product.productId.id", target = "productId")
	ResponseNewOrder domainToResponse(Order domain);
	
}
