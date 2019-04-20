package pl.expensesmanager.b;

import java.util.List;
import java.util.Optional;

public interface BaseStoreQuery<T> extends IdValidationPort {
	
	/**
	 * Method to find object by id.
	 *
	 * @param id - id of needed object
	 * @return found object
	 */
	Optional<T> findById(EmId id);
	
	/**
	 * Method to find all objects.
	 *
	 * @return all objects
	 */
	List<T> findAll();
	
}