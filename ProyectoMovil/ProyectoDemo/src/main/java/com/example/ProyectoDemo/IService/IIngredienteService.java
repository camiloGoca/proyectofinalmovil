package com.example.ProyectoDemo.IService;

import com.example.ProyectoDemo.Entidad.Ingrediente;

import java.util.List;
import java.util.Optional;

public interface IIngredienteService {

    List<Ingrediente> findAll();

    Optional<Ingrediente> findById(Long id);

    Ingrediente save(Ingrediente ingrediente);

    void update(Ingrediente ingrediente, Long id);

    void delete(Long id);
}
