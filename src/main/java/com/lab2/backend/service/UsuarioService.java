package com.lab2.backend.service;
import com.lab2.backend.model.Acta;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.lab2.backend.repository.UsuarioRepository;
import com.lab2.backend.model.User;
import org.springframework.transaction.annotation.Transactional;

@Service

@RequiredArgsConstructor
public class UsuarioService {
    @Autowired
    private UsuarioRepository userRepository;
    
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    public List<User> UsuriosActivos(){
        return userRepository.findByEstatus('A');
    }    

    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    public Long countUser(Character estatus){
        return userRepository.countByEstatus(estatus);
    }

}


