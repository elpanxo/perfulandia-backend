package com.perfulandia.pedidoservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long usuarioId;
    private Long carritoId;

    @Enumerated(EnumType.STRING)
    private EstadoPedido estado;

    private Date fechaCreacion;
    private Date fechaActualizacion;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemPedido> items;

    private double total;
    private String direccionEnvio;
}
