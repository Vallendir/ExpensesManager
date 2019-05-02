package pl.em.product;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMongoMapper {
	
	@Mapping(source = "productId.id", target = "id")
	ProductDocument toEntity(Product domain);
	
	@Mapping(target = "productId", expression = "java(new DomainID(document.getId()))")
	Product toDomain(ProductDocument document);
	
}
