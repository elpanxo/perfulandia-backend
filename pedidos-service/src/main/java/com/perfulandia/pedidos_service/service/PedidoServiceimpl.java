package com.perfulandia.pedidos_service.service;

// Importa la clase Pedido (modelo/entidad) que representa la estructura de datos de un pedido
import com.perfulandia.pedidos_service.model.Pedido;

// Importa el repositorio (interfaz) que permite interactuar con la base de datos
import com.perfulandia.pedidos_service.repository.PedidoRepository;

// Importa la anotación @Service que marca esta clase como un servicio de Spring
import org.springframework.stereotype.Service;

// Importa la anotación @Autowired para inyección de dependencias
import org.springframework.beans.factory.annotation.Autowired;

// Importa la interfaz List para trabajar con colecciones de datos
import java.util.List;

// Importa la clase Optional para manejar posibles valores nulos de forma segura
import java.util.Optional;
/**
 * Implementación concreta del servicio de gestión de pedidos.
 * Contiene la lógica de negocio para operaciones con pedidos.
 */
@Service // Indica que esta clase es un servicio gestionado por Spring
public class PedidoServiceimpl implements PedidosService {

    // Repositorio inyectado para acceder a la base de datos
    private final PedidoRepository pedidoRepository;

    /**
     * Constructor con inyección de dependencias del repositorio.
     * @param pedidoRepository Instancia del repositorio de pedidos
     */
    @Autowired // La anotación puede omitirse en Spring 4.3+ si hay un único constructor
    public PedidoServiceimpl(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    /**
     * Crea y guarda un nuevo pedido en el sistema.
     * @param pedido El objeto Pedido a crear
     * @return El pedido guardado con su ID generado
     */
    @Override
    public Pedido crearPedido(Pedido pedido){
        return pedidoRepository.save(pedido);
    }

    /**
     * Obtiene todos los pedidos existentes en el sistema.
     * @return Lista completa de pedidos
     */
    @Override
    public List<Pedido> listarPedidos(){
        return pedidoRepository.findAll();
    }

    /**
     * Busca un pedido por su ID.
     * @param id Identificador único del pedido
     * @return El pedido encontrado o null si no existe
     */
    @Override
    public Pedido obtenerPedidoPorId(Long id){
        return pedidoRepository.findById(id).orElse(null);
    }

    /**
     * Marca un pedido como disponible para entrega.
     * @param pedido El pedido a marcar como disponible
     * @return El pedido actualizado
     * @throws RuntimeException Si el pedido no existe
     */
    @Override
    public Pedido PedidoDisponible(Pedido pedido) {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(pedido.getId());
        if(pedidoOptional.isPresent()){
            Pedido pedidoDisponible = pedidoOptional.get();
            pedido.setDisponible(true);
            return pedidoDisponible;
        } else {
            throw new RuntimeException("Pedido no disponible");
        }
    }
}