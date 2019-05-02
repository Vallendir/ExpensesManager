package pl.em.common;

import java.util.List;
import java.util.Optional;

public interface DomainStorageQuery<T> {
	
	/**
	 * Method to find object by id.
	 *
	 * @param id - id of needed object
	 * @return found object
	 */
	Optional<T> searchById(DomainID id);
	
	/**
	 * Method to find all objects.
	 *
	 * @return all objects
	 */
	List<T> searchAll();
	
}
