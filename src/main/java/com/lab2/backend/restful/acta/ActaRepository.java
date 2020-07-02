package com.lab2.backend.restful.acta;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ActaRepository extends JpaRepository<Acta, Integer> {
    List<Acta> findByEstatus(Character estatus);
}