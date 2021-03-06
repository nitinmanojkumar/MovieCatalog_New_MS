package group.microservices.moviecatalogservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


@SpringBootApplication
public class MovieCatalogServicesApplication {

	//RestTemplate Object
	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	//WebClient Object
	@Bean
	public WebClient.Builder getWebClientBuilder(){
		return WebClient.builder();
	}


	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogServicesApplication.class, args);
	}

}
