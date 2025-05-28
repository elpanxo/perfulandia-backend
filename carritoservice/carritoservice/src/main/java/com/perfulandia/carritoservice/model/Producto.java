package com.perfulandia.carritoservice.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Producto {
    @Id
    private Long id;
    private String nombre;
    private double precio;
}
