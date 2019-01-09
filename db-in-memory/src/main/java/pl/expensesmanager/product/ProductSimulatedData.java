package pl.expensesmanager.product;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class with simulated generated data of Products.
 */
public final class ProductSimulatedData {
	
	private static final String ID_ALIAS = "id_";
	
	private static final String NAME_ALIAS = "Product_";
	
	public static final int LIST_SIZE = 100;
	
	public static List<ProductPort> LIST;
	
	static {
		LIST = new ArrayList<>();
		Double priceStart = 0.35;
		int min, max;
		
		for (int i = 0; i < LIST_SIZE; i++) {
			ProductPort product = null;
			int id = i + 1;
			
			if (priceStart < 2) {
				min = 15;
				max = 20;
				
				product = new Product(NAME_ALIAS + id, priceStart, generateQuanity(min, max));
			} else if (priceStart >= 2 && priceStart < 5) {
				min = 10;
				max = 15;
				
				product = new Product(NAME_ALIAS + id, priceStart, generateQuanity(min, max));
			} else if (priceStart >= 5 && priceStart <= 10) {
				min = 6;
				max = 10;
				
				product = new Product(NAME_ALIAS + id, priceStart, generateQuanity(min, max));
			} else {
				min = 1;
				max = 6;
				
				product = new Product(NAME_ALIAS + id, priceStart, generateQuanity(min, max));
			}
			
			product.setId(ID_ALIAS + String.valueOf(id));
			LIST.add(product);
			
			priceStart += 0.15;
		}
	}
	
	private static int generateQuanity(int min, int max) {
		return ThreadLocalRandom.current()
		                        .nextInt(min, max + 1);
	}
	
}
