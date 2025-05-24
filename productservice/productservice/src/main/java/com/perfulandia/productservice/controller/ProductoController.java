package com.perfulandia.productservice.controller;
import com.perfulandia.productservice.model.Producto;
import com.perfulandia.productservice.service.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {
    private final ProductoService service;
    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Producto> listar() {
        return service.listar();
    }

    @PostMapping
    public Producto guardar(@RequestBody Producto producto) {
        return service.guardar(producto);
    }

    @GetMapping("/buscar/{id}")
    public Producto buscar(@PathVariable long id) {
        return service.buscarPorId(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable long id) {
        service.eliminar(id);
    }
}
