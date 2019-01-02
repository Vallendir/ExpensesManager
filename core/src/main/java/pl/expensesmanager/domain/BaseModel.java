package pl.expensesmanager.domain;

import lombok.*;
import lombok.experimental.Accessors;
import pl.expensesmanager.util.FieldsUtil;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

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
