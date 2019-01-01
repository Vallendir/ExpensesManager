package pl.expensesmanager.util;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.util.List;

@Slf4j
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
				// FIXME Catch this exception and do something more than only log
				log.error(e.getMessage());
			}
		});
	}
	
}