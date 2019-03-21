package ch.ny.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"ch.ny"})
@EnableJpaRepositories("ch.ny")
@EntityScan("ch.ny")
public class TrialDaysApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrialDaysApplication.class, args);
	}

}
