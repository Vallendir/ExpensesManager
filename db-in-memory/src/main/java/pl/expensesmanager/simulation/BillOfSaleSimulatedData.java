package pl.expensesmanager.simulation;

import pl.expensesmanager.domain.BillOfSale;
import pl.expensesmanager.domain.BillOfSalePort;
import pl.expensesmanager.domain.ProductPort;

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
		
		addBillOfSaleWithProductsToList(1, List.of(ProductSimulatedData.LIST.get(0), ProductSimulatedData.LIST.get(10),
		                                           ProductSimulatedData.LIST.get(20), ProductSimulatedData.LIST.get(30),
		                                           ProductSimulatedData.LIST.get(40), ProductSimulatedData.LIST.get(50),
		                                           ProductSimulatedData.LIST.get(60), ProductSimulatedData.LIST.get(70),
		                                           ProductSimulatedData.LIST.get(80), ProductSimulatedData.LIST.get(90),
		                                           ProductSimulatedData.LIST.get(7), ProductSimulatedData.LIST.get(17),
		                                           ProductSimulatedData.LIST.get(27), ProductSimulatedData.LIST.get(37)
		), LIST);
		
		addBillOfSaleWithProductsToList(2, List.of(ProductSimulatedData.LIST.get(1), ProductSimulatedData.LIST.get(11),
		                                           ProductSimulatedData.LIST.get(21), ProductSimulatedData.LIST.get(31),
		                                           ProductSimulatedData.LIST.get(41), ProductSimulatedData.LIST.get(51)
		), LIST);
		
		addBillOfSaleWithProductsToList(3, List.of(ProductSimulatedData.LIST.get(61), ProductSimulatedData.LIST.get(71),
		                                           ProductSimulatedData.LIST.get(81), ProductSimulatedData.LIST.get(91),
		                                           ProductSimulatedData.LIST.get(2), ProductSimulatedData.LIST.get(12),
		                                           ProductSimulatedData.LIST.get(32), ProductSimulatedData.LIST.get(42),
		                                           ProductSimulatedData.LIST.get(52), ProductSimulatedData.LIST.get(62),
		                                           ProductSimulatedData.LIST.get(72), ProductSimulatedData.LIST.get(82),
		                                           ProductSimulatedData.LIST.get(92)
		), LIST);
		
		addBillOfSaleWithProductsToList(4, List.of(ProductSimulatedData.LIST.get(3), ProductSimulatedData.LIST.get(13),
		                                           ProductSimulatedData.LIST.get(23), ProductSimulatedData.LIST.get(33),
		                                           ProductSimulatedData.LIST.get(43), ProductSimulatedData.LIST.get(53),
		                                           ProductSimulatedData.LIST.get(63), ProductSimulatedData.LIST.get(73),
		                                           ProductSimulatedData.LIST.get(18), ProductSimulatedData.LIST.get(28),
		                                           ProductSimulatedData.LIST.get(38), ProductSimulatedData.LIST.get(48),
		                                           ProductSimulatedData.LIST.get(58), ProductSimulatedData.LIST.get(83),
		                                           ProductSimulatedData.LIST.get(93)
		), LIST);
		
		addBillOfSaleWithProductsToList(5, List.of(ProductSimulatedData.LIST.get(4), ProductSimulatedData.LIST.get(14),
		                                           ProductSimulatedData.LIST.get(24), ProductSimulatedData.LIST.get(34),
		                                           ProductSimulatedData.LIST.get(44), ProductSimulatedData.LIST.get(54),
		                                           ProductSimulatedData.LIST.get(84), ProductSimulatedData.LIST.get(94),
		                                           ProductSimulatedData.LIST.get(9), ProductSimulatedData.LIST.get(19),
		                                           ProductSimulatedData.LIST.get(29), ProductSimulatedData.LIST.get(39),
		                                           ProductSimulatedData.LIST.get(49), ProductSimulatedData.LIST.get(59),
		                                           ProductSimulatedData.LIST.get(69), ProductSimulatedData.LIST.get(79),
		                                           ProductSimulatedData.LIST.get(89), ProductSimulatedData.LIST.get(99)
		), LIST);
		
		addBillOfSaleWithProductsToList(6, List.of(ProductSimulatedData.LIST.get(5), ProductSimulatedData.LIST.get(15),
		                                           ProductSimulatedData.LIST.get(25), ProductSimulatedData.LIST.get(35),
		                                           ProductSimulatedData.LIST.get(45), ProductSimulatedData.LIST.get(55),
		                                           ProductSimulatedData.LIST.get(65), ProductSimulatedData.LIST.get(75),
		                                           ProductSimulatedData.LIST.get(8), ProductSimulatedData.LIST.get(78),
		                                           ProductSimulatedData.LIST.get(88), ProductSimulatedData.LIST.get(98),
		                                           ProductSimulatedData.LIST.get(47), ProductSimulatedData.LIST.get(57),
		                                           ProductSimulatedData.LIST.get(67), ProductSimulatedData.LIST.get(77)
		), LIST);
		
		addBillOfSaleWithProductsToList(7, List.of(ProductSimulatedData.LIST.get(6), ProductSimulatedData.LIST.get(16),
		                                           ProductSimulatedData.LIST.get(26), ProductSimulatedData.LIST.get(36),
		                                           ProductSimulatedData.LIST.get(46), ProductSimulatedData.LIST.get(56),
		                                           ProductSimulatedData.LIST.get(66), ProductSimulatedData.LIST.get(76),
		                                           ProductSimulatedData.LIST.get(86), ProductSimulatedData.LIST.get(96),
		                                           ProductSimulatedData.LIST.get(87), ProductSimulatedData.LIST.get(97)
		), LIST);
		
		addBillOfSaleWithProductsToList(8, List.of(ProductSimulatedData.LIST.get(85), ProductSimulatedData.LIST.get(95),
		                                           ProductSimulatedData.LIST.get(64), ProductSimulatedData.LIST.get(74),
		                                           ProductSimulatedData.LIST.get(68), ProductSimulatedData.LIST.get(22)
		), LIST);
		
		
	}
	
	private static void addBillOfSaleWithProductsToList(
		int id, List<ProductPort> productsList, List<BillOfSalePort> list
	) {
		BillOfSalePort billOfSale = createBillOfSale(id, productsList);
		billOfSale.setId(ID_ALIAS + id);
		
		list.add(billOfSale);
	}
	
	private static BillOfSalePort createBillOfSale(int id, List<ProductPort> productsList) {
		return new BillOfSale(productsList, Instant.now(), NAME_ALIAS + id + " Description.");
	}
	
}
