package pl.expensesmanager.base;

import java.io.Serializable;
import java.util.List;

/**
 * Basic services port.
 *
 * @param <T> representation of object on which serivce works
 * @param <I> type of identificator of object
 */
public interface BaseService<T, I extends Serializable> {
	
	/**
	 * Method to create object and store.
	 *
	 * @param object object to store
	 * @return object which was created
	 */
	T create(T object);
	
	/**
	 * Method to create object and update.
	 *
	 * @param object object to update
	 * @return object which was update
	 */
	T update(T object);
	
	/**
	 * Method to create object and update.
	 *
	 * @param originalObject object to update
	 * @param changes        changes to updated object
	 * @return object which was update
	 */
	T update(T originalObject, T changes);
	
	/**
	 * Method to create object and update.
	 *
	 * @param changes changes to updated object
	 * @param id      identificator of object to update
	 * @return object which was update
	 */
	T update(T changes, I id);
	
	/**
	 * Method to delete object by id.
	 *
	 * @param id identificator of object to delete
	 * @return true if deleted and false if not
	 */
	boolean delete(I id);
	
	/**
	 * Method to search object by id.
	 *
	 * @param id identificator of object to find
	 * @return found object
	 */
	T searchForId(I id);
	
	/**
	 * Method to search all objects.
	 *
	 * @return found objects
	 */
	List<T> searchAll();
	
}