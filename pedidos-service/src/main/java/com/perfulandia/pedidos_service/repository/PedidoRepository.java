package com.perfulandia.pedidos_service.repository;

// Importa la clase Usuario (aunque no se usa en este repositorio)
import com.perfulandia.pedidos_service.model.Usuario;
// Importación duplicada de la misma clase (puede eliminarse una)
import com.perfulandia.pedidos_service.model.Usuario;
// Importa las clases necesarias para JPA
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
// Importa la entidad Pedido que este repositorio gestionará
import com.perfulandia.pedidos_service.model.Pedido;

/**
 * Repositorio para la entidad Pedido que extiende JpaRepository.
 * Proporciona operaciones CRUD básicas y métodos de consulta.
 */
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    /**
     * Busca un pedido por su ID.
     * @param id El ID del pedido a buscar
     * @return Optional que contiene el pedido si existe, o vacío si no
     */
    Optional<Pedido> findById(Long id);

    // Nota: JpaRepository ya provee este método por defecto,
    // pero al declararlo explícitamente podemos documentarlo.
}