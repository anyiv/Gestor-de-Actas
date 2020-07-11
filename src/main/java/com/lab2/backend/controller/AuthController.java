package com.lab2.backend.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.lab2.backend.model.*;
import com.lab2.backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.lab2.backend.payload.request.LoginRequest;
import com.lab2.backend.payload.request.SignupRequest;
import com.lab2.backend.payload.response.JwtResponse;
import com.lab2.backend.payload.response.MessageResponse;
import com.lab2.backend.repository.RolRepository;
import com.lab2.backend.repository.UserRepository;
import com.lab2.backend.repository.UsuarioRepository;
import com.lab2.backend.security.jwt.JwtUtils;
import com.lab2.backend.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600, allowedHeaders = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RolRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@Autowired
	private  UsuarioService usuarioService;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getCedula(),
				userDetails.getUsername(),
				userDetails.getEmail(),
												 userDetails.getNombre(),
													userDetails.getApellido(),

				userDetails.getTelefono(),
				userDetails.getEstatus(),
				userDetails.getDecanato(),
				roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getCedula(),signUpRequest.getUsername(),signUpRequest.getEmail(),signUpRequest.getNombre(),signUpRequest.getApellido(),signUpRequest.getTelefono(), encoder.encode(signUpRequest.getPassword()),signUpRequest.getEstatus(),signUpRequest.getDecanato());


		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "mod":
					Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);

					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		return ResponseEntity.ok(usuarioService.UsuriosActivos());
	}
	@PutMapping("/{id}")
	public ResponseEntity<User> update(@PathVariable String id, @Valid @RequestBody User user) {
		if (!usuarioService.findById(id).isPresent()) {
			ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(usuarioService.save(user));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable String id) {
		if (!usuarioService.findById(id).isPresent()) {
			ResponseEntity.badRequest().build();
		}
		User user = new User();
		user = usuarioService.findById(id).get();
		user.setEstatus('I');
		usuarioService.save(user);
		return ResponseEntity.ok().build();
	}
}
