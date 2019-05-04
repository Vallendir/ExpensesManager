package pl.em.billofsale;

import pl.em.common.DomainID;
import pl.em.common.MongoStorage;

import java.util.List;
import java.util.Optional;

class BillOfSaleQueryMongoStorage extends MongoStorage<BillOfSaleDocument, BillOfSale, BillOfSaleMongoMapper, BillOfSaleMongoRepository> implements BillOfSaleQueryStorage {
	
	private final BillOfSaleMongoRepository repository;
	
	BillOfSaleQueryMongoStorage(BillOfSaleMongoRepository repository) {
		super(new BillOfSaleMapperMongo(), repository);
		this.repository = repository;
	}
	
	@Override
	public Optional<BillOfSale> searchById(DomainID id) {
		return Optional.empty();
	}
	
	@Override
	public List<BillOfSale> searchAll() {
		return null;
	}
	
}
