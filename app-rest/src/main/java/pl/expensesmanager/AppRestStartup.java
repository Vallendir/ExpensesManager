package pl.expensesmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import pl.expensesmanager.config.SwaggerConfig;

@SpringBootApplication
@Import({ SwaggerConfig.class })
public class AppRestStartup {
	
	public static void main(String[] args) {
		SpringApplication.run(AppRestStartup.class, args);
	}
	
}
