package com.perfulandia.usuarioservice.service;
//importar
import com.perfulandia.usuarioservice.model.Usuario;
import com.perfulandia.usuarioservice.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import  java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repo;
    //constructor para inyectar el servicio
    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    // metodos del CRUD
    public Usuario guardar(Usuario usuario) {
        return repo.save(usuario);
    }

    public List<Usuario> listar(){
        return repo.findAll();
    }

    public Usuario buscar(long id){
        return repo.findById(id).orElse(null);
    }

    public void eiminar(long id){
        repo.deleteById(id);
    }
}
