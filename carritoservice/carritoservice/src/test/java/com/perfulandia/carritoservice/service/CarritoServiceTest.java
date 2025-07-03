package com.perfulandia.carritoservice.service;

import com.perfulandia.carritoservice.model.Carrito;
import com.perfulandia.carritoservice.model.Producto;
import com.perfulandia.carritoservice.repository.CarritoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CarritoServiceTest {
    @Mock
    private CarritoRepository repo;

    @Mock
    private RestTemplate rest;

    @InjectMocks
    private CarritoService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void obtenerCarrito() {
        Carrito mockCarrito = new Carrito(1L, new ArrayList<>());
        when(repo.findById(1L)).thenReturn(Optional.of(mockCarrito));

        Carrito result = service.obtenerCarrito(1L);

        assertEquals(1L, result.getId());
        verify(repo).findById(1L);
    }

    @Test
    void agregarProducto() {
        Carrito mockCarrito = new Carrito(1L, new ArrayList<>());
        Producto productoApi = new Producto(99L, 99L, "Producto", 2000.0, 1);

        when(repo.findById(1L)).thenReturn(Optional.of(mockCarrito));
        when(rest.getForObject(anyString(), eq(Producto.class))).thenReturn(productoApi);
        when(repo.save(any())).thenReturn(mockCarrito);

        Carrito result = service.agregarProducto(1L, 99L);

        assertEquals(1, result.getItems().size());
        verify(repo).save(mockCarrito);
    }

    @Test
    void eliminarProducto() {
        Producto p = new Producto(1L, 10L, "Figura", 5000.0, 2);
        ArrayList<Producto> lista = new ArrayList<>();
        lista.add(p);
        Carrito mockCarrito = new Carrito(1L, lista);

        when(repo.findById(1L)).thenReturn(Optional.of(mockCarrito));
        when(repo.save(any())).thenReturn(mockCarrito);

        Carrito result = service.eliminarProducto(1L, 10L);

        assertTrue(result.getItems().isEmpty());
        verify(repo).save(mockCarrito);
    }
}
