package com.example.ProyectoDemo.Controller;

import com.example.ProyectoDemo.Entidad.Ingrediente;
import com.example.ProyectoDemo.IService.IIngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ingrediente")
public class IngredienteController {

    @Autowired
    private IIngredienteService ingredienteService;

    @GetMapping("/get")
    public List<Ingrediente> findAll(){
        return ingredienteService.findAll();
    }

    @GetMapping("/get/{id}")
    public Optional<Ingrediente> findById(@PathVariable Long id){
        return ingredienteService.findById(id);
    }

    @PostMapping("/save")
    public Ingrediente save(@RequestBody Ingrediente ingrediente){
        return ingredienteService.save(ingrediente);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody Ingrediente ingrediente, @PathVariable Long id){
        ingredienteService.update(ingrediente, id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        ingredienteService.delete(id);
    }

}
