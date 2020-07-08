package com.lab2.backend.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import com.lab2.backend.model.Decanato;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import com.lab2.backend.model.TipoUsuario;

@Entity

@Data
public class Usuario {
    @Id
    private String cedula;

    private String nombre;

    private String apellido;

    private String email;

    private String telefono;

    private String contaseña;

    private Character estatus;

    @ManyToOne
    private Decanato decanato;

    @ManyToOne
    private TipoUsuario tipouser;


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

}
