package pl.expensesmanager.budget;

import pl.expensesmanager.billofsale.BillOfSale;
import pl.expensesmanager.billofsale.BillOfSaleSimulatedData;
import java.util.ArrayList;
import java.util.List;

/**
 * Class with simulated generated data of Budget.
 */
public class BudgetSimulatedData {
	
	private static final String ID_ALIAS = "id_";
	
	private static final String NAME_ALIAS = "Budget_";
	
	public static final int LIST_SIZE = 2;
	
	public static List<Budget> LIST;
	
	static {
		LIST = new ArrayList<>();
		double budgetValue = 0.0;
		
		List<BillOfSale> billsOfSale_1 = List.of(
			BillOfSaleSimulatedData.LIST.get(0),
			BillOfSaleSimulatedData.LIST.get(2),
			BillOfSaleSimulatedData.LIST.get(3),
			BillOfSaleSimulatedData.LIST.get(5),
			BillOfSaleSimulatedData.LIST.get(7)
		);
		double billsOfSaleSummary_1 = billsOfSale_1.stream()
		                                           .mapToDouble(x -> x.finalPrice())
		                                           .summaryStatistics()
		                                           .getSum();
		
		if (billsOfSaleSummary_1 > 2000) {
			budgetValue = 5000;
		} else if (billsOfSaleSummary_1 < 2000 && billsOfSaleSummary_1 > 1000) {
			budgetValue = 3500;
		} else if (billsOfSaleSummary_1 < 1000) {
			budgetValue = 2500;
		}
		createBudget(1, billsOfSale_1, budgetValue);
		
		
		List<BillOfSale> billsOfSale_2 = List.of(BillOfSaleSimulatedData.LIST.get(1),
		                                             BillOfSaleSimulatedData.LIST.get(4),
		                                             BillOfSaleSimulatedData.LIST.get(6)
		);
		double billsOfSaleSummary_2 = billsOfSale_2.stream()
		                                           .mapToDouble(x -> x.finalPrice())
		                                           .summaryStatistics()
		                                           .getSum();
		
		if (billsOfSaleSummary_2 > 1700) {
			budgetValue = 1700;
		} else if (billsOfSaleSummary_2 < 1700 && billsOfSaleSummary_2 > 1600) {
			budgetValue = 1150;
		} else if (billsOfSaleSummary_2 < 1600 && billsOfSaleSummary_2 > 1500) {
			budgetValue = 1075;
		} else if (billsOfSaleSummary_1 < 500) {
			budgetValue = 0;
		}
		createBudget(2, billsOfSale_2, budgetValue);
	}
	
	private static void createBudget(int id, List<BillOfSale> billsOfSale, double budgetValue) {
		Budget budget = new Budget(NAME_ALIAS + id, budgetValue, billsOfSale);
		budget.setId(ID_ALIAS + id);
		
		LIST.add(budget);
	}
	
}
