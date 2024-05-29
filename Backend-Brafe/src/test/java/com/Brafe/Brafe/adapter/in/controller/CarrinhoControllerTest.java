package com.Brafe.Brafe.adapter.in.controller;

import com.Brafe.Brafe.MockObj;
import com.Brafe.Brafe.adapter.in.model.Compra;
import com.Brafe.Brafe.adapter.in.model.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CarrinhoControllerTest {

    @InjectMocks
    private CarrinhoController carrinhoController;

    private List<Produto> produtos;

    @BeforeEach
    void setUp() {
        produtos = new MockObj().produtos();

    }

    @Test
    @DisplayName("testando metodo carrinho com sucesso!")
    void test01() {
        //Cenário
        Compra compra = new Compra();
        compra.setProdutos(produtos);
        //Ação
        ResponseEntity<Compra> responseEntity = carrinhoController.carrinho(compra);
        //Resultado
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(1, Objects.requireNonNull(responseEntity.getBody()).getProdutos().size());
        assertEquals(10.0 * 2, responseEntity.getBody().getValorCompra());
        assertEquals(10.0 * 2 + 10.0, responseEntity.getBody().getValorTotal());
    }

    @Test
    @DisplayName("testando metodo carrinho sem produtos com sucesso!")
    void test02() {
        //Cenário
        produtos.get(0).setQuantidade(0);
        Compra compra = new Compra();
        compra.setProdutos(produtos);
        //Ação
        ResponseEntity<Compra> responseEntity = carrinhoController.carrinho(compra);
        //Resultado
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(0, Objects.requireNonNull(responseEntity.getBody()).getProdutos().size());
        assertEquals(10.0 * 0, responseEntity.getBody().getValorCompra());
        assertEquals(10.0 * 0 + 10.0, responseEntity.getBody().getValorTotal());
    }
}