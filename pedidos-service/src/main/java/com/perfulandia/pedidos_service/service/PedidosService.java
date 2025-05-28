package com.perfulandia.pedidos_service.service;

import com.perfulandia.pedidos_service.model.Pedido;
import java.util.List;

public interface PedidosService {
    Pedido crearPedido(Pedido pedido);
    List<Pedido> listarPedidos();
    Pedido obtenerPedidoPorId(Long id);
    Pedido PedidoDisponible(Pedido pedido);
}
