package pl.expensesmanager.b;

public interface Validator<T> {
	
	void validate(T object);
	
}
