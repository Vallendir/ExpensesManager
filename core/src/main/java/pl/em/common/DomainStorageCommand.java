package pl.em.common;

import java.util.Optional;

public interface DomainStorageCommand<T> {
	
	/**
	 * Method to create object.
	 *
	 * @param object - object which will be stored
	 * @return object which was stored
	 */
	Optional<T> create(T object);
	
	/**
	 * Method to remove object from storage by id.
	 *
	 * @param id - id of object which will be deleted
	 * @return true if was deleted and false if not
	 */
	void remove(DomainID id);
	
}
