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
    
    private char estatus;

    @JsonIgnore
    @OneToMany(mappedBy="tipouser", cascade = CascadeType.ALL)
    private List<Usuario> usuarios;


}