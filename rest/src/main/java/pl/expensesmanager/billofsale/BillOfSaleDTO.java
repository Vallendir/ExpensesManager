package pl.expensesmanager.billofsale;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.expensesmanager.base.BaseModel;
import pl.expensesmanager.product.ProductOrder;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BillOfSaleDTO {
	
	private String id;
	
	private List<String> productIdsList;
	
	private Instant boughtDate;
	
	private String description;
	
	protected BillOfSaleDTO map(BillOfSale billOfSale) {
		return BillOfSaleDTO.builder()
		                    .id(billOfSale.getId())
		                    .description(billOfSale.getDescription())
		                    .boughtDate(billOfSale.getBoughtDate())
		                    .productIdsList(billOfSale.getProductList()
		                                              .stream()
		                                              .map(BaseModel::getId)
		                                              .collect(Collectors.toList()))
		                    .build();
	}
	
	protected BillOfSale map(BillOfSaleDTO billOfSaleDTO) {
		BillOfSale billOfSale = BillOfSale.builder()
		                                  .description(billOfSaleDTO.getDescription())
		                                  .boughtDate(billOfSaleDTO.getBoughtDate())
		                                  .productList(billOfSaleDTO.getProductIdsList()
		                                                            .stream()
		                                                            .map(id -> {
			                                                            ProductOrder order = new ProductOrder();
			                                                            order.setId(id);
			
			                                                            return order;
		                                                            })
		                                                            .collect(Collectors.toList()))
		                                  .build();
		billOfSale.setId(billOfSaleDTO.getId());
		
		return billOfSale;
	}
	
}
