package com.perfulandia.pedidos_service.controller;

import com.perfulandia.pedidos_service.model.Pedido;
import com.perfulandia.pedidos_service.service.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador que maneja todas las operaciones de pedidos:
 * - Crear nuevos pedidos
 * - Listar pedidos existentes
 * - Buscar pedidos por ID
 * - Actualizar estado de pedidos
 */
@RestController
@RequestMapping("/api/pedidos") // Todas las URLs empiezan con /api/pedidos
public class PedidoService {

    // Servicio que contiene la lógica real de manejo de pedidos
    private PedidosService pedidosService;

    // Inyectamos el servicio automáticamente (Spring se encarga de pasarlo)
    @Autowired
    public void PedidoController(PedidosService pedidosService) {
        this.pedidosService = pedidosService;
    }

    // Constructor alternativo (usado si no funciona la inyección con @Autowired)
    public PedidoService(PedidosService pedidosService) {
        this.pedidosService = pedidosService;
    }

    /**
     * Crea un nuevo pedido con los datos recibidos
     * Ejemplo de uso: POST /api/pedidos { "producto": "Camiseta", "cantidad": 2 }
     */
    @PostMapping
    public Pedido crearPedido(@RequestBody Pedido pedido) {
        return pedidosService.crearPedido(pedido);
    }

    /**
     * Devuelve la lista completa de todos los pedidos
     * Ejemplo de uso: GET /api/pedidos
     */
    @GetMapping
    public List<Pedido> listarPedidos() {
        return pedidosService.listarPedidos();
    }

    /**
     * Busca un pedido específico usando su ID
     * Ejemplo de uso: GET /api/pedidos/5
     */
    @GetMapping("/{id}")
    public Pedido obtenerPedidoPorId(@PathVariable Long id) {
        return pedidosService.obtenerPedidoPorId(id);
    }

    /**
     * Marca un pedido como disponible para entrega
     * Ejemplo de uso: PUT /api/pedidos/disponible { "id": 5, "estado": "DISPONIBLE" }
     */
    @PutMapping("/disponible")
    public Pedido marcarComoDisponible(@RequestBody Pedido pedido) {
        return pedidosService.PedidoDisponible(pedido);
    }
}