package pl.expensesmanager.base;

import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * Basic REST controller
 *
 * @param <T>
 */
@RequiredArgsConstructor
public abstract class BaseRESTController<T> {
	
	private final BaseService<T> service;
	
	/**
	 * Method to create and store object.
	 *
	 * @param object object to create
	 * @return created object
	 */
	public T add(T object) {
		return service.create(object);
	}
	
	/**
	 * Method to update an object and store.
	 *
	 * @param object object to update
	 * @return updated object
	 */
	public T update(T object) {
		return service.create(object);
	}
	
	/**
	 * Method to update an object by id and store.
	 *
	 * @param id     id of object which will be updated
	 * @param object object to update
	 * @return updated object
	 */
	public T update(String id, T object) {
		return service.update(object, id);
	}
	
	/**
	 * Method to find object by id.
	 *
	 * @param id id of object to search
	 * @return found object
	 */
	public T searchForId(String id) {
		return service.searchById(id);
	}
	
	/**
	 * Method to remove object by id.
	 *
	 * @param id id of object to remove
	 */
	protected void delete(String id) {
		service.removeObjectById(id);
	}
	
	/**
	 * Method to find all objects.
	 *
	 * @return all objects
	 */
	protected List<T> searchAll() {
		return service.searchAllObjects();
	}
	
}
