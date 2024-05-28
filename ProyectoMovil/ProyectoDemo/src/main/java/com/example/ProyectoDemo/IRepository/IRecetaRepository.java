package com.example.ProyectoDemo.IRepository;

import com.example.ProyectoDemo.Entidad.Receta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRecetaRepository extends JpaRepository<Receta, Long> {
}
