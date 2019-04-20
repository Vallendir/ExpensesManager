package pl.expensesmanager.b;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public final class EmId {
	
	private final String id;
	
	public static EmId fromObject(Object object) {
		return (EmId.class.isInstance(object)) ? EmId.class.cast(object) : null;
	}
	
}
