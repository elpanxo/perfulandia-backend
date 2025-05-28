package com.perfulandia.usuarioservice.repository;
import com.perfulandia.usuarioservice.model.Usuario; // importa clase Usuario
// 2 importar JPA Repository para trabajar con CRUD
import org.springframework.data.jpa.repository.JpaRepository;

//la interfaz hereda de JPA y Gestiona la entidad usuario con ID long
//findALL()
//findByID(id)
//save()
//delete()
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
