package com.lab2.backend.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.Entity;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.GeneratedValue;
import com.lab2.backend.model.Usuario;
import com.lab2.backend.model.Acta;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

@Entity

@Data
public class Decanato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String nombre;

    private String direccion;

    private String telefono;

    private Character estatus;

    @JsonIgnore
    @OneToMany(mappedBy="decanato")
    private List<Usuario> usuarios;

    @JsonIgnore
    @OneToMany(mappedBy="decanato")
    private List<Acta> actas;


    public Decanato() {
    }

    public Decanato(Long codigo, String nombre, String direccion, String telefono, Character estatus, List<Usuario> usuarios, List<Acta> actas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estatus = estatus;
        this.usuarios = usuarios;
        this.actas = actas;
    }

    public Long getCodigo() {
        return this.codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public List<Acta> getActas() {
        return this.actas;
    }

    public void setActas(List<Acta> actas) {
        this.actas = actas;
    }

    public Decanato codigo(Long codigo) {
        this.codigo = codigo;
        return this;
    }

    public Decanato nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Decanato direccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public Decanato telefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public Decanato estatus(Character estatus) {
        this.estatus = estatus;
        return this;
    }

    public Decanato usuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
        return this;
    }

    public Decanato actas(List<Acta> actas) {
        this.actas = actas;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Decanato)) {
            return false;
        }
        Decanato decanato = (Decanato) o;
        return Objects.equals(codigo, decanato.codigo) && Objects.equals(nombre, decanato.nombre) && Objects.equals(direccion, decanato.direccion) && Objects.equals(telefono, decanato.telefono) && Objects.equals(estatus, decanato.estatus) && Objects.equals(usuarios, decanato.usuarios) && Objects.equals(actas, decanato.actas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre, direccion, telefono, estatus, usuarios, actas);
    }

    @Override
    public String toString() {
        return "{" +
            " codigo='" + getCodigo() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", direccion='" + getDireccion() + "'" +
            ", telefono='" + getTelefono() + "'" +
            ", estatus='" + getEstatus() + "'" +
            ", usuarios='" + getUsuarios() + "'" +
            ", actas='" + getActas() + "'" +
            "}";
    }


}