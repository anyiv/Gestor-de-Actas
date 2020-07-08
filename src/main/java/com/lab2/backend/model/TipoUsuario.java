package com.lab2.backend.model;

import lombok.Data;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import com.lab2.backend.model.Usuario;

@Entity
@Data
public class TipoUsuario {
    @Id
    @GeneratedValue
    private String codigo;

    private String nombre;
    
    private Character estatus;

    @JsonIgnore
    @OneToMany(mappedBy="tipouser", cascade = CascadeType.ALL)
    private List<Usuario> usuarios;


    public TipoUsuario() {
    }

    public TipoUsuario(String codigo, String nombre, Character estatus, List<Usuario> usuarios) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.estatus = estatus;
        this.usuarios = usuarios;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Character getEstatus() {
        return this.estatus;
    }

    public void setEstatus(Character estatus) {
        this.estatus = estatus;
    }

    public List<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public TipoUsuario codigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public TipoUsuario nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public TipoUsuario estatus(Character estatus) {
        this.estatus = estatus;
        return this;
    }

    public TipoUsuario usuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TipoUsuario)) {
            return false;
        }
        TipoUsuario tipoUsuario = (TipoUsuario) o;
        return Objects.equals(codigo, tipoUsuario.codigo) && Objects.equals(nombre, tipoUsuario.nombre) && Objects.equals(estatus, tipoUsuario.estatus) && Objects.equals(usuarios, tipoUsuario.usuarios);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre, estatus, usuarios);
    }

    @Override
    public String toString() {
        return "{" +
            " codigo='" + getCodigo() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", estatus='" + getEstatus() + "'" +
            ", usuarios='" + getUsuarios() + "'" +
            "}";
    }


}