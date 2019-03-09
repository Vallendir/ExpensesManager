package pl.expensesmanager.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = "pl.expensesmanager")
@Profile("mongo")
@Configuration
public class MongoConfiguration {


}
