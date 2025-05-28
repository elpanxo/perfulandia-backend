package com.perfulandia.pedidos_service.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

/**
 * Representa un pedido en el sistema con toda su información relevante.
 * Esta clase se mapea directamente a una tabla en la base de datos.
 */
@Entity  // Indica que esta clase es una entidad JPA (se guarda en la base de datos)
@Data  // Genera automáticamente getters, setters, toString, equals y hashCode
@AllArgsConstructor  // Genera un constructor con todos los argumentos
@Builder  // Permite usar el patrón Builder para crear instancias
public class Pedido {

    @Id  // Marca este campo como la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // El ID se autoincrementa
    private Long id;

    private String codigo;  // Código único identificador del pedido

    private String DescripcionPedido;  // Detalles sobre lo que contiene el pedido

    private String DireccionEntrega;  // Lugar donde se debe entregar el pedido

    private LocalDateTime fechaEntrega;  // Cuándo se debe entregar el pedido

    private boolean disponible;  // Si el pedido está listo para entregarse

    private String estado;  // Estado actual del pedido (Pendiente, En camino, Entregado, etc.)

    /**
     * Constructor por defecto que inicializa valores automáticamente:
     * - Establece la fecha actual como fecha de entrega
     * - Pone el estado inicial como "Pendiente"
     */
    public Pedido() {
        this.fechaEntrega = LocalDateTime.now();
        this.estado = "Pendiente";
    }
}