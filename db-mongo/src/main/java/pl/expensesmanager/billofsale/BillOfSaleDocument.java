package pl.expensesmanager.billofsale;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.expensesmanager.product.ProductOrder;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "billOfSale")
public class BillOfSaleDocument {
	
	private String id;
	
	private List<ProductOrder> productList;
	
	private Instant boughtDate;
	
	private String description;
	
}
