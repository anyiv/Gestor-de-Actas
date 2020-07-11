package com.lab2.backend.repository;
import com.lab2.backend.model.Estado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface  EstadoRepository extends JpaRepository<Estado, Integer>{
    List<Estado> findByEstatus(Character estatus);


}