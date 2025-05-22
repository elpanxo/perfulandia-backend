package com.perfulandia.usuarioservice.service;

import com.perfulandia.usuarioservice.model.Usuario;
import com.perfulandia.usuarioservice.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public class UsuarioService {

    private final UsuarioRepository repo;
    public UsuarioService(UsuarioRepository repo){
        this.repo = repo;
    }
    public List<Usuario> listar(){
        return repo.findAll();
    }

    public Usuario guardar(Usuario usuario){
        return repo.save(usuario);
    }

    public Usuario buscar(Long id){
        return repo.findById(id).orElse(null);
    }

    public void eliminar(Long id){
        repo.deleteById(id);
    }

}
