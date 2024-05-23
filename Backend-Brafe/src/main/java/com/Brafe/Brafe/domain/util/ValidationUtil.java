package com.Brafe.Brafe.domain.util;

import com.Brafe.Brafe.adapter.in.model.Usuario;
import com.Brafe.Brafe.domain.entity.UsuarioEntity;
import com.Brafe.Brafe.port.in.ValidationUtilPort;
import org.springframework.stereotype.Service;

@Service
public class ValidationUtil implements ValidationUtilPort {

    @Override
    public UsuarioEntity validandoDadosNulosUsuarios(Usuario usuario, UsuarioEntity usuarioEntity) {
        if (usuario.getId() != null)
            usuarioEntity.setId(usuario.getId());

        if (!usuario.getPassword().isEmpty())
            usuarioEntity.setPassword(usuario.getPassword());

        if (!usuario.getEmail().isEmpty())
            usuarioEntity.setEmail(usuario.getEmail());

        if (!usuario.getCpf().isEmpty())
            usuarioEntity.setCpf(usuario.getCpf());

        if (!usuario.getNomeCompleto().isEmpty())
            usuarioEntity.setNomeCompleto(usuario.getNomeCompleto());

        return usuarioEntity;
    }
}
