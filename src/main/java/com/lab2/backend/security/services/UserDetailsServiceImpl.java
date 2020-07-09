package com.lab2.backend.security.services;

import com.lab2.backend.model.User;
import com.lab2.backend.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lab2.backend.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service

@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		return UserDetailsImpl.build(user);
	}

	public List<User> findAll() {
		return usuarioRepository.findAll();
	}

	public List<User> UsuariosActivos(){
		return usuarioRepository.findByEstatus('A');
	}

	public Optional<User> findById(String id) {
		return usuarioRepository.findById(id);
	}

	public User save(User user) {
		return usuarioRepository.save(user);
	}

	public void deleteById(String id) {
		usuarioRepository.deleteById(id);
	}

}
