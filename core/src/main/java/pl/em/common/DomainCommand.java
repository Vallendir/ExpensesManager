package pl.em.common;

public interface DomainCommand<T> {
	
	T execute();
	
}
