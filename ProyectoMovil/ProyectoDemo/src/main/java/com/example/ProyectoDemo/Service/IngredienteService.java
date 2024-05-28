package com.example.ProyectoDemo.Service;

import com.example.ProyectoDemo.Entidad.Ingrediente;
import com.example.ProyectoDemo.IRepository.IIngredienteRepository;
import com.example.ProyectoDemo.IService.IIngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredienteService implements IIngredienteService {

    @Autowired
    private IIngredienteRepository ingredienteRepository;

    @Override
    public List<Ingrediente> findAll(){
        return ingredienteRepository.findAll();
    }

    @Override
    public Optional<Ingrediente> findById(Long id){
        return ingredienteRepository.findById(id);
    }

    @Override
    public Ingrediente save(Ingrediente ingrediente){
        return ingredienteRepository.save(ingrediente);
    }

    @Override
    public void update(Ingrediente ingrediente, Long id){
        Optional<Ingrediente> ig = ingredienteRepository.findById(id);

        if(!ig.isEmpty()){
            Ingrediente ingredienteUpdate = ig.get();
            ingredienteUpdate.setNombre(ingrediente.getNombre());
            ingredienteUpdate.setUnidadDeMedida(ingrediente.getUnidadDeMedida());
            ingredienteUpdate.setCantidad(ingrediente.getCantidad());
            ingredienteUpdate.setReceta(ingrediente.getReceta());

            ingredienteRepository.save(ingredienteUpdate);
        }else{
            System.out.println("No existe el ingrediente");
        }
    }

    @Override
    public void delete(Long id){
        ingredienteRepository.deleteById(id);
    }
}
