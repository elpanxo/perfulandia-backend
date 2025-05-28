package com.perfulandia.pedidos_service.repository;
import com.perfulandia.pedidos_service.model.Usuario;
import com.perfulandia.pedidos_service.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.perfulandia.pedidos_service.model.Pedido;
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    Optional<Pedido> findById(Long id);
}

