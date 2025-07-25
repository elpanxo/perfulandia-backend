package com.perfulandia.productservice.service;
import com.perfulandia.productservice.model.Producto;
import com.perfulandia.productservice.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository repo;
    public ProductoService(ProductoRepository repo) {
        this.repo = repo;
    }

    public List<Producto> listar() {
        return repo.findAll();
    }

    public Producto guardar(Producto producto) {
        return repo.save(producto);
    }

    public Producto buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void eliminar(long id) {
        repo.deleteById(id);
    }
}
