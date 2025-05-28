package com.perfulandia.pedidos_service.service;
import com.perfulandia.pedidos_service.model.Pedido;
import com.perfulandia.pedidos_service.repository.PedidoRepository;
import  org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceimpl implements PedidosService {
    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoServiceimpl(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public Pedido crearPedido(Pedido pedido){
        return pedidoRepository.save(pedido);
    }

    @Override
    public List<Pedido> listarPedidos(){
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido obtenerPedidoPorId(Long id){
        return pedidoRepository.findById(id).orElse(null);
    }

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
