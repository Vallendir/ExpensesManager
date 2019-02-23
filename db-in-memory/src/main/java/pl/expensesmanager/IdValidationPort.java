package pl.expensesmanager;

import pl.expensesmanager.base.IdValidatorPort;

public abstract class IdValidationPort implements IdValidatorPort<String> {
	
	@Override
	public boolean isValid(String id) {
		return true;
	}
	
}
