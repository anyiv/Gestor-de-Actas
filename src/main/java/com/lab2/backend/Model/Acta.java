package com.lab2.backend.Model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity

@Data
public class Acta {
    @Id
    @GeneratedValue
    private Integer codigo;

    private Integer tipo;

    private String descripcion;

    private Character estatus;

    @CreationTimestamp
    private Date fecha;

    @UpdateTimestamp
    private Date ult_actualizacion;
}
