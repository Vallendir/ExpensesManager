package pl.em.billofsale;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "billOfSale")
public class BillOfSaleDocument {
	
	private String id;
	
	private List<String> ordersIdsList;
	
	private Instant boughtDate;
	
	private String description;
	
}
