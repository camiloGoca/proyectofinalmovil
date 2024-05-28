package com.example.ProyectoDemo.Service;

import com.example.ProyectoDemo.Entidad.Usuario;
import com.example.ProyectoDemo.IRepository.IUsuarioRepository;
import com.example.ProyectoDemo.IService.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> findById(Long id){
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @Override
    public void update(Usuario usuario, Long id){
        Optional<Usuario> ur = usuarioRepository.findById(id);

        if(!ur.isEmpty()){
            Usuario usuarioUpdate = ur.get();
            usuarioUpdate.setNombre(usuario.getNombre());
            usuarioUpdate.setApellido(usuario.getApellido());
            usuarioUpdate.setPassword(usuario.getPassword());
            usuarioUpdate.setCorreo(usuario.getCorreo());
            usuarioUpdate.setRoles(usuario.getRoles());

            usuarioRepository.save(usuarioUpdate);
        }else{
            System.out.println("No existe el usuario");
        }
    }

    @Override
    public void delete(Long id){
        usuarioRepository.deleteById(id);
    }
}
