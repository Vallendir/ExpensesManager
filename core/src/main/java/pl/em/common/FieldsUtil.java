package pl.em.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
final class FieldsUtil {
	
	<T> List<String> readAllNotNullFieldsNamesFromClass(T object) {
		return FieldUtils.getAllFieldsList(object.getClass())
		                 .stream()
		                 .filter(field -> !field.getName()
		                                        .equals("log"))
		                 .filter(field -> {
			                 try {
				                 return FieldUtils.readField(field, object, true) != null;
			                 } catch (IllegalAccessException e) {
				                 // TODO
				                 throw new RuntimeException(e);
			                 }
		                 })
		                 .map(Field::getName)
		                 .collect(Collectors.toList());
	}
	
	<T> String readFormatedNotNullFields(T object, String prefix) {
		StringBuilder sb;
		
		if (prefix != null) {
			sb = new StringBuilder(prefix);
		} else {
			sb = new StringBuilder();
		}
		
		readAllNotNullFieldsNamesFromClass(object).forEach(fieldName -> {
			try {
				sb.append("[")
				  .append(fieldName)
				  .append(" -> ")
				  .append(FieldUtils.readField(object, fieldName, true))
				  .append("]");
			} catch (IllegalAccessException e) {
				// TODO
				throw new RuntimeException(e);
			}
		});
		
		return sb.toString();
	}
	
}
