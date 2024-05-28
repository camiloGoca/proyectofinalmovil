package com.example.ProyectoDemo.Controller;

import com.example.ProyectoDemo.Entidad.PlanDeComida;
import com.example.ProyectoDemo.IService.IPlanDeComidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/planDeComida")
public class PlanDeComidaController {

    @Autowired
    private IPlanDeComidaService planDeComidaService;

    @GetMapping("/get")
    public List<PlanDeComida> findAll(){
        return planDeComidaService.findAll();
    }

    @GetMapping("/get/{id}")
    public Optional<PlanDeComida> findById(@PathVariable Long id){
        return planDeComidaService.findById(id);
    }

    @PostMapping("/save")
    public PlanDeComida save(@RequestBody PlanDeComida planDeComida){
        return planDeComidaService.save(planDeComida);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody PlanDeComida planDeComida, @PathVariable Long id){
        planDeComidaService.update(planDeComida, id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        planDeComidaService.delete(id);
    }
}
