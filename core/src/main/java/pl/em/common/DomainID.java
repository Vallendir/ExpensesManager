package pl.em.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DomainID {
	
	private final String id;
	
	@Override
	public String toString() {
		return id;
	}
	
}
