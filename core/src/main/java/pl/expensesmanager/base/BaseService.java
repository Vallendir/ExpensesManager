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
	 * Method to update object and store. Object will be updated by find original object by id and rewrite changed fields from another object.
	 *
	 * @param changes   object contains changes to original object update
	 * @param id        identificator of object which will be updated
	 * @param exception exception which will be thrown when something went wrong with trying to find original object by id
	 * @return object which was updated
	 */
	public T updateObject(T changes, String id, Supplier<BusinessLogicException> exception) {
		Optional<T> originalObject = searchObjectById(id);
		if (!originalObject.isPresent()) {
			throw exception.get();
		}
		checkChangesIn(changes, originalObject.get());
		
		return createObject(() -> MergeUtil.merge(originalObject.get(), changes));
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
	 * Method to search object by id.
	 *
	 * @param id identificator of object to find
	 * @return found object
	 */
	public Optional<T> searchObjectById(String id) {
		checkIfGivenIdIsValid(storage, id);
		
		return storage.findById(id);
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
