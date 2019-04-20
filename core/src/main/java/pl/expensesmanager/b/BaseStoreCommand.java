package pl.expensesmanager.b;

import java.util.Optional;

public interface BaseStoreCommand<T> extends IdValidationPort {
	
	/**
	 * Method to store object.
	 *
	 * @param object - object which will be stored
	 * @return object which was stored
	 */
	Optional<T> save(T object);
	
	/**
	 * Method to removeById object from storage.
	 *
	 * @param id - id of object which will be deleted
	 * @return true if was deleted and false if not
	 */
	void deleteById(EmId id);
	
}