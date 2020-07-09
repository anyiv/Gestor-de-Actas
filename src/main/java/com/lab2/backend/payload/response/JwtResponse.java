package com.lab2.backend.payload.response;

import com.lab2.backend.model.Decanato;

import java.util.List;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	//private Long id;
	private String username;
	private String cedula;

	private String email;

	private String nombre;

	private String apellido;

	private String telefono;
	private Character estatus;

	private Decanato decanato;
	private List<String> roles;

	public JwtResponse(String accessToken, String cedula, String username, String email, String nombre, String apellido, String telefono, Character estatus,Decanato decanato, List<String> roles) {
		this.token = accessToken;
		//this.id = id;
		this.cedula = cedula;
		this.username = username;
		//this.roles = roles;
		this.email = email;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.estatus = estatus;
		this.decanato = decanato;
		this.roles = roles;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	/*public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
*/


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Character getEstatus() {
		return estatus;
	}

	public void setEstatus(Character estatus) {
		this.estatus = estatus;
	}

	public Decanato getDecanato() {
		return decanato;
	}

	public void setDecanato(Decanato decanato) {
		this.decanato = decanato;
	}

	public List<String> getRoles() {
		return roles;
	}
}
