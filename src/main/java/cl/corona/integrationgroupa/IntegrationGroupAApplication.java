package cl.corona.integrationgroupa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class IntegrationGroupAApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntegrationGroupAApplication.class, args);
	}

}
