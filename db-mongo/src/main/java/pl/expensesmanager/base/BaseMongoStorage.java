package pl.expensesmanager.base;

import org.bson.types.ObjectId;

/**
 * Basic storage adapter for mongo operations.
 */
public abstract class BaseMongoStorage implements IdValidatorPort<String> {
	
	@Override
	public boolean isValid(String id) {
		return ObjectId.isValid(id);
	}
	
}
