package pl.expensesmanager.product;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class with simulated generated data of Products.
 */
public final class ProductOrderSimulatedData {
	
	private static final String ID_ALIAS = "id_";
	
	public static final int LIST_SIZE = 100;
	
	public static List<ProductOrder> LIST;
	
	static {
		LIST = new ArrayList<>();
		
		
		for (int i = 0; i < ProductSimulatedData.LIST_SIZE; i++) {
			ProductOrder order;
			ProductOrder nextOrder;
			int id = i + 1;
			int nextId = LIST_SIZE - i;
			
			Product product = ProductSimulatedData.LIST.get(i);
			int min, max;
			
			if (product.getPrice() < 2) {
				min = 15;
				max = 20;
				
				order = new ProductOrder(product, generateQuanity(min, max));
				nextOrder = new ProductOrder(product, generateQuanity(min + 1, max + 3));
			} else if (product.getPrice() >= 2 && product.getPrice() < 5) {
				min = 10;
				max = 15;
				
				order = new ProductOrder(product, generateQuanity(min, max));
				nextOrder = new ProductOrder(product, generateQuanity(min + 1, max + 3));
			} else if (product.getPrice() >= 5 && product.getPrice() <= 10) {
				min = 6;
				max = 10;
				
				order = new ProductOrder(product, generateQuanity(min, max));
				nextOrder = new ProductOrder(product, generateQuanity(min + 1, max + 3));
			} else {
				min = 1;
				max = 6;
				
				order = new ProductOrder(product, generateQuanity(min, max));
				nextOrder = new ProductOrder(product, generateQuanity(min + 1, max + 3));
			}
			
			order.setId(ID_ALIAS + id);
			nextOrder.setId(ID_ALIAS + nextId);
			
			LIST.add(order);
			LIST.add(nextOrder);
		}
	}
	
	private static int generateQuanity(int min, int max) {
		return ThreadLocalRandom.current()
		                        .nextInt(min, max + 1);
	}
	
}
