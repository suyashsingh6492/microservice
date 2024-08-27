package com.example.accounts;

import com.example.accounts.dto.AccountsContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl") //update createdby , updatedBy
@OpenAPIDefinition //provide the definition details with the help of open API
        (
                info = @Info(title = "Account microservice " //short summary about your REST APIs.
                        ,description = "Account Microservice documentation ",
                        version = "v1",
                        contact = @Contact(
                                name = "suyash",
                                email = "suyashs52@gmail.com"

                        ),
                        license = @License(
                                name = "Apache 2.0"
                        )

                ),
                externalDocs = @ExternalDocumentation(
                        description =  "Accounts microservice REST API Documentation",
                        url = "http://localhost:8085/swagger-ui/index.html"
                )
        )
@EnableConfigurationProperties(value = {AccountsContactInfoDto.class})
@EnableFeignClients
public class AccountsApplication {
//http://localhost:8085/swagger-ui/index.html
    public static void main(String[] args) {
        SpringApplication.run(AccountsApplication.class, args);
    }

}
