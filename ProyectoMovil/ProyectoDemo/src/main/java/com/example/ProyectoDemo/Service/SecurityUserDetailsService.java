package com.example.ProyectoDemo.Service;

import com.example.ProyectoDemo.IRepository.IUsuarioRepository;
import com.example.ProyectoDemo.Security.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

    private final IUsuarioRepository usuarioRepository;


    public SecurityUserDetailsService(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        var opUser = this.usuarioRepository.findByCorreo(correo);

        if(opUser.isPresent()){
            return new SecurityUser(opUser.get());
        }
        throw new UsernameNotFoundException("User not found: "+correo);
    }
}
