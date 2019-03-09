package pl.expensesmanager.base;

import lombok.RequiredArgsConstructor;
import pl.expensesmanager.exception.BusinessLogicException;
import pl.expensesmanager.util.MergeUtil;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import static pl.expensesmanager.util.BasicValidator.checkIfGivenIdIsValid;

/**
 * Basic services class.
 *
 * @param <T> representation of object on which serivce works
 */
@RequiredArgsConstructor
public abstract class BaseService<T> {
	
	private final BaseStorage<T, String> storage;
	
	/**
	 * Method to check passed changes to original object
	 *
	 * @param changes        object contains changes
	 * @param originalObject original object
	 */
	protected abstract void checkChangesIn(T changes, T originalObject);
	
	/**
	 * Method to create/update object and store.
	 *
	 * @param object object to store
	 * @return object which was created/updated
	 */
	protected T createObject(Supplier<T> object) {
		return storage.save(object.get());
	}
	
	/**
	 * Method to update object and store. Object will be updated by rewrite fields between two objects.
	 *
	 * @param originalObject original object to update
	 * @param changes        object contains changes to original object update
	 * @return object which was updated
	 */
	protected T updateObject(T originalObject, T changes) {
		checkChangesIn(changes, originalObject);
		
		return createObject(() -> MergeUtil.merge(originalObject, changes));
	}
	
	/**
	 * Method to search object by id.
	 *
	 * @param id identificator of object to find
	 * @return found object
	 */
	protected T searchObjectById(String id, Supplier<BusinessLogicException> exception) {
		checkIfGivenIdIsValid(storage, id);
		
		Optional<T> originalObject = storage.findById(id);
		if (!originalObject.isPresent()) {
			throw exception.get();
		}
		
		return originalObject.get();
	}
	
	/**
	 * Method to create object.
	 *
	 * @param object object to create
	 * @return object which was created
	 */
	public abstract T create(T object);
	
	/**
	 * Method to update an object.
	 *
	 * @param originalObject original object to update
	 * @param changes        changes to updated object
	 * @return updated object
	 */
	public abstract T update(T originalObject, T changes);
	
	/**
	 * Method to update object by id.
	 *
	 * @param changes changes to original object
	 * @param id      id of object to update
	 * @return updated object
	 */
	public abstract T update(T changes, String id);
	
	/**
	 * Find object by id.
	 *
	 * @param id id of object
	 * @return found object
	 */
	public abstract T searchById(String id);
	
	/**
	 * Method to update object and store. Object will be updated by find original object by id and rewrite changed fields from another object.
	 *
	 * @param changes   object contains changes to original object update
	 * @param id        identificator of object which will be updated
	 * @param exception exception which will be thrown when something went wrong with trying to find original object by id
	 * @return object which was updated
	 */
	public T updateObject(T changes, String id, Supplier<BusinessLogicException> exception) {
		T originalObject = searchObjectById(id, exception);
		checkChangesIn(changes, originalObject);
		
		return createObject(() -> MergeUtil.merge(originalObject, changes));
	}
	
	/**
	 * Method to remove object by id.
	 *
	 * @param id identificator of object to remove
	 */
	public void removeObjectById(String id) {
		checkIfGivenIdIsValid(storage, id);
		
		storage.deleteById(id);
	}
	
	/**
	 * Method to search all objects.
	 *
	 * @return found objects
	 */
	public List<T> searchAllObjects() {
		return storage.findAll();
	}
	
}
