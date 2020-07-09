package com.lab2.backend.repository;
import com.lab2.backend.model.Decanato;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DecanatoRepository extends JpaRepository<Decanato, Long>{
    List<Decanato> findByEstatus(Character estatus);

    Long countByEstatus (Character estatus);
}

