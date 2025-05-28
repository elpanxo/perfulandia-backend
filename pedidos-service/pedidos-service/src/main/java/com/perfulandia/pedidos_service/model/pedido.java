package com.perfulandia.pedidos_service.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long usuarioId;

    @Column(nullable = false)
    private String estado; // GENERADO, PAGADO, ENVIADO, ENTREGADO

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion", nullable = false)
    private Date fechaCreacion = new Date();
}