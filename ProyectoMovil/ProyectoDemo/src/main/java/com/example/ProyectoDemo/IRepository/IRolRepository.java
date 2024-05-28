package com.example.ProyectoDemo.IRepository;

import com.example.ProyectoDemo.Entidad.Rol;
import com.example.ProyectoDemo.Utils.AuthorityNombres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Long> {

    Optional<Rol> findByNombre(AuthorityNombres nombre);
}
