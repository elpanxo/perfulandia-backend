package com.perfulandia.carritoservice.controller;
import com.perfulandia.carritoservice.model.Producto;
import com.perfulandia.carritoservice.service.CarritoSevice;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1/carrito")

public class CarritoController {

    private final CarritoSevice service;
    private final RestTemplate restTemplate;

    public CarritoController(CarritoSevice service, RestTemplate restTemplate) {
        this.service = service;
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public List<Producto> listar(){
        return service.listarProductos();
    }

    @PostMapping("/guardar/{id}")
    public Producto guardar(@PathVariable long id){
        Producto producto = restTemplate.getForObject("http://localhost:8082/api/v1/productos/"+id,Producto.class);
        return service.guardarProducto(producto);
    }


    @DeleteMapping("/quitar/{id}")
    public void eliminar(@PathVariable long id){
        service.eliminarProducto(id);
    }

    //@GetMapping("/productos/{id}")
    //public Producto obtenerProducto(@PathVariable long id){
    //     return restTemplate.getForObject("http://localhost:8082/api/v1/productos/"+id,Producto.class);
    //}
}
