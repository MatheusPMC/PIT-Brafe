package com.Brafe.Brafe.domain.core;

import com.Brafe.Brafe.adapter.in.model.Login;
import com.Brafe.Brafe.adapter.in.model.Usuario;
import com.Brafe.Brafe.adapter.out.repository.UsuarioRepository;
import com.Brafe.Brafe.domain.entity.UsuarioEntity;
import com.Brafe.Brafe.domain.mapper.UsuarioMapper;
import com.Brafe.Brafe.port.in.UsuarioCorePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioCore implements UsuarioCorePort {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    public Usuario login(Login login) {
        UsuarioEntity usuarioEntity = usuarioRepository.findByEmailAndPassword(login.getEmail(), login.getPassword());
        return usuarioMapper.map(usuarioEntity);
    }
}
