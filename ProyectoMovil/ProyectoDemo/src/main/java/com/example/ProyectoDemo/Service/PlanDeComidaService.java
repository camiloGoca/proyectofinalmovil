package com.example.ProyectoDemo.Service;

import com.example.ProyectoDemo.Entidad.PlanDeComida;
import com.example.ProyectoDemo.IRepository.IPlanDeComidaRepository;
import com.example.ProyectoDemo.IService.IPlanDeComidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanDeComidaService implements IPlanDeComidaService{

    @Autowired
    private IPlanDeComidaRepository planDeComidaRepository;

    @Override
    public List<PlanDeComida> findAll(){
        return planDeComidaRepository.findAll();
    }

    @Override
    public Optional<PlanDeComida> findById(Long id){
        return planDeComidaRepository.findById(id);
    }

    @Override
    public PlanDeComida save(PlanDeComida planDeComida){
        return planDeComidaRepository.save(planDeComida);
    }

    @Override
    public void update(PlanDeComida planDeComida, Long id){
        Optional<PlanDeComida> pc = planDeComidaRepository.findById(id);

        if(!pc.isEmpty()){
            PlanDeComida planDeComidaUpdate = pc.get();
            planDeComidaUpdate.setNombre(planDeComida.getNombre());
            planDeComidaUpdate.setFechaInicio(planDeComida.getFechaInicio());
            planDeComidaUpdate.setFechaFin(planDeComida.getFechaFin());
            planDeComidaUpdate.setRecetas(planDeComida.getRecetas());

            planDeComidaRepository.save(planDeComidaUpdate);
        }else{
            System.out.println("No existe el plan");
        }
    }

    @Override
    public void delete(Long id){
        planDeComidaRepository.deleteById(id);
    }
}
