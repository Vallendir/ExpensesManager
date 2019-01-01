package pl.expensesmanager.domain;

import lombok.*;

/**
 * Representation of Budget.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Budget extends BaseModel implements BudgetApi {
	
	private String name;

	@Setter(AccessLevel.NONE)
	private Double budgetValue;
	
}
