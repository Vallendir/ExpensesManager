package pl.em.common;

import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

@NoArgsConstructor
public class MongoStorage<E, D, M extends MongoMapper<E, D>, R extends MongoRepository<E, String>> {
	
	private M mapper;
	
	private R repository;
	
	public MongoStorage(M mapper, R repository) {
		this.mapper = mapper;
		this.repository = repository;
	}
	
	public boolean isIdValid(String id) {
		return ObjectId.isValid(id);
	}
	
	protected D toDomain(E entity) {
		return mapper.toDomain(entity);
	}
	
	protected E toEntity(D domain) {
		return mapper.toEntity(domain);
	}
	
	protected D store(D object) {
		var entity = toEntity(object);
		var saved = repository.save(entity);
		
		return toDomain(saved);
	}
	
	protected void delete(String id) {
		repository.deleteById(id);
	}
	
}
