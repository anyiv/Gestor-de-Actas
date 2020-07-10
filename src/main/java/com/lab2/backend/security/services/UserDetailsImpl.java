package com.lab2.backend.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.lab2.backend.model.Decanato;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.lab2.backend.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	//private Long id;

	private String username;


	private String cedula;
	private String email;
	private String nombre;

	private String apellido;

	private String telefono;
	private Character estatus;


	private Decanato decanato;

	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(String username, String cedula,String email,String nombre, String apellido, String telefono,String password, Character estatus ,
						   Decanato decanato, Collection<? extends GrantedAuthority> authorities) {
		//this.id = id;
		this.username = username;
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.decanato=decanato;
		this.password = password;
		this.estatus = estatus;
		this.authorities = authorities;
	}



	public static UserDetailsImpl build(User user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
				.collect(Collectors.toList());

		return new UserDetailsImpl(
				user.getUsername(),
				user.getCedula(),
				user.getNombre(),
				user.getApellido(),
				user.getEmail(),
				user.getTelefono(),
				user.getPassword(),
				user.getEstatus(),
				user.getDecanato(),
				authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}


	public String getEmail() {
		return email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	public String getCedula() {
		return this.cedula;
	}


	public String getNombre() {
		return this.nombre;
	}


	public String getApellido() {
		return this.apellido;
	}

	public String getTelefono() {
		return this.telefono;
	}


	public Character getEstatus() {
		return estatus;
	}

	public Decanato getDecanato() {
		return decanato;
	}


	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	/*
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}*/
}
