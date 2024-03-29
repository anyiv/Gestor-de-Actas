package com.lab2.backend.repository;
import com.lab2.backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    List<Usuario> findByEstatus(Character estatus);

    Long countByEstatus (Character estatus);
}