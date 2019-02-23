package pl.expensesmanager.base;

import java.util.List;
import java.util.Optional;

public interface BaseStorage<T, I> {
	
	/**
	 * Method to store object.
	 *
	 * @param object - object which will be stored
	 * @return object which was stored
	 */
	T save(T object);
	
	/**
	 * Method to removeById object from storage.
	 *
	 * @param id - id of object which will be deleted
	 * @return true if was deleted and false if not
	 */
	void deleteById(I id);
	
	/**
	 * Method to find object by id.
	 *
	 * @param id - id of needed object
	 * @return found object
	 */
	Optional<T> findById(I id);
	
	/**
	 * Method to find all objects.
	 *
	 * @return all objects
	 */
	List<T> findAll();
	
}