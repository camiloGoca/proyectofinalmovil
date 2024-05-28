// src/main/java/com/example/ProyectoDemo/Controller/RecetaController.java
package com.example.ProyectoDemo.Controller;

import com.example.ProyectoDemo.Entidad.Receta;
import com.example.ProyectoDemo.IService.IRecetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/receta")
public class RecetaController {

    @Autowired
    private IRecetaService recetaService;

    @GetMapping("/get")
    public List<Receta> findAll() {
        return recetaService.findAll();
    }

    @GetMapping("/get/{id}")
    public Optional<Receta> findById(@PathVariable Long id) {
        return recetaService.findById(id);
    }

    @PostMapping("/save")
    public Receta save(@RequestBody Receta receta) {
        return recetaService.save(receta);
    }

    @PutMapping("/update/{id}")
    public Receta update(@RequestBody Receta receta, @PathVariable Long id) {
        return recetaService.update(receta, id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        recetaService.delete(id);
    }
}
