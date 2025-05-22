package com.perfulandia.usuarioservice.repository;


import com.perfulandia.usuarioservice.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
}
