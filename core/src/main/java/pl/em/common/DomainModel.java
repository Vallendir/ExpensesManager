package pl.em.common;

/**
 * Basic representation of domain objects. All domain objects should extend this class.
 */
public class DomainModel {
	
	@Override
	public String toString() {
		return CommonUtil.readFormatedNotNullFields(this, String.format("%s::", getClass().getSimpleName()));
	}
	
}
