package com.perfulandia.logisticaservice.model;
import jakarta.persistence.*;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String direccionDestino;

    @ManyToOne
    private Repartidor repartidor;
}
