package pl.em.product;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(implementationName = "ProductMapperREST", componentModel = "spring")
interface ProductRESTMapper {
	
	Product requestToDomain(RequestNewProduct request);
	
	@Mapping(source = "productId.id", target = "id")
	ResponseNewProduct domainToResponse(Product domain);
	
}
