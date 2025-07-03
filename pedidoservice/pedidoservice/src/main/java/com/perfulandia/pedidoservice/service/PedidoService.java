package com.perfulandia.pedidoservice.service;

import com.perfulandia.carritoservice.model.Carrito;
import com.perfulandia.pedidoservice.model.*;
import com.perfulandia.pedidoservice.repository.PedidoRepository;
import com.perfulandia.usuarioservice.model.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final RestTemplate restTemplate;

    public PedidoService(PedidoRepository pedidoRepository, RestTemplate restTemplate) {
        this.pedidoRepository = pedidoRepository;
        this.restTemplate = restTemplate;
    }

    public Pedido crearPedido(Long usuarioId, Long carritoId) {
        // Obtener info del usuario
        Usuario usuario = restTemplate.getForObject(
                "http://localhost:8081/api/usuarios/" + usuarioId,
                Usuario.class);

        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado");
        }

        // Obtener carrito
        Carrito carrito = restTemplate.getForObject(
                "http://localhost:8083/api/v1/carrito/" + carritoId,
                Carrito.class);

        if (carrito == null || carrito.getItems().isEmpty()) {
            throw new RuntimeException("Carrito no encontrado o vacío");
        }

        // Convertir items del carrito a items de pedido
        List<ItemPedido> itemsPedido = carrito.getItems().stream()
                .map(item -> ItemPedido.builder()
                        .productoId(item.getProductoId())
                        .nombre(item.getNombre())
                        .precio(item.getPrecio())
                        .cantidad(item.getCantidad())
                        .build())
                .collect(Collectors.toList());

        // Calcular total
        double total = itemsPedido.stream()
                .mapToDouble(item -> item.getPrecio() * item.getCantidad())
                .sum();

        // Crear pedido
        Pedido pedido = Pedido.builder()
                .usuarioId(usuarioId)
                .carritoId(carritoId)
                .estado(EstadoPedido.PENDIENTE)
                .fechaCreacion(new Date())
                .fechaActualizacion(new Date())
                .items(itemsPedido)
                .total(total)
                .direccionEnvio(usuario.getDireccion())
                .build();

        return pedidoRepository.save(pedido);
    }

    public Pedido actualizarEstado(Long pedidoId, EstadoPedido nuevoEstado) {
        Pedido pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));

        pedido.setEstado(nuevoEstado);
        pedido.setFechaActualizacion(new Date());

        return pedidoRepository.save(pedido);
    }

    public List<Pedido> obtenerPedidosPorUsuario(Long usuarioId) {
        return pedidoRepository.findByUsuarioId(usuarioId);
    }

    public Pedido obtenerPedido(Long pedidoId) {
        return pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
    }
}
