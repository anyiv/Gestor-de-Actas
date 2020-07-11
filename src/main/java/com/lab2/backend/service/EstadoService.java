package com.lab2.backend.service;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.lab2.backend.repository.EstadoRepository;
import com.lab2.backend.model.Estado;
import org.springframework.transaction.annotation.Transactional;

@Service

@RequiredArgsConstructor
public class EstadoService {
    @Autowired
    private EstadoRepository estRepository;

    public List<Estado> findAll() {
        return estRepository.findAll();
    }
    
    public List<Estado> estadosActivos(){
        return estRepository.findByEstatus('A');
    }

    public Optional<Estado> findById(Integer id) {
        return estRepository.findById(id);
    }

    public Estado save(Estado est) {
        return estRepository.save(est);
    }

    public void deleteById(Integer id) {
        estRepository.deleteById(id);
    }

}
