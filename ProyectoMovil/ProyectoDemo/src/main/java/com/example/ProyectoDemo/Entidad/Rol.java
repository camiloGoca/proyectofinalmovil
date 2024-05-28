package com.example.ProyectoDemo.Entidad;

import com.example.ProyectoDemo.Utils.AuthorityNombres;
import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "rol")
public class Rol {

    //Campos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private AuthorityNombres nombre;

    //Constructor
    public Rol(AuthorityNombres authorityNombres) {
        this.nombre = authorityNombres;
    }
    public Rol() {}

    //Getter Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AuthorityNombres getNombre() {
        return nombre;
    }

    public void setNombre(AuthorityNombres nombre) {
        this.nombre = nombre;
    }
}
