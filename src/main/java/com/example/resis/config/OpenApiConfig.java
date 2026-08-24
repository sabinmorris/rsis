package com.example.resis.config;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "RESIS",
                        email = "info@.rsis.go.tz",
                        url = "https://rsis.go.tz"
                ),
                description = "API GATEWAY  System",
                title = "OpenApi specification - Api GATEWAY Service",
                version = "1.0",
                license = @License(
                        name = "Licence name",
                        url = "https://some-url.com"
                ),
                termsOfService = "Terms of service"
        ),
        servers = {
                @Server(url = "http://102.214.45.147:6045/lookup-service", description = "TEST SERVER"),
                @Server(url = "http://102.214.45.147:6041/", description = "TEST SERVER"),
                @Server(url = "http://localhost:6041/", description = "LOCAL"),
                @Server(url = "https://rsisbackend.tamisemim.go.tz", description = "LIVE SERVER")
        },

        security = {
                @SecurityRequirement(
                        name = "bearerAuth"
                )
        }
)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT auth description",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {
}
