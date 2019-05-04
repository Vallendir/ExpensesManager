package pl.em.common;

import java.util.List;
import java.util.Objects;

public final class CommonUtil {
	
	private static FieldsUtil fields = null;
	
	private static MergeUtil merge = null;
	
	private static MergeUtil mergeUtil() {
		if (Objects.isNull(merge)) {
			merge = new MergeUtil();
		}
		
		return merge;
	}
	
	private static FieldsUtil fieldsUtil() {
		if (Objects.isNull(fields)) {
			fields = new FieldsUtil();
		}
		
		return fields;
	}
	
	public static <T> List<String> readAllNotNullFields(T object) {
		return fieldsUtil().readAllNotNullFieldsNamesFromClass(object);
	}
	
	public static <T> String readFormatedNotNullFields(T object, String prefix) {
		return fieldsUtil().readFormatedNotNullFields(object, prefix);
	}
	
	public static <T> T merge(final T object, final T changes) {
		return mergeUtil().merge(object, changes);
	}
	
}
