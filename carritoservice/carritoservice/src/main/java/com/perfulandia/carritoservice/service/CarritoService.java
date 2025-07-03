package com.perfulandia.carritoservice.service;
import  com.perfulandia.carritoservice.model.Carrito;
import  com.perfulandia.carritoservice.model.Producto;
import  com.perfulandia.carritoservice.repository.CarritoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CarritoService{

    private final CarritoRepository carritoRepository;
    private final RestTemplate restTemplate;

    public CarritoService(CarritoRepository carritoRepository, RestTemplate restTemplate) {
        this.carritoRepository = carritoRepository;
        this.restTemplate = restTemplate;
    }

    public Carrito obtenerCarrito(Long id) {
        return carritoRepository.findById(id).orElseGet(() -> {
            Carrito nuevo = new Carrito(null, new ArrayList<>());
            return carritoRepository.save(nuevo);
        });
    }

    public Carrito agregarProducto(Long carritoId, Long productoId) {
        Carrito carrito = obtenerCarrito(carritoId);

        // Obtener info del producto desde otro microservicio
        Producto producto = restTemplate.getForObject("http://localhost:8082/api/productos/" + productoId, Producto.class);

        if (producto == null) throw new RuntimeException("Producto no encontrado");

        Optional<Producto> itemExistente = carrito.getItems().stream()
                .filter(i -> i.getProductoId().equals(productoId))
                .findFirst();

        if (itemExistente.isPresent()) {
            itemExistente.get().setCantidad(itemExistente.get().getCantidad() + 1);
        } else {
            Producto item = Producto.builder()
                    .productoId(producto.getId())
                    .nombre(producto.getNombre())
                    .precio(producto.getPrecio())
                    .cantidad(1)
                    .build();
            carrito.getItems().add(item);
        }

        return carritoRepository.save(carrito);
    }

    public Carrito eliminarProducto(Long carritoId, Long productoId) {
        Carrito carrito = obtenerCarrito(carritoId);
        carrito.getItems().removeIf(item -> item.getProductoId().equals(productoId));
        return carritoRepository.save(carrito);
    }

    public void eliminarCarrito(Long carritoId) {
        carritoRepository.deleteById(carritoId);
    }

}
