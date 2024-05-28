// src/main/java/com/example/ProyectoDemo/IService/IRecetaService.java
package com.example.ProyectoDemo.IService;

import com.example.ProyectoDemo.Entidad.Receta;

import java.util.List;
import java.util.Optional;

public interface IRecetaService {

    List<Receta> findAll();

    Optional<Receta> findById(Long id);

    Receta save(Receta receta);

    Receta update(Receta receta, Long id); // Actualización de la firma del método update

    void delete(Long id);
}
