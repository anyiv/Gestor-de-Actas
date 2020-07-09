package com.lab2.backend.model;

import lombok.Data;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;
    
    private Character estatus;

    /*@JsonIgnore
    @OneToMany(mappedBy="role", cascade = CascadeType.ALL)
    private List<User> users;*/

    public Role() {
    }

    public Role(Integer id, Character estatus, ERole name) {
        this.id = id;
        this.estatus = estatus;
        this.name = name;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Character getEstatus() {
        return this.estatus;
    }

    public void setEstatus(Character estatus) {
        this.estatus = estatus;
    }

   /* public List<User> getUsers() {
        return this.users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }*/

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }

    public Role id(Integer id) {
        this.id = id;
        return this;
    }

    public Role estatus(Character estatus) {
        this.estatus = estatus;
        return this;
    }

   /* public Role usuarios(List<User> users) {
        this.users = users;
        return this;
    }*/

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Role)) {
            return false;
        }
        Role role = (Role) o;
        return Objects.equals(id, role.id) && Objects.equals(estatus, role.estatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, estatus);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", estatus='" + getEstatus() + "'" +
            "}";
    }


}