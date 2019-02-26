package pl.expensesmanager.validation;

/**
 * Interface to strategy objects.
 */
public interface ValidationStrategy {
	
	/**
	 * Method to strategy specific strategy.
	 */
	void validate();
	
	/**
	 * Method to execute validation on specific strategy .
	 *
	 * @param strategyValidate - strategy to execute
	 */
	default void validate(ValidationStrategy strategyValidate) {
		strategyValidate.validate();
	}
	
}
