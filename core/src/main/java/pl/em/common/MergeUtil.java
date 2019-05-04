package pl.em.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
final class MergeUtil {
	
	<T> T merge(final T object, final T changes) {
		List<String> changesObjectFieldsNames = CommonUtil.readAllNotNullFields(changes);
		writeFieldsFromMergedObjects(object, changes, changesObjectFieldsNames);
		
		return object;
	}
	
	private <T> void writeFieldsFromMergedObjects(T object, T changes, List<String> changesObjectFieldsNames) {
		changesObjectFieldsNames.forEach(field -> {
			try {
				FieldUtils.writeField(object, field, FieldUtils.readField(changes, field, true), true);
			} catch (IllegalAccessException e) {
				// TODO
				throw new RuntimeException(e);
			}
		});
	}
	
}
