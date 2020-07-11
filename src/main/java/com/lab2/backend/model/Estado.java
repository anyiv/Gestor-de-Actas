package com.lab2.backend.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.math.BigDecimal;
import java.util.List;
import java.util.Date;
import java.util.Objects;
import com.lab2.backend.model.Acta;
@Entity

@Data
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    private String nombre;

    private Character estatus; 
    
    @JsonIgnore
    @OneToMany(mappedBy="estado")
    private List<Acta> actas;


    public Estado() {
    }

    public Estado(Integer codigo, String nombre, Character estatus, List<Acta> actas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.estatus = estatus;
        this.actas = actas;
    }

    public Integer getCodigo() {
        return this.codigo;
    }

    public void setCodigo(Integer codigo) {
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

    public List<Acta> getActas() {
        return this.actas;
    }

    public void setActas(List<Acta> actas) {
        this.actas = actas;
    }

    public Estado codigo(Integer codigo) {
        this.codigo = codigo;
        return this;
    }

    public Estado nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Estado estatus(Character estatus) {
        this.estatus = estatus;
        return this;
    }

    public Estado actas(List<Acta> actas) {
        this.actas = actas;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Estado)) {
            return false;
        }
        Estado estado = (Estado) o;
        return Objects.equals(codigo, estado.codigo) && Objects.equals(nombre, estado.nombre) && Objects.equals(estatus, estado.estatus) && Objects.equals(actas, estado.actas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre, estatus, actas);
    }

    @Override
    public String toString() {
        return "{" +
            " codigo='" + getCodigo() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", estatus='" + getEstatus() + "'" +
            ", actas='" + getActas() + "'" +
            "}";
    }


}