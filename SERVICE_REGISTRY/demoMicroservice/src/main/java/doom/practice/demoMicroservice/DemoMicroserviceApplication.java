package doom.practice.demoMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DemoMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoMicroserviceApplication.class, args);
	}

}
