package com.perfulandia.pedidos_service.service.impl;

import com.perfulandia.pedidos_service.model.dto.PedidoRequest;
import com.perfulandia.pedidos_service.model.dto.EstadoPedidoRequest;
import com.perfulandia.pedidos_service.model.entity.Pedido;
import com.perfulandia.pedidos_service.repository.PedidoRepository;
import com.perfulandia.pedidos_service.service.PedidoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository repository;

    public PedidoServiceImpl(PedidoRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Pedido crearPedido(PedidoRequest request) {
        Pedido pedido = new Pedido();
        pedido.setUsuarioId(request.getUsuarioId());
        pedido.setEstado("GENERADO");
        return repository.save(pedido);
    }

    @Override
    @Transactional
    public Pedido actualizarEstado(Long id, EstadoPedidoRequest request) {
        Pedido pedido = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
        pedido.setEstado(request.getNuevoEstado());
        return repository.save(pedido);
    }

    @Override
    public List<Pedido> obtenerPedidosPorUsuario(Long usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }
}