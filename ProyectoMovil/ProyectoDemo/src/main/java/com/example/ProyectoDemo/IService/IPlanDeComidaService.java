package com.example.ProyectoDemo.IService;

import com.example.ProyectoDemo.Entidad.PlanDeComida;

import java.util.List;
import java.util.Optional;

public interface IPlanDeComidaService {

    List<PlanDeComida> findAll();

    Optional<PlanDeComida> findById(Long id);

    PlanDeComida save(PlanDeComida planDeComida);

    void update(PlanDeComida planDeComida, Long id);

    void delete(Long id);
}
