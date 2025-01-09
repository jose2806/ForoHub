package com.foro_hub.Foro_Hub.infra.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class SpringDocConfiguration {

    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI().components(new Components()
                .addSecuritySchemes("bearer-key",new SecurityScheme().
                        type(SecurityScheme.Type.HTTP).scheme("bearer")
                        .bearerFormat("JWT"))).info(new Info().title("Foro_Hub API")
                .description("API Rest de la aplicación Foro Hub, que contiene las funcionalidades CRUD")
                .contact(new Contact().name("Equipo Backend").email("backend@foro.hub"))
                .license(new License().name("Apache 2.0").url("http://foro.hub/api/licencia")));
    }
}
