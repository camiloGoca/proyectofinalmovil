package com.example.ProyectoDemo.Utils;

import com.example.ProyectoDemo.Entidad.Rol;
import com.example.ProyectoDemo.Entidad.Usuario;
import com.example.ProyectoDemo.IRepository.IRolRepository;
import com.example.ProyectoDemo.IRepository.IUsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    private final IUsuarioRepository usuarioRepository;
    private final IRolRepository rolRepository;

    public Runner(IUsuarioRepository usuarioRepository, IRolRepository rolRepository) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
    }

    @Override
    public void run(String... args) throws Exception{
        if(this.rolRepository.count() == 0){
            this.rolRepository.saveAll(List.of(
                    new Rol(AuthorityNombres.ADMIN),
                    new Rol(AuthorityNombres.USER)
            ));
        }

        if(this.usuarioRepository.count()==0){
            this.usuarioRepository.saveAll(List.of(
                    ngit gew Usuario("Admin123", List.of(this.rolRepository.findByNombre(AuthorityNombres.ADMIN).get()), "afavila@corhuila.edu.co"),
                    new Usuario("Admin321", List.of(this.rolRepository.findByNombre(AuthorityNombres.ADMIN).get()), "ygomez@corhuila.edu.co"),
                    new Usuario("Admin312", List.of(this.rolRepository.findByNombre(AuthorityNombres.ADMIN).get()), "sangel@corhuila.edu.co")
            ));
        }
    }
}
