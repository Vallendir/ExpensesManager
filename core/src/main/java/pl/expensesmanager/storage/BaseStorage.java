package pl.expensesmanager.storage;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

interface BaseStorage<T, I extends Serializable> {
	
	/**
	 * Method to store object.
	 *
	 * @param object - object which will be stored
	 * @return object which was stored
	 */
	T add(T object);
	
	/**
	 * Method to update object in storage.
	 *
	 * @param object - object which will be updated
	 * @return object which was updated
	 */
	T update(T object);
	
	/**
	 * Method to update object in storage.
	 *
	 * @param originalObject - object which will be updated
	 * @param changes        - changes which will be updated to @originalObject
	 * @return object which was updated
	 */
	T update(T originalObject, T changes);
	
	/**
	 * Method to update object in storage.
	 *
	 * @param id      - id of object which will be updated
	 * @param changes - changes in object of @id
	 * @return object which was updated
	 */
	T update(I id, T changes);
	
	/**
	 * Method to remove object from storage.
	 *
	 * @param id - id of object which will be removed
	 * @return true if was removed and false if not
	 */
	boolean remove(I id);
	
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