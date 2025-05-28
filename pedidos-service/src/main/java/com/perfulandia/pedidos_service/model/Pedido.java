package com.perfulandia.pedidos_service.model;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@Builder
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private String DescripcionPedido;
    private String DireccionEntrega;
    private LocalDateTime fechaEntrega;
    private boolean disponible;
    private String estado;
    public Pedido() {this.fechaEntrega = LocalDateTime.now();
    this.estado = "Pendiente";}

}
