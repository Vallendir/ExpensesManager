package pl.expensesmanager.base;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

/**
 * Basic storage adapter for mongo operations.
 *
 * @param <T> type of entity
 */
public abstract class BaseMongoStorage<T> implements BaseStorage<T, String> {
	
	private MongoRepository<T, String> repository;
	
	protected BaseMongoStorage(MongoRepository<T, String> repository) {
		this.repository = repository;
	}
	
	@Override
	public T save(T object) {
		return repository.save(object);
	}
	
	@Override
	public void deleteById(String id) {
		repository.deleteById(id);
	}
	
	@Override
	public Optional<T> findById(String id) {
		return repository.findById(id);
	}
	
	@Override
	public List<T> findAll() {
		return repository.findAll();
	}
	
	@Override
	public boolean isValid(String id) {
		return ObjectId.isValid(id);
	}
	
}
