package com.Brafe.Brafe.domain.core;

import com.Brafe.Brafe.adapter.in.model.Pagamento;
import com.Brafe.Brafe.adapter.in.model.Produto;
import com.Brafe.Brafe.adapter.out.repository.*;
import com.Brafe.Brafe.domain.entity.*;
import com.Brafe.Brafe.domain.mapper.PagamentoMapper;
import com.Brafe.Brafe.domain.mapper.ProdutoMapper;
import com.Brafe.Brafe.port.in.PagamentoCorePort;
import com.Brafe.Brafe.port.in.ProdutoCorePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class PagamentoCore implements PagamentoCorePort {
    private final PagamentoMapper pagamentoMapper;
    private final PagamentoRepository pagamentoRepository;
    private final CompraRepository compraRepository;
    private final UsuarioRepository usuarioRepository;
    private final EnderecoRepository enderecoRepository;
    private final ProdutoRepository produtoRepository;

    @Override
    public boolean salvarPagamento(Pagamento pagamentoRequest) {

        List<ProdutoEntity> produtoEntities = new ArrayList<>();
        pagamentoRequest.getProdutos().forEach(produto -> {
            Optional<ProdutoEntity> prod = produtoRepository.findById(produto.getId());
            ProdutoEntity prodt = prod.orElseThrow(() -> new RuntimeException("Produto não existente"));
            prodt.setQuantidade(prodt.getQuantidade() - produto.getQuantidade());
            produtoEntities.add(prodt);
        });

        List<ProdutoEntity> produtosNovo = produtoRepository.saveAll(produtoEntities);
        Set<ProdutoEntity> produtoEntitySet = new HashSet<>(produtosNovo);

        Optional<EnderecoEntity> enderecoEntityOptional = enderecoRepository.findById(pagamentoRequest.getIdEntrega());
        EnderecoEntity enderecoEntity = enderecoEntityOptional.orElseThrow(() -> new RuntimeException("Endereço não existente"));

        Optional<UsuarioEntity> usuarioEntityOptional = usuarioRepository.findById(pagamentoRequest.getIdUsuariao());
        UsuarioEntity usuarioEntity = usuarioEntityOptional.orElseThrow(() -> new RuntimeException("Usuario não existente"));

        PagamentoEntity pagamentoEntity = pagamentoRepository.save(pagamentoMapper.map(pagamentoRequest));

        CompraEntity compraEntity = new CompraEntity();
        compraEntity.setEndereco(enderecoEntity);
        compraEntity.setUsuario(usuarioEntity);
        compraEntity.setPagamento(pagamentoEntity);
        compraEntity.setProdutos(produtoEntitySet);
        compraEntity.setValor(pagamentoRequest.getValor());
        compraEntity.setFrete(pagamentoRequest.getFrete());
        compraEntity.setValorTotal(pagamentoRequest.getValorTotal());
        compraRepository.save(compraEntity);
        return true;
    }
}