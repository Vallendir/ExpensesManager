package pl.expensesmanager.p;

import lombok.Getter;

class ProductFiltering {
	
	enum Filter {
		ALL,
		ID,
		NAME,
		PRICE_RANGE,
		PRICE_CHEAPER,
		PRICE_EXPENSIVE;
		
		@Getter
		private Object[] parameters;
		
		public Filter of(Object... parameters) {
			this.parameters = parameters;
			return this;
		}
		
	}
	
}
