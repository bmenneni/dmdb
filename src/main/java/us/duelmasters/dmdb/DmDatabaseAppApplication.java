package us.duelmasters.dmdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@EnableJdbcRepositories(basePackages = "us.duelmasters.dmdb.repositories")
public class DmDatabaseAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DmDatabaseAppApplication.class, args);
	}

}
