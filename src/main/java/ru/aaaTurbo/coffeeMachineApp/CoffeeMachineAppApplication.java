package ru.aaaTurbo.coffeeMachineApp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Coffee Machine Application",
				version = "1.0",
				description = "AISA testing task",
				contact = @Contact(
						name = "Anton Semenov",
						email = "antsemion@gmail.com"
				)
		)
)
public class CoffeeMachineAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeMachineAppApplication.class, args);
	}

}
