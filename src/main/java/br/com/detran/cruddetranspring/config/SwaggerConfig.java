package br.com.detran.cruddetranspring.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;



@OpenAPIDefinition(
		 info = @Info(
	                contact = @Contact(
	                        name = "Emannuel Morais",
	                        email = "emanuelmorais2015@gmail.com",
	                        url = " https://github.com/DevEmannuelMorais"
	                ),
	                description = "OpenApi documentation do crud Proprietario e Veiculo usando Spring Boot",
	                title = "OpenApi especificações - DevEmannuelMorais",
	                version = "1.0",
	               termsOfService = "Termos de Seviço: Open Source"
	        ),
	        servers = {
	                @Server(
	                        description = "Local ENV",
	                        url = "http://localhost:8080"
	                )
	        }
		
		)
public class SwaggerConfig {
	
}
