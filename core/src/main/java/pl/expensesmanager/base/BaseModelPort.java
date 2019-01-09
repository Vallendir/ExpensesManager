package pl.expensesmanager.base;

import lombok.*;
import pl.expensesmanager.util.FieldsUtil;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Port to use in domain ports.
 */
public interface BaseModelPort {
	
	/**
	 * Method to get id.
	 *
	 * @return id
	 */
	String getId();
	
	/**
	 * Method to set id;
	 *
	 * @param id id
	 */
	void setId(String id);
	
	/**
	 * Basic representation of domain objects. All domain objects should extend this class.
	 */
	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	@EqualsAndHashCode
	abstract class BaseModel implements BaseModelPort {
		
		@NotNull
		@Id
		private String id;
		
		@Override
		public String toString() {
			return FieldsUtil.readFormatedNotNullFields(this, String.format("%s::", getClass().getSimpleName()));
		}
		
	}
	
}
