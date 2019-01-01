package pl.expensesmanager.domain;

import lombok.*;

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
abstract class BaseModel {
	
	@NotNull
	@Id
	private String id;
	
}
