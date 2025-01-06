package teyvatexp.authorization_server.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
		"teyvatexp.authorization_server.core",
		"teyvatexp.authorization_server.app",
		"teyvatexp.authorization_server.storage"
})
@EnableJpaRepositories(basePackages = "teyvatexp.authorization_server.storage.repository")
@EntityScan(basePackages = "teyvatexp.authorization_server.storage.entity")
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

}
