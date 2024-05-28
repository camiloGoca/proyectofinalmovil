package com.example.ProyectoDemo.IRepository;

import com.example.ProyectoDemo.Entidad.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIngredienteRepository extends JpaRepository<Ingrediente, Long> {
}
