package com.perfulandia.carritoservice.repository;
import com.perfulandia.carritoservice.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarritoRepository extends JpaRepository< Producto, Long> {
}
