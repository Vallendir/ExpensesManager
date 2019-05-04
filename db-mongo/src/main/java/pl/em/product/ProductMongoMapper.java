package pl.em.product;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.em.common.MongoMapper;

@Mapper(implementationName = "ProductMapperMongo", componentModel = "spring")
interface ProductMongoMapper extends MongoMapper<ProductDocument, Product> {
	
	@Mapping(source = "productId.id", target = "id")
	ProductDocument toEntity(Product domain);
	
	@Mapping(target = "productId", expression = "java(new DomainID(document.getId()))")
	Product toDomain(ProductDocument document);
	
}
