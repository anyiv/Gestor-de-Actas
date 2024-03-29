package com.lab2.backend.service;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.lab2.backend.repository.UsuarioRepository;
import com.lab2.backend.model.Usuario;

@Service

@RequiredArgsConstructor
public class UsuarioService {
    @Autowired
    private UsuarioRepository userRepository;
    
    public List<Usuario> findAll() {
        return userRepository.findAll();
    }

    public List<Usuario> UsuriosActivos(){
        return userRepository.findByEstatus('A');
    }    

    public Optional<Usuario> findById(String id) {
        return userRepository.findById(id);
    }

    public Usuario save(Usuario user) {
        return userRepository.save(user);
    }

    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    public Long countUser(Character estatus){
        return userRepository.countByEstatus(estatus);
    }
}


