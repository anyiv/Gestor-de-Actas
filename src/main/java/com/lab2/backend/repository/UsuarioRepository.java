package com.lab2.backend.repository;
import com.lab2.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface UsuarioRepository extends JpaRepository<User, String> {
    List<User> findByEstatus(Character estatus);

    Long countByEstatus (Character estatus);

}