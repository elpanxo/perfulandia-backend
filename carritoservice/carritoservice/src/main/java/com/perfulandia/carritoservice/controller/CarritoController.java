package com.perfulandia.carritoservice.controller;
import com.perfulandia.carritoservice.model.Carrito;
import com.perfulandia.carritoservice.service.CarritoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/carrito")

public class CarritoController {

    private final CarritoService carritoService;

    public CarritoController(CarritoService carritoService) {
        this.carritoService = carritoService;
    }

    @PostMapping("/{carritoId}/agregar/{productoId}")
    public Carrito agregarProducto(@PathVariable Long carritoId, @PathVariable Long productoId) {
        return carritoService.agregarProducto(carritoId, productoId);
    }

    @DeleteMapping("/{carritoId}/eliminar/{productoId}")
    public Carrito eliminarProducto(@PathVariable Long carritoId, @PathVariable Long productoId) {
        return carritoService.eliminarProducto(carritoId, productoId);
    }

    @GetMapping("/{carritoId}")
    public Carrito obtenerCarrito(@PathVariable Long carritoId) {
        return carritoService.obtenerCarrito(carritoId);
    }

    @DeleteMapping("/{carritoId}")
    public void eliminarCarrito(@PathVariable Long carritoId) {
        carritoService.eliminarCarrito(carritoId);
    }
}
