package com.perfulandia.pedidoservice.controller;

import com.perfulandia.pedidoservice.model.*;
import com.perfulandia.pedidoservice.service.PedidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping("/usuario/{usuarioId}/carrito/{carritoId}")
    public Pedido crearPedido(
            @PathVariable Long usuarioId,
            @PathVariable Long carritoId) {
        return pedidoService.crearPedido(usuarioId, carritoId);
    }

    @PutMapping("/{pedidoId}/estado")
    public Pedido actualizarEstado(
            @PathVariable Long pedidoId,
            @RequestBody EstadoPedido nuevoEstado) {
        return pedidoService.actualizarEstado(pedidoId, nuevoEstado);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Pedido> obtenerPedidosPorUsuario(@PathVariable Long usuarioId) {
        return pedidoService.obtenerPedidosPorUsuario(usuarioId);
    }

    @GetMapping("/{pedidoId}")
    public Pedido obtenerPedido(@PathVariable Long pedidoId) {
        return pedidoService.obtenerPedido(pedidoId);
    }
}
