package com.perfulandia.pedidos_service.service;

import com.perfulandia.pedidos_service.model.Pedido; // Importa la clase modelo Pedido
import java.util.List; // Importa la interfaz List para devolver colecciones

/**
 * Interfaz que define el contrato para el servicio de gestión de pedidos.
 * Contiene las operaciones básicas que cualquier implementación debe proveer.
 */
public interface PedidosService {

    /**
     * Crea un nuevo pedido en el sistema
     * @param pedido Objeto Pedido con los datos a guardar
     * @return El pedido creado con su ID generado
     */
    Pedido crearPedido(Pedido pedido);

    /**
     * Obtiene todos los pedidos existentes
     * @return Lista completa de pedidos (vacía si no hay registros)
     */
    List<Pedido> listarPedidos();

    /**
     * Busca un pedido específico por su identificador
     * @param id Identificador único del pedido
     * @return El pedido encontrado o null si no existe
     */
    Pedido obtenerPedidoPorId(Long id);

    /**
     * Marca un pedido como disponible para entrega
     * @param pedido Objeto Pedido a actualizar
     * @return El pedido actualizado con su nuevo estado
     * @throws RuntimeException Si el pedido no existe
     */
    Pedido PedidoDisponible(Pedido pedido);
}