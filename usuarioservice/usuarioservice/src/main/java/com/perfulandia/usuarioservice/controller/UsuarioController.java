package com.perfulandia.usuarioservice.controller;
import com.perfulandia.usuarioservice.model.Usuario;
import com.perfulandia.usuarioservice.service.UsuarioService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController// comando para que se comporte como  controlador
@RequestMapping("/api/usuarios")

public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    //listar
    @GetMapping
    public List<Usuario> listar(){
        return service.listar();
    }

    // guardar
    @PostMapping
    public Usuario guardar(@RequestBody Usuario usuario) {
        return service.guardar(usuario);
    }

    @PostMapping("/buscar/")
    public Usuario buscar(@PathVariable long id){
        return service.buscar(id);
    }

    @DeleteMapping("/eliminar/")
    public void eliminar(@PathVariable long id) {
        service.eiminar(id);
    }
}
