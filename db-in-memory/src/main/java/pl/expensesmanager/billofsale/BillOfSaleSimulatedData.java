package pl.expensesmanager.billofsale;

import pl.expensesmanager.product.ProductOrderPort;
import pl.expensesmanager.product.ProductOrderSimulatedData;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Class with simulated generated data of Bills of sale.
 */
public class BillOfSaleSimulatedData {
	
	private static final String ID_ALIAS = "id_";
	
	private static final String NAME_ALIAS = "BillOfSale_";
	
	public static final int LIST_SIZE = 8;
	
	public static List<BillOfSalePort> LIST;
	
	static {
		LIST = new ArrayList<>();
		
		addBillOfSaleWithProductsToList(1, List.of(ProductOrderSimulatedData.LIST.get(0),
		                                           ProductOrderSimulatedData.LIST.get(1),
		                                           ProductOrderSimulatedData.LIST.get(2),
		                                           ProductOrderSimulatedData.LIST.get(3),
		                                           ProductOrderSimulatedData.LIST.get(4),
		                                           ProductOrderSimulatedData.LIST.get(5)
		), LIST);
		
		addBillOfSaleWithProductsToList(2, List.of(ProductOrderSimulatedData.LIST.get(6),
		                                           ProductOrderSimulatedData.LIST.get(7),
		                                           ProductOrderSimulatedData.LIST.get(8)
		), LIST);
		
		addBillOfSaleWithProductsToList(3, List.of(ProductOrderSimulatedData.LIST.get(9),
		                                           ProductOrderSimulatedData.LIST.get(10),
		                                           ProductOrderSimulatedData.LIST.get(11),
		                                           ProductOrderSimulatedData.LIST.get(12),
		                                           ProductOrderSimulatedData.LIST.get(13),
		                                           ProductOrderSimulatedData.LIST.get(14),
		                                           ProductOrderSimulatedData.LIST.get(15),
		                                           ProductOrderSimulatedData.LIST.get(16)
		), LIST);
		
		addBillOfSaleWithProductsToList(4, List.of(ProductOrderSimulatedData.LIST.get(17),
		                                           ProductOrderSimulatedData.LIST.get(18),
		                                           ProductOrderSimulatedData.LIST.get(19),
		                                           ProductOrderSimulatedData.LIST.get(20),
		                                           ProductOrderSimulatedData.LIST.get(21),
		                                           ProductOrderSimulatedData.LIST.get(22),
		                                           ProductOrderSimulatedData.LIST.get(23),
		                                           ProductOrderSimulatedData.LIST.get(24),
		                                           ProductOrderSimulatedData.LIST.get(25),
		                                           ProductOrderSimulatedData.LIST.get(26),
		                                           ProductOrderSimulatedData.LIST.get(27)
		), LIST);
		
		addBillOfSaleWithProductsToList(5, List.of(ProductOrderSimulatedData.LIST.get(28),
		                                           ProductOrderSimulatedData.LIST.get(29),
		                                           ProductOrderSimulatedData.LIST.get(30),
		                                           ProductOrderSimulatedData.LIST.get(31),
		                                           ProductOrderSimulatedData.LIST.get(32),
		                                           ProductOrderSimulatedData.LIST.get(33),
		                                           ProductOrderSimulatedData.LIST.get(34),
		                                           ProductOrderSimulatedData.LIST.get(35),
		                                           ProductOrderSimulatedData.LIST.get(36),
		                                           ProductOrderSimulatedData.LIST.get(37)
		), LIST);
		
		addBillOfSaleWithProductsToList(6, List.of(ProductOrderSimulatedData.LIST.get(38),
		                                           ProductOrderSimulatedData.LIST.get(39),
		                                           ProductOrderSimulatedData.LIST.get(40),
		                                           ProductOrderSimulatedData.LIST.get(41),
		                                           ProductOrderSimulatedData.LIST.get(42),
		                                           ProductOrderSimulatedData.LIST.get(43)
		), LIST);
		
		addBillOfSaleWithProductsToList(7, List.of(ProductOrderSimulatedData.LIST.get(44),
		                                           ProductOrderSimulatedData.LIST.get(45),
		                                           ProductOrderSimulatedData.LIST.get(46),
		                                           ProductOrderSimulatedData.LIST.get(47)
		), LIST);
		
		addBillOfSaleWithProductsToList(
			8, List.of(ProductOrderSimulatedData.LIST.get(48), ProductOrderSimulatedData.LIST.get(49)), LIST);
		
		
	}
	
	private static void addBillOfSaleWithProductsToList(
		int id, List<ProductOrderPort> productsList, List<BillOfSalePort> list
	) {
		BillOfSalePort billOfSale = createBillOfSale(id, productsList);
		billOfSale.setId(ID_ALIAS + id);
		
		list.add(billOfSale);
	}
	
	private static BillOfSalePort createBillOfSale(int id, List<ProductOrderPort> productsList) {
		return new BillOfSale(productsList, Instant.now(), NAME_ALIAS + id + " Description.");
	}
	
}
