package com.Brafe.Brafe.port.in;

import com.Brafe.Brafe.adapter.in.model.Endereco;
import com.Brafe.Brafe.adapter.in.model.Login;
import com.Brafe.Brafe.adapter.in.model.Usuario;
import com.Brafe.Brafe.domain.entity.EnderecoEntity;

import java.util.List;

public interface EnderecoCorePort {
    Endereco cadastrar(Endereco endereco);
    List<Endereco> buscarEnderecosPorUsuario(Long idUsuario);
    boolean excluirEndereco(Long idUsuario);
}