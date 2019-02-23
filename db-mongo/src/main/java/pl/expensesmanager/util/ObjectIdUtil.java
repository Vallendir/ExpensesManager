package pl.expensesmanager.util;

import lombok.experimental.UtilityClass;
import org.bson.types.ObjectId;

@UtilityClass
public final class ObjectIdUtil {
	
	public static String objectIdAsString(ObjectId objectId) {
		return objectId.toString();
	}
	
	public static ObjectId stringAsObjectId(String id) {
		return new ObjectId(id);
	}
	
}
