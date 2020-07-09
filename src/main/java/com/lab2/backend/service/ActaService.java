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

    public List<Acta> findByDecanato(Long id){
        Decanato decanato = new Decanato();
        decanato = decanatoRepository.findById(id).get();
        return actaRepository.findByDecanato(decanato);
    }

    public Long countActas(Character estatus){
        return actaRepository.countByEstatus(estatus);
    }
}
