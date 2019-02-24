package pl.expensesmanager.base;

/**
 * Port to validate given identificator.
 *
 * @param <ID>
 */
public interface IdValidatorPort<ID> {
	
	/**
	 * Method checks if passed identificator is valid.
	 *
	 * @param id - identificator to validate
	 * @return true if identificator is valid, false if note
	 */
	boolean isValid(ID id);
	
}
