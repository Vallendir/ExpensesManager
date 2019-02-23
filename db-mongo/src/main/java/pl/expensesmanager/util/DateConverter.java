package pl.expensesmanager.util;

import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.Instant;

@Component
public class DateConverter {
	
	public Instant dateSqlAsInstant(Date date) {
		return date.toInstant();
	}
	
	public Instant dateAsInstant(java.util.Date date) {
		return date.toInstant();
	}
	
}
