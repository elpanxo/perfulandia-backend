package com.perfulandia.usuarioservice.model;
import jakarta.persistence.*;
import lombok.*;

@Entity // transforma la clase en un tabla en la base de datos
@Data // generar getter and setter
@NoArgsConstructor // genera construtor sin arfumentos
@AllArgsConstructor // generar constructor con argunmentos
@Builder // Generar constructores de una manera mas flexible

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String correo;
    private String rol;
    private String direccion;
}
