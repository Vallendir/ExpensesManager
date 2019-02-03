package pl.expensesmanager.product;

import java.util.ArrayList;
import java.util.List;

/**
 * Class with simulated generated data of Products.
 */
public final class ProductSimulatedData {
	
	private static final String ID_ALIAS = "id_";
	
	private static final String NAME_ALIAS = "Product_";
	
	public static final int LIST_SIZE = 50;
	
	public static List<ProductPort> LIST;
	
	static {
		LIST = new ArrayList<>();
		Double priceStart = 0.35;
		
		for (int i = 0; i < LIST_SIZE; i++) {
			int id = i + 1;
			
			ProductPort product = new Product(NAME_ALIAS + id, priceStart);
			
			product.setId(ID_ALIAS + id);
			LIST.add(product);
			
			priceStart += 0.15;
		}
	}
	
}
