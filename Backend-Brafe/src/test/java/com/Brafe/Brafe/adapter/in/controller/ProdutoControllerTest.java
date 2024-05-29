package com.Brafe.Brafe.adapter.in.controller;

import com.Brafe.Brafe.MockObj;
import com.Brafe.Brafe.adapter.in.model.Produto;
import com.Brafe.Brafe.port.in.ProdutoCorePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProdutoControllerTest {
    @InjectMocks
    private ProdutoController produtoController;
    @Mock
    private ProdutoCorePort produtoCore;

    private Produto produto;
    private List<Produto> produtos;

    @BeforeEach
    void setUp() {
        produto = new MockObj().produto();
        produtos = new MockObj().produtos();
    }

    @Test
    @DisplayName("testando metodo buscarProdutos com sucesso!")
    void test01() {
        //Cenário
        when(produtoCore.buscarProdutos()).thenReturn(produtos);
        //Ação
        ResponseEntity<List<Produto>> responseEntity = produtoController.buscarProdutos();
        //Resultado
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(1, Objects.requireNonNull(responseEntity.getBody()).size());
    }

    @Test
    @DisplayName("testando metodo salvarProdutos com erro!")
    void test02() {
        //Cenário
        when(produtoCore.criarProduto(any())).thenReturn(produto);
        //Ação
        ResponseEntity<Produto> responseEntity = produtoController.salvarProdutos(produto);
        //Resultado
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(1L, Objects.requireNonNull(responseEntity.getBody()).getId());
        assertEquals("Produto1", Objects.requireNonNull(responseEntity.getBody()).getNome());
        assertEquals(10.0, Objects.requireNonNull(responseEntity.getBody()).getPreco());
        assertEquals(2, Objects.requireNonNull(responseEntity.getBody()).getQuantidade());
        assertEquals("test", Objects.requireNonNull(responseEntity.getBody()).getDescricao());
        assertNull(responseEntity.getBody().getImagem());
    }
}