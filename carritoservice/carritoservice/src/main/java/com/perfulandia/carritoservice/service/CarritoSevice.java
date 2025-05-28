package com.perfulandia.carritoservice.service;
import  com.perfulandia.carritoservice.model.Producto;
import  com.perfulandia.carritoservice.repository.CarritoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoSevice {

    private CarritoRepository repo;

    public CarritoSevice(CarritoRepository repo) {
        this.repo = repo;
    }

    public List<Producto> listarProductos() {
        return repo.findAll();
    }

    public Producto guardarProducto(Producto producto) {
        return repo.save(producto);
    }

    public void eliminarProducto(long id) {
        repo.deleteById(id);
    }


}
