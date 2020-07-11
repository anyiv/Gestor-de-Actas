package com.lab2.backend.service;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.lab2.backend.repository.ActaRepository;
import com.lab2.backend.repository.DecanatoRepository;
import com.lab2.backend.model.Acta;
import com.lab2.backend.model.Decanato;
import org.springframework.transaction.annotation.Transactional;

@Service

@RequiredArgsConstructor
public class ActaService {
    @Autowired
    private ActaRepository actaRepository;

    @Autowired
    private DecanatoRepository decanatoRepository;

    public List<Acta> findAll() {
        return actaRepository.findAll();
    }
    @Transactional
    public List<Acta> actasActivas(){
        return actaRepository.findByEstatus('A');
    }

    public Optional<Acta> findById(Integer id) {
        return actaRepository.findById(id);
    }

    public Acta save(Acta acta) {
        return actaRepository.save(acta);
    }

    public void deleteById(Integer id) {
        actaRepository.deleteById(id);
    }
    @Transactional
    public List<Acta> findByDecanato(Long id){
        Decanato decanato = new Decanato();
        decanato = decanatoRepository.findById(id).get();
        return actaRepository.findByDecanato(decanato);
    }
    public Acta findTopByOrderByCodigoDesc(){
        return  actaRepository.findTopByOrderByCodigoDesc();
    }

    public Long countActas(Character estatus){
        return actaRepository.countByEstatus(estatus);
    }

    public Integer contarActasPorDecanato(Long cod, Integer mes){
        return actaRepository.findByActasYDecanato(cod, mes);
    }

    public List<Acta> findByMesYDecanato(Long cod, Integer mes){
        return actaRepository.findByMesYDecanato(cod, mes);
    }
}
