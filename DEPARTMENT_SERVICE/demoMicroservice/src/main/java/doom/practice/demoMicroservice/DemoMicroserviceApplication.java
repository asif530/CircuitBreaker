package doom.practice.demoMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemoMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoMicroserviceApplication.class, args);
	}

	@Bean
	//@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
