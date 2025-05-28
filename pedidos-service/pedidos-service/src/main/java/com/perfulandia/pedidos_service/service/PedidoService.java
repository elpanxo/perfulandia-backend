package com.perfulandia.pedidos_service.service;

import com.perfulandia.pedidos_service.model.dto.PedidoRequest;
import com.perfulandia.pedidos_service.model.dto.EstadoPedidoRequest;
import com.perfulandia.pedidos_service.model.entity.Pedido;
import java.util.List;

public interface PedidoService {
    Pedido crearPedido(PedidoRequest request);
    Pedido actualizarEstado(Long id, EstadoPedidoRequest request);
    List<Pedido> obtenerPedidosPorUsuario(Long usuarioId);
}