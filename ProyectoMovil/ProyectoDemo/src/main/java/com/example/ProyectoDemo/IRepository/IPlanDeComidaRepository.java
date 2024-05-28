package com.example.ProyectoDemo.IRepository;

import com.example.ProyectoDemo.Entidad.PlanDeComida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlanDeComidaRepository extends JpaRepository<PlanDeComida, Long> {
}
