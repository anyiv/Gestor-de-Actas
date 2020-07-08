package com.lab2.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.lab2.backend.repository.ActaRepository;
import com.lab2.backend.model.Acta;

@Service

@RequiredArgsConstructor
public class ActaService {
    private final ActaRepository actaRepository;

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
}
