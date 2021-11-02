package upc.edu.pe.FortlomBackend;
import java.util.Collections;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
@SpringBootApplication
public class FortlomBackendApplication {

	public static void main(String[] args) {

		SpringApplication app =new SpringApplication(FortlomBackendApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8082"));
		app.run(args);
	}

}
