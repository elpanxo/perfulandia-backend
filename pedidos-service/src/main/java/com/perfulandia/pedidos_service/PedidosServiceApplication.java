package com.perfulandia.pedidos_service;

// Importa la clase SpringApplication para arrancar la app
import org.springframework.boot.SpringApplication;
// Importa la anotación de configuración automática
import org.springframework.boot.autoconfigure.SpringBootApplication;
// Importa la anotación para definir beans Spring
import org.springframework.context.annotation.Bean;
// Importa RestTemplate para llamadas HTTP a otros servicios
import org.springframework.web.client.RestTemplate;

/**
 * Clase principal que inicia el microservicio de pedidos.
 * Usa Spring Boot para configuración automática.
 */
@SpringBootApplication // Combina 3 anotaciones importantes:
// 1. @Configuration (clase de configuración)
// 2. @EnableAutoConfiguration (configuración automática)
// 3. @ComponentScan (escaneo de componentes en este paquete)
public class PedidosServiceApplication {

	/**
	 * Punto de entrada de la aplicación.
	 * @param args Argumentos de línea de comandos (no usados aquí)
	 */
	public static void main(String[] args) {
		// Inicia la aplicación Spring Boot
		SpringApplication.run(PedidosServiceApplication.class, args);
	}

	/**
	 * Define un bean RestTemplate para llamadas a otros microservicios.
	 * @return Nueva instancia configurada de RestTemplate
	 */
	@Bean // Registra este objeto en el contenedor de Spring para poder inyectarlo
	public RestTemplate restTemplate(){
		return new RestTemplate(); // Crea cliente REST para consumir APIs
	}
}