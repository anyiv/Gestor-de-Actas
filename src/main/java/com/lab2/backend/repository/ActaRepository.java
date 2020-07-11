package com.lab2.backend.repository;
import com.lab2.backend.model.Acta;
import com.lab2.backend.model.Decanato;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActaRepository extends JpaRepository<Acta, Integer> {
    List<Acta> findByEstatus(Character estatus);

    List<Acta> findByDecanato(Decanato decanato);

    Long countByEstatus (Character estatus);
    @Query("Select count(*) from Acta a where a.decanato.codigo=?1 and a.estatus='A' and extract(month from a.fecha)=?2 ")
    Integer findByActasYDecanato(Long cod, Integer mes);
    Acta findTopByOrderByCodigoDesc();

    @Query("Select a from Acta a where a.decanato.codigo=?1 and a.estatus='A' and extract(month from a.fecha)=?2 ")
    List<Acta> findByMesYDecanato(Long cod, Integer mes);
}