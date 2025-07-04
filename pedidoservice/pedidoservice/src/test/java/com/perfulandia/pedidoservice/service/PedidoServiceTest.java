package com.perfulandia.pedidoservice.service;

import com.perfulandia.carritoservice.model.Carrito;
import com.perfulandia.pedidoservice.model.*;
import com.perfulandia.pedidoservice.repository.PedidoRepository;
import com.perfulandia.usuarioservice.model.Usuario;
import com.perfulandia.usuarioservice.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PedidoServiceTest {

    @Mock
    private PedidoRepository repo;

    @Mock
    private RestTemplate rest;

    @InjectMocks
    private PedidoService ser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void crearPedido() {
        Long usuarioId = 1L;
        Long carritoId = 2L;

        Usuario usuario = Usuario.builder()
                .id(usuarioId)
                .direccion("Calle Egaña 123")
                .build();
        com.perfulandia.carritoservice.model.Producto prod = com.perfulandia.carritoservice.model.Producto.builder()
                .productoId(100L)
                .nombre("Jabón")
                .precio(550.0)
                .cantidad(2)
                .build();
        Carrito carrito = Carrito.builder()
                .id(carritoId)
                .items(List.of(prod))
                .build();

        when(rest.getForObject("http://localhost:8081/api/usuarios/" + usuarioId, Usuario.class))
                .thenReturn(usuario);

        when(rest.getForObject("http://localhost:8083/api/v1/carrito/" + carritoId, Carrito.class))
                .thenReturn(carrito);

        when(repo.save(any(Pedido.class))).thenAnswer(i -> i.getArgument(0));

        Pedido nuevoPedido = ser.crearPedido(usuarioId, carritoId);

        assertNotNull(nuevoPedido);
        assertEquals(usuarioId, nuevoPedido.getUsuarioId());
        assertEquals(carritoId, nuevoPedido.getCarritoId());
        assertEquals(EstadoPedido.PENDIENTE, nuevoPedido.getEstado());
        assertEquals("Calle Egaña 123", nuevoPedido.getDireccionEnvio());
        assertEquals(1, nuevoPedido.getItems().size());
        assertEquals(100L, nuevoPedido.getItems().get(0).getProductoId());

        verify(rest).getForObject("http://localhost:8081/api/usuarios/" + usuarioId, Usuario.class);
        verify(rest).getForObject("http://localhost:8083/api/v1/carrito/" + carritoId, Carrito.class);
        verify(repo).save(any(Pedido.class));

    }
    
    @Test
    void actualizarPedido() {
        Long pedidoId = 10L;
        Pedido pedido = Pedido.builder()
                .id(pedidoId)
                .estado(EstadoPedido.PENDIENTE)
                .build();

        when(repo.findById(pedidoId)).thenReturn(Optional.of(pedido));
        when(repo.save(any(Pedido.class))).thenAnswer(i -> i.getArgument(0));

        Pedido act = ser.actualizarEstado(pedidoId, EstadoPedido.EN_REPARTO);

        assertEquals(EstadoPedido.EN_REPARTO, act.getEstado());
        assertNotNull(act.getFechaActualizacion());

        verify(repo).findById(pedidoId);
        verify(repo).save(pedido);
    }

    @Test
    void obtenerPedido() {
        Long usuarioId = 5L;
        Pedido p1 = new Pedido();
        Pedido p2 = new Pedido();
        List<Pedido> pedidosMock = List.of(p1, p2);

        when(repo.findByUsuarioId(usuarioId)).thenReturn(pedidosMock);

        List<Pedido> pedidos = ser.obtenerPedidosPorUsuario(usuarioId);

        assertEquals(2, pedidos.size());
        verify(repo).findByUsuarioId(usuarioId);
    }
    
}
