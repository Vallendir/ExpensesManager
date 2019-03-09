package pl.expensesmanager.config;

import com.google.common.base.Predicate;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Set;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
class SwaggerConfig {
	
	private static final String APPLICATION_NAME = "ExpensesManager";
	
	private static final String APPLICATION_VERSION = "0.5.0";
	
	private static final Set<String> FORMAT_OF_DATA = Set.of("application/json");
	
	ApiInfo apiInfo() {
		return buildInfo(" - all endpoints of service.");
	}
	
	ApiInfo productInfo() {
		return buildInfo(" - endpoints of Product.");
	}
	
	ApiInfo billOfSaleInfo() {
		return buildInfo(" - endpoints of Bill of Sale.");
	}
	
	ApiInfo budgetInfo() {
		return buildInfo(" - endpoints of Budget.");
	}
	
	ApiInfo orderInfo() {
		return buildInfo(" - endpoints of product Orders.");
	}
	
	private ApiInfo buildInfo(String description) {
		return new ApiInfoBuilder().title(APPLICATION_NAME)
		                           .description(APPLICATION_NAME + description)
		                           .version(APPLICATION_VERSION)
		                           .build();
	}
	
	@Bean
	public Docket appApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName(AppPath.DEFAULT_ORDER)
		                                              .select()
		                                              .apis(RequestHandlerSelectors.basePackage("pl.expensesmanager"))
		                                              .paths(AppPath.defaultPaths())
		                                              .build()
		                                              .enableUrlTemplating(true)
		                                              .consumes(FORMAT_OF_DATA)
		                                              .produces(FORMAT_OF_DATA)
		                                              .useDefaultResponseMessages(false)
		                                              .apiInfo(apiInfo());
	}
	
	@Bean
	public Docket productApi() {
		return buildDocket(AppPath.PRODUCT.getTitle(), AppPath.PRODUCT.getPath(), productInfo());
	}
	
	@Bean
	public Docket billOfSaleApi() {
		return buildDocket(AppPath.BILL_OF_SALE.getTitle(), AppPath.BILL_OF_SALE.getPath(), billOfSaleInfo());
	}
	
	@Bean
	public Docket budgetApi() {
		return buildDocket(AppPath.BUDGET.getTitle(), AppPath.BUDGET.getPath(), budgetInfo());
	}
	
	@Bean
	public Docket orderApi() {
		return buildDocket(AppPath.PRODUCT_ORDER.getTitle(), AppPath.PRODUCT_ORDER.getPath(), orderInfo());
	}
	
	private Docket buildDocket(String groupName, Predicate<String> path, ApiInfo apiInfo) {
		return new Docket(DocumentationType.SWAGGER_2).groupName(groupName)
		                                              .select()
		                                              .paths(path)
		                                              .build()
		                                              .enableUrlTemplating(true)
		                                              .consumes(FORMAT_OF_DATA)
		                                              .produces(FORMAT_OF_DATA)
		                                              .useDefaultResponseMessages(false)
		                                              .apiInfo(apiInfo);
	}
	
	@Getter
	@RequiredArgsConstructor
	private enum AppPath {
		PRODUCT(regex("/product.+"), "2) Product"),
		PRODUCT_ORDER(regex("/order.+"), "3) Product Order"),
		BILL_OF_SALE(regex("/billofsale.+"), "4) Bill of Sale"),
		BUDGET(regex("/budget.+"), "5) Budget");
		
		static String DEFAULT_ORDER = "1) Default";
		
		final Predicate<String> path;
		
		final String title;
		
		static Predicate<String> defaultPaths() {
			return or(AppPath.PRODUCT.getPath(), AppPath.PRODUCT_ORDER.getPath(), AppPath.BILL_OF_SALE.getPath(),
			          AppPath.BUDGET.getPath()
			);
		}
		
	}
	
}