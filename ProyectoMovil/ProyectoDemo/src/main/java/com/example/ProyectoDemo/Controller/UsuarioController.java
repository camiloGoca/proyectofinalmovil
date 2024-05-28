package com.example.ProyectoDemo.Controller;

import com.example.ProyectoDemo.Entidad.Usuario;
import com.example.ProyectoDemo.IService.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/get")
    public List<Usuario> findAll(){return usuarioService.findAll();}

    @GetMapping("/get/{id}")
    public Optional<Usuario> findById(@PathVariable Long id){return usuarioService.findById(id);}

    @PostMapping("/save")
    public Usuario save(@RequestBody Usuario usuario){return usuarioService.save(usuario);}

    @PutMapping("/update")
    public void update(@RequestBody Usuario usuario, @PathVariable Long id){usuarioService.update(usuario, id);}

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){usuarioService.delete(id);}
}
