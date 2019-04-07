package pl.expensesmanager.b;

import java.util.List;

public interface EMQueryList<T> {
	
	List<T> executeQuery();
	
}
