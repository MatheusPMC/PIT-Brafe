package com.Brafe.Brafe.domain.core;

import com.Brafe.Brafe.adapter.in.model.Pagamento;
import com.Brafe.Brafe.adapter.in.model.Produto;
import com.Brafe.Brafe.adapter.out.repository.*;
import com.Brafe.Brafe.domain.entity.EnderecoEntity;
import com.Brafe.Brafe.domain.entity.PagamentoEntity;
import com.Brafe.Brafe.domain.entity.ProdutoEntity;
import com.Brafe.Brafe.domain.entity.UsuarioEntity;
import com.Brafe.Brafe.domain.mapper.PagamentoMapper;
import com.Brafe.Brafe.domain.mapper.ProdutoMapper;
import com.Brafe.Brafe.port.in.PagamentoCorePort;
import com.Brafe.Brafe.port.in.ProdutoCorePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PagamentoCore implements PagamentoCorePort {
    private final PagamentoMapper pagamentoMapper;
    private final PagamentoRepository pagamentoRepository;
    private final CompraRepository compraRepository;
    private final UsuarioRepository usuarioRepository;
    private final EnderecoRepository enderecoRepository;

    @Override
    public boolean salvarPagamento(Pagamento pagamentoRequest) {

        Optional<EnderecoEntity> enderecoEntityOptional = enderecoRepository.findById(pagamentoRequest.getIdEntrega());
        EnderecoEntity enderecoEntity = enderecoEntityOptional.orElseThrow(() -> new RuntimeException("Endereço não existente"));

        Optional<UsuarioEntity> usuarioEntityOptional = usuarioRepository.findById(pagamentoRequest.getIdUsuariao());
        UsuarioEntity usuarioEntity = usuarioEntityOptional.orElseThrow(() -> new RuntimeException("Usuario não existente"));

        System.out.println(pagamentoMapper.map(pagamentoRequest));
        PagamentoEntity pagamentoEntity = pagamentoRepository.save(pagamentoMapper.map(pagamentoRequest));


        return true;
    }
}