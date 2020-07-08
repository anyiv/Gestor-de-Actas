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
import com.lab2.backend.model.Usuario;
import com.lab2.backend.model.Acta;
import javax.persistence.OneToMany;

@Entity

@Data
public class Decanato {
    @Id
    private String codigo;

    private String nombre;

    private String direccion;

    private String telefono;

    private char estatus;

    @JsonIgnore
    @OneToMany(mappedBy="decanato")
    private List<Usuario> usuarios;

    @JsonIgnore
    @OneToMany(mappedBy="decanato")
    private List<Acta> actas;
}