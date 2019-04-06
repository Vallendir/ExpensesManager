package pl.expensesmanager.b;

import java.util.List;
import java.util.Optional;

public interface BaseStoreQuery<T, I> {
	
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