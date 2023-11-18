package me.mikholsky.practice6;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Practice6Application {
    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .info(new Info()
                        .title("CRUD operations for UNI record book system")
                        .version("0.0.1")
                        .description("Springdoc OpenAPI"));
    }

    public static void main(String[] args) {
        SpringApplication.run(Practice6Application.class, args);
    }

}
