package com.lab2.backend.repository;
import com.lab2.backend.model.Acta;
import com.lab2.backend.model.Decanato;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ActaRepository extends JpaRepository<Acta, Integer> {
    List<Acta> findByEstatus(Character estatus);

    List<Acta> findByDecanato(Decanato decanato);

    Long countByEstatus (Character estatus);
}