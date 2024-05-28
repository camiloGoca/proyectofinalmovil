package com.example.ProyectoDemo.Security;

import com.example.ProyectoDemo.Entidad.Rol;
import org.springframework.security.core.GrantedAuthority;

public class SecurityAuthority implements GrantedAuthority{

    private final Rol rol;

    public SecurityAuthority(Rol rol) {
        this.rol = rol;
    }

    @Override
    public String getAuthority() {
        return rol.getNombre().toString();
    }
}
