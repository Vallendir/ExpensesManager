package pl.expensesmanager.billofsale;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.expensesmanager.product.ProductOrderDocument;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "billOfSale")
public class BillOfSaleDocument {
	
	private String id;
	
	private List<ProductOrderDocument> productList;
	
	private Instant boughtDate;
	
	private String description;
	
}
