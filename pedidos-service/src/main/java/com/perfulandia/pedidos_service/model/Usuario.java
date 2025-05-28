package com.perfulandia.pedidos_service.model;

import lombok.*;

/**
 * DTO (Data Transfer Object) que representa la información básica de un usuario.
 * Se utiliza para transferir datos entre el microservicio y los clientes (frontend, otros servicios).
 *
 * Nota: Esta es una versión simplificada que debería contener solo los datos necesarios
 * para la comunicación entre sistemas, no la estructura completa de la entidad Usuario.
 */
@Data // Anotación de Lombok que genera automáticamente:
// - Getters y Setters para todos los campos
// - Métodos toString(), equals() y hashCode()
@AllArgsConstructor // Genera un constructor con todos los campos como argumentos
@NoArgsConstructor  // Genera un constructor vacío (necesario para frameworks como JPA, Jackson)
public class Usuario {

    /**
     * Identificador único del usuario en el sistema.
     * Debería coincidir con el ID en la base de datos.
     */
    private long id;

    /**
     * Nombre completo o identificador del usuario.
     * Ejemplo: "Juan Pérez", "jperez123"
     */
    private String nombre;

    // Lombok evita tener que escribir manualmente:
    // - public long getId() { return id; }
    // - public void setId(long id) { this.id = id; }
    // - public String getNombre() { return nombre; }
    // - public void setNombre(String nombre) { this.nombre = nombre; }
    // - Constructor con parámetros
    // - Constructor vacío
    // - Métodos toString(), equals() y hashCode()
}