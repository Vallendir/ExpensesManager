package pl.expensesmanager.billofsale;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.expensesmanager.product.ProductOrderPort;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class BillOfSaleDocument {
	
	private String id;
	
	private List<ProductOrderPort> productList;
	
	private Instant boughtDate;
	
	private String description;
	
}
