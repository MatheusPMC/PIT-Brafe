package com.Brafe.Brafe.domain.core;

import com.Brafe.Brafe.adapter.in.model.Endereco;
import com.Brafe.Brafe.adapter.in.model.Login;
import com.Brafe.Brafe.adapter.in.model.Usuario;
import com.Brafe.Brafe.adapter.out.repository.EnderecoRepository;
import com.Brafe.Brafe.adapter.out.repository.UsuarioRepository;
import com.Brafe.Brafe.domain.entity.EnderecoEntity;
import com.Brafe.Brafe.domain.entity.UsuarioEntity;
import com.Brafe.Brafe.domain.mapper.EnderecoMapper;
import com.Brafe.Brafe.domain.mapper.UsuarioMapper;
import com.Brafe.Brafe.port.in.EnderecoCorePort;
import com.Brafe.Brafe.port.in.UsuarioCorePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnderecoCore implements EnderecoCorePort {

    private final EnderecoRepository enderecoRepository;
    private final EnderecoMapper enderecoMapper;

    @Override
    public Endereco cadastrar(Endereco endereco) {
        EnderecoEntity enderecoEntity =  enderecoMapper.mapToEntity(endereco);
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setId(endereco.getIdUsuario());
        enderecoEntity.setUsuario(usuarioEntity);
        return enderecoMapper.map(enderecoRepository.save(enderecoEntity));
    }

    @Override
    public List<Endereco> buscarEnderecosPorUsuario(Long idUsuario) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setId(idUsuario);
        List<EnderecoEntity> enderecos = enderecoRepository.findAllByUsuario(usuarioEntity);
        return enderecoMapper.map(enderecos);
    }

    @Override
    public boolean excluirEndereco(Long idEndereco) {
        enderecoRepository.deleteById(idEndereco);
        return enderecoRepository.findById(idEndereco).isEmpty();
    }
}