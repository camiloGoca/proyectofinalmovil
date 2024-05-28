// src/main/java/com/example/ProyectoDemo/Service/RecetaService.java
package com.example.ProyectoDemo.Service;

import com.example.ProyectoDemo.Entidad.Receta;
import com.example.ProyectoDemo.IRepository.IRecetaRepository;
import com.example.ProyectoDemo.IService.IRecetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecetaService implements IRecetaService {

    @Autowired
    private IRecetaRepository recetaRepository;

    @Override
    public List<Receta> findAll() {
        return recetaRepository.findAll();
    }

    @Override
    public Optional<Receta> findById(Long id) {
        return recetaRepository.findById(id);
    }

    @Override
    public Receta save(Receta receta) {
        return recetaRepository.save(receta);
    }

    @Override
    public Receta update(Receta receta, Long id) {
        Optional<Receta> optionalReceta = recetaRepository.findById(id);

        if (optionalReceta.isPresent()) {
            Receta recetaToUpdate = optionalReceta.get();
            recetaToUpdate.setNombre(receta.getNombre());
            recetaToUpdate.setDescripcion(receta.getDescripcion());
            recetaToUpdate.setInstrucciones(receta.getInstrucciones());
            recetaToUpdate.setTiempoDePreparacion(receta.getTiempoDePreparacion());
            recetaToUpdate.setDificultad(receta.getDificultad());
            recetaToUpdate.setCategoria(receta.getCategoria());

            // Actualizar ingredientes
            recetaToUpdate.getIngredientes().clear();
            recetaToUpdate.getIngredientes().addAll(receta.getIngredientes());

            return recetaRepository.save(recetaToUpdate);
        } else {
            throw new RuntimeException("Receta not found with id " + id);
        }
    }

    @Override
    public void delete(Long id) {
        recetaRepository.deleteById(id);
    }
}
