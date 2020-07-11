package com.lab2.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import com.lab2.backend.model.Pdf;
import com.lab2.backend.model.Decanato;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.lab2.backend.model.Estado;

@Entity

@Data
public class Acta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    private Integer tipo;

    private String descripcion;

    private Character estatus;

    @CreationTimestamp
    @Column(updatable = false)
    private Date fecha;

    @UpdateTimestamp
    private Date ult_actualizacion;


    @OneToOne
    private Pdf pdf;

    @ManyToOne
    private Decanato decanato;

    @ManyToOne
    private Estado estado;

    public Acta() {
    }

    public Acta(Integer codigo, Integer tipo, String descripcion, Character estatus, Date fecha, Date ult_actualizacion, Estado estado) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.estatus = estatus;
        this.fecha = fecha;
        this.ult_actualizacion = ult_actualizacion;
        this.estado = estado;
    }


    public Acta(Integer codigo, Integer tipo, String descripcion, Character estatus, Date fecha, Date ult_actualizacion, Pdf pdf, Decanato decanato, Estado estado) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.estatus = estatus;
        this.fecha = fecha;
        this.ult_actualizacion = ult_actualizacion;
        this.pdf = pdf;
        this.decanato = decanato;
        this.estado = estado;
    }

    public Integer getCodigo() {
        return this.codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getTipo() {
        return this.tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Character getEstatus() {
        return this.estatus;
    }

    public void setEstatus(Character estatus) {
        this.estatus = estatus;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getUlt_actualizacion() {
        return this.ult_actualizacion;
    }

    public void setUlt_actualizacion(Date ult_actualizacion) {
        this.ult_actualizacion = ult_actualizacion;
    }

    public Pdf getPdf() {
        return this.pdf;
    }

    public void setPdf(Pdf pdf) {
        this.pdf = pdf;
    }

    public Decanato getDecanato() {
        return this.decanato;
    }

    public void setDecanato(Decanato decanato) {
        this.decanato = decanato;
    }

    public Estado getEstado() {
        return this.estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Acta codigo(Integer codigo) {
        this.codigo = codigo;
        return this;
    }

    public Acta tipo(Integer tipo) {
        this.tipo = tipo;
        return this;
    }

    public Acta descripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public Acta estatus(Character estatus) {
        this.estatus = estatus;
        return this;
    }

    public Acta fecha(Date fecha) {
        this.fecha = fecha;
        return this;
    }

    public Acta ult_actualizacion(Date ult_actualizacion) {
        this.ult_actualizacion = ult_actualizacion;
        return this;
    }

    public Acta pdf(Pdf pdf) {
        this.pdf = pdf;
        return this;
    }

    public Acta decanato(Decanato decanato) {
        this.decanato = decanato;
        return this;
    }

    public Acta estado(Estado estado) {
        this.estado = estado;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Acta)) {
            return false;
        }
        Acta acta = (Acta) o;
        return Objects.equals(codigo, acta.codigo) && Objects.equals(tipo, acta.tipo) && Objects.equals(descripcion, acta.descripcion) && Objects.equals(estatus, acta.estatus) && Objects.equals(fecha, acta.fecha) && Objects.equals(ult_actualizacion, acta.ult_actualizacion) && Objects.equals(pdf, acta.pdf) && Objects.equals(decanato, acta.decanato) && Objects.equals(estado, acta.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, tipo, descripcion, estatus, fecha, ult_actualizacion, pdf, decanato, estado);
    }

    @Override
    public String toString() {
        return "{" +
            " codigo='" + getCodigo() + "'" +
            ", tipo='" + getTipo() + "'" +
            ", descripcion='" + getDescripcion() + "'" +
            ", estatus='" + getEstatus() + "'" +
            ", fecha='" + getFecha() + "'" +
            ", ult_actualizacion='" + getUlt_actualizacion() + "'" +
            ", pdf='" + getPdf() + "'" +
            ", decanato='" + getDecanato() + "'" +
            ", estado='" + getEstado() + "'" +
            "}";
    }


}
