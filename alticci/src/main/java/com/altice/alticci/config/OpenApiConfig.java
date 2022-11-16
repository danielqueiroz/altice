package com.altice.alticci.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Client API")
                        .description("This API provides an endpoint to calculate Alticci sequence numbers.")
                        .version("v1.0")
                        .contact(new Contact()
                                .name("Daniel Queiroz")
                                .email("danielqueiroz@gmail.com")));
    }
}
