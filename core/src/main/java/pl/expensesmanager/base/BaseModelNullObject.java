package pl.expensesmanager.base;

/**
 * Representation of basic null object pattern.
 */
public abstract class BaseModelNullObject {
	
	public String getId() {
		return "ID_of_null_object";
	}
	
	public void setId(String id) {
	
	}
	
	@Override
	public String toString() {
		return "NULL object found.";
	}
	
}
