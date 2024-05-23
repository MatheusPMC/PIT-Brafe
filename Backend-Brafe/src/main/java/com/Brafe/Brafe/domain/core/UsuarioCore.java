package com.Brafe.Brafe.domain.core;

import com.Brafe.Brafe.adapter.in.model.Login;
import com.Brafe.Brafe.adapter.in.model.Usuario;
import com.Brafe.Brafe.adapter.out.repository.UsuarioRepository;
import com.Brafe.Brafe.domain.entity.UsuarioEntity;
import com.Brafe.Brafe.domain.mapper.UsuarioMapper;
import com.Brafe.Brafe.port.in.UsuarioCorePort;
import com.Brafe.Brafe.port.in.ValidationUtilPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioCore implements UsuarioCorePort {
    private final ValidationUtilPort validationUtil;
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    public Usuario login(Login login) {
        UsuarioEntity usuarioEntity = usuarioRepository.findByEmailAndPassword(login.getEmail(), login.getPassword());
        return usuarioMapper.map(usuarioEntity);
    }

    @Override
    public Usuario cadastrar(Usuario usuario) {
        UsuarioEntity usuarioEntity = usuarioRepository.save(usuarioMapper.mapToEntity(usuario));
        return usuarioMapper.map(usuarioEntity);
    }

    @Override
    public Usuario atualizar(Usuario usuario) {
        if (usuario.getId() == null)
            throw new RuntimeException("Este usuário não possui id");

        UsuarioEntity usuarioValidado = validationUtil.validandoDadosNulosUsuarios(usuario, usuarioRepository.findById(usuario.getId()).get());
        UsuarioEntity usuarioEntity = usuarioRepository.saveAndFlush(usuarioValidado);
        return usuarioMapper.map(usuarioEntity);
    }
}