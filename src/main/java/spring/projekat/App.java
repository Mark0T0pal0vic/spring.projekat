package spring.projekat;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class App {

	public static void main(String[] args) {
		
		SpringApplication.run(App.class, args);
		
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		
		return new Docket(DocumentationType.SWAGGER_2)
							.select()
							//.paths(PathSelectors.ant("/api/*"))
							.apis(RequestHandlerSelectors.basePackage("spring.projekat"))
							.build()
							.apiInfo(apiDetails());
	}
	
	private ApiInfo apiDetails() {

		return new ApiInfo(
				"Address book API",
				"Api for application",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Marko Topalovic", "http://spring.projekat", "m.topalovic96@gmail.com"),
				"API Licence",
				"http://spring.projekat",
				Collections.emptyList());		
	}
}
