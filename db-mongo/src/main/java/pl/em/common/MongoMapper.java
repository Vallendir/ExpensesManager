package pl.em.common;

public interface MongoMapper<E, D> {
	
	E toEntity(D domain);
	
	D toDomain(E document);
	
}
