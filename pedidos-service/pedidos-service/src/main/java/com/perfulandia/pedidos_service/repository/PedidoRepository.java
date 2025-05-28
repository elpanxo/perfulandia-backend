package com.perfulandia.pedidos_service.repository;

import com.perfulandia.pedidos_service.model.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByUsuarioId(Long usuarioId);
    List<Pedido> findByEstado(String estado);
}