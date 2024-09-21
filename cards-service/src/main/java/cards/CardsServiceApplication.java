package cards;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
        info = @Info(
                title = "Cards microservice REST API Documentation",
                description = " Bank Cards microservice REST API Documentation",
                version = "v1",
                contact = @Contact(
                        name = "Suyash Singh",
                        email = "tutor@gmail.com",
                        url = "https://www.gmail.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.gmail.com"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Bank Cards microservice REST API Documentation",
                url = "https://www.gmail.com/swagger-ui.html"
        )
)
public class CardsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CardsServiceApplication.class, args);

    }

}
