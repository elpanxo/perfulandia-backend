package com.perfulandia.pedidos_service.controller;

import com.perfulandia.pedidos_service.model.dto.PedidoRequest;
import com.perfulandia.pedidos_service.model.dto.EstadoPedidoRequest;
import com.perfulandia.pedidos_service.model.entity.Pedido;
import com.perfulandia.pedidos_service.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Pedido> crearPedido(@RequestBody PedidoRequest request) {
        return ResponseEntity.ok(service.crearPedido(request));
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<Pedido> actualizarEstado(
            @PathVariable Long id,
            @RequestBody EstadoPedidoRequest request
    ) {
        return ResponseEntity.ok(service.actualizarEstado(id, request));
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Pedido>> listarPorUsuario(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(service.obtenerPedidosPorUsuario(usuarioId));
    }
}