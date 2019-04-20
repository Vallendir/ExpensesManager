package pl.expensesmanager.b;

/**
 * Port to validate given identificator.
 *
 */
public interface IdValidationPort {
	
	/**
	 * Method checks if passed identificator is valid.
	 *
	 * @param id - identificator to validate
	 * @return true if identificator is valid, false if note
	 */
	boolean isValid(EmId id);
	
}
