package com.Brafe.Brafe.domain.core;

import com.Brafe.Brafe.adapter.in.model.Produto;
import com.Brafe.Brafe.adapter.out.repository.ProdutoRepository;
import com.Brafe.Brafe.domain.entity.ProdutoEntity;
import com.Brafe.Brafe.domain.mapper.ProdutoMapper;
import com.Brafe.Brafe.port.in.ProdutoCorePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoCore implements ProdutoCorePort {
    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;


    @Override
    public List<Produto> buscarProdutos() {
        List<ProdutoEntity> listaProduto = produtoRepository.findAll();
        return produtoMapper.map(listaProduto);
    }
}