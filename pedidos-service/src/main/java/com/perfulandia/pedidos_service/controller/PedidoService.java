package com.perfulandia.pedidos_service.controller;

import com.perfulandia.pedidos_service.model.Pedido;
import com.perfulandia.pedidos_service.service.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoService {

    private PedidosService pedidosService;

    @Autowired
    public void PedidoController(PedidosService pedidosService) {
        this.pedidosService = pedidosService;
    }

    public PedidoService(PedidosService pedidosService) {
        this.pedidosService = pedidosService;
    }

    @PostMapping
    public Pedido crearPedido(@RequestBody Pedido pedido) {
        return pedidosService.crearPedido(pedido);
    }

    @GetMapping
    public List<Pedido> listarPedidos() {
        return pedidosService.listarPedidos();
    }

    @GetMapping("/{id}")
    public Pedido obtenerPedidoPorId(@PathVariable Long id) {
        return pedidosService.obtenerPedidoPorId(id);
    }

    @PutMapping("/disponible")
    public Pedido marcarComoDisponible(@RequestBody Pedido pedido) {
        return pedidosService.PedidoDisponible(pedido);
    }
}
