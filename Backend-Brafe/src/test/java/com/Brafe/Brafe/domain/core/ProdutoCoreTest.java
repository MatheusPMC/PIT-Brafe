package com.Brafe.Brafe.domain.core;

import com.Brafe.Brafe.MockObj;
import com.Brafe.Brafe.adapter.in.model.Produto;
import com.Brafe.Brafe.adapter.out.repository.ProdutoRepository;
import com.Brafe.Brafe.domain.entity.ProdutoEntity;
import com.Brafe.Brafe.domain.mapper.ProdutoMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProdutoCoreTest {
    @InjectMocks
    private ProdutoCore produtoCore;
    @Mock
    private ProdutoRepository produtoRepository;
    @Mock
    private ProdutoMapper produtoMapper;

    private Produto produto;
    private ProdutoEntity produtoEntity;

    @BeforeEach
    void setUp() {
        produto = new MockObj().produto();
        produtoEntity = new MockObj().produtoEntity();
    }

    @Test
    @DisplayName("testando metodo buscarProdutos com sucesso!")
    void test01() {
        //Cenário
        when(produtoRepository.findAll()).thenReturn(List.of(produtoEntity));
        when(produtoMapper.map(List.of(produtoEntity))).thenReturn(List.of(produto));
        //Ação
        List<Produto> response = produtoCore.buscarProdutos();
        //Resultado
        assertEquals(response, List.of(produto));
    }

    @Test
    @DisplayName("testando metodo criarProduto com sucesso!")
    void test02() {
        //Cenário
        when(produtoRepository.save(any())).thenReturn(produtoEntity);
        when(produtoMapper.map(produtoEntity)).thenReturn(produto);
        //Ação
        Produto response = produtoCore.criarProduto(produto);
        //Resultado
        assertEquals(response, produto);
    }
}