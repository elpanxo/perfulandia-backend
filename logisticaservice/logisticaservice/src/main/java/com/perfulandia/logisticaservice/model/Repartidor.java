package com.perfulandia.logisticaservice.model;
import jakarta.persistence.*;

import lombok.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Repartidor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private boolean disponible;
}
