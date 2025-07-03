package com.perfulandia.carritoservice.controller;

import com.perfulandia.carritoservice.model.Carrito;
import com.perfulandia.carritoservice.service.CarritoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CarritoControllerTest {

    @Mock
    private CarritoService ser;

    @InjectMocks
    private CarritoController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testObtenerCarrito() {
        Carrito c = new Carrito(1L, new ArrayList<>());
        when(ser.obtenerCarrito(1L)).thenReturn(c);

        Carrito result = controller.obtenerCarrito(1L);

        assertEquals(1L, result.getId());
        verify(ser).obtenerCarrito(1L);
    }

    @Test
    void testAgregarProducto() {
        Carrito c = new Carrito(1L, new ArrayList<>());
        when(ser.agregarProducto(1L, 99L)).thenReturn(c);

        Carrito result = controller.agregarProducto(1L, 99L);

        assertNotNull(result);
        verify(ser).agregarProducto(1L, 99L);
    }

    @Test
    void testEliminarProducto() {
        Carrito c = new Carrito(1L, new ArrayList<>());
        when(ser.eliminarProducto(1L, 99L)).thenReturn(c);

        Carrito result = controller.eliminarProducto(1L, 99L);

        assertNotNull(result);
        verify(ser).eliminarProducto(1L, 99L);
    }
}
