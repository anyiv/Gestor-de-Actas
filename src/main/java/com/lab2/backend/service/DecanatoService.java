package com.lab2.backend.service;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.lab2.backend.repository.DecanatoRepository;
import com.lab2.backend.model.Decanato;

@Service

@RequiredArgsConstructor
public class DecanatoService {
    @Autowired
    private DecanatoRepository decanatoRepository;

    public List<Decanato> findAll() {
        return decanatoRepository.findAll();
    }

    public List<Decanato> decActivas(){
        return decanatoRepository.findByEstatus('A');
    }

    public Optional<Decanato> findById(Long id) {
        return decanatoRepository.findById(id);
    }

    public Decanato save(Decanato dec) {
        return decanatoRepository.save(dec);
    }

    public void deleteById(Long id) {
        decanatoRepository.deleteById(id);
    }

    public Long countDec(Character estatus){
        return decanatoRepository.countByEstatus(estatus);
    }
}
