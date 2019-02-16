package pl.expensesmanager.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = "pl.expensesmanager")
@Configuration
public class MongoConfiguration {


}
