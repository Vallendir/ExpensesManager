package pl.expensesmanager.util;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.util.List;

import static pl.expensesmanager.exception.InternalExceptionFactory.illegalAccessException;

@UtilityClass
public final class MergeUtil {
	
	public static <T> T merge(final T object, final T changes) {
		List<String> changesObjectFieldsNames = FieldsUtil.readAllNotNullFieldsNamesFromClass(changes);
		writeFieldsFromMergedObjects(object, changes, changesObjectFieldsNames);
		
		return object;
	}
	
	private static <T> void writeFieldsFromMergedObjects(T object, T changes, List<String> changesObjectFieldsNames) {
		changesObjectFieldsNames.forEach(field -> {
			try {
				FieldUtils.writeField(object, field, FieldUtils.readField(changes, field, true), true);
			} catch (IllegalAccessException e) {
				throw illegalAccessException(e);
			}
		});
	}
	
}