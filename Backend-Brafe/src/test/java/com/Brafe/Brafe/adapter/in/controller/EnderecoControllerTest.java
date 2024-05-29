package com.Brafe.Brafe.adapter.in.controller;

import com.Brafe.Brafe.MockObj;
import com.Brafe.Brafe.adapter.in.model.Endereco;
import com.Brafe.Brafe.port.in.EnderecoCorePort;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class EnderecoControllerTest {
    @InjectMocks
    private EnderecoController enderecoController;
    @Mock
    private EnderecoCorePort enderecoCore;

    private Endereco endereco;
    private List<Endereco> enderecos;

    @BeforeEach
    void setUp() {
        endereco = new MockObj().endereco();
        enderecos = new MockObj().enderecos();
    }

    @Test
    @DisplayName("testando metodo cadastro com sucesso!")
    void test01() {
        //Cenário
        when(enderecoCore.cadastrar(any())).thenReturn(endereco);
        //Ação
        ResponseEntity<Endereco> responseEntity = enderecoController.cadastro(endereco);
        //Resultado
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(1L, Objects.requireNonNull(responseEntity.getBody()).getId());
        assertEquals("rua", Objects.requireNonNull(responseEntity.getBody()).getRua());
        assertEquals(123, Objects.requireNonNull(responseEntity.getBody()).getNumero());
        assertEquals("bairro", Objects.requireNonNull(responseEntity.getBody()).getBairro());
        assertEquals("complemento", Objects.requireNonNull(responseEntity.getBody()).getComplemento());
        assertEquals("cep", Objects.requireNonNull(responseEntity.getBody()).getCep());
        assertEquals(1L, Objects.requireNonNull(responseEntity.getBody()).getIdUsuario());
    }

    @Test
    @DisplayName("testando metodo cadastro com erro!")
    void test02() {
        //Cenário
        when(enderecoCore.cadastrar(any())).thenReturn(null);
        //Ação
        ResponseEntity<Endereco> responseEntity = enderecoController.cadastro(endereco);
        //Resultado
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());
    }

    @Test
    @DisplayName("testando metodo buscarEnderecosDoUsuario com sucesso!")
    void test03() {
        //Cenário
        when(enderecoCore.buscarEnderecosPorUsuario(any())).thenReturn(enderecos);
        //Ação
        ResponseEntity<List<Endereco>> responseEntity = enderecoController.buscarEnderecosDoUsuario(1L);
        //Resultado
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(1, Objects.requireNonNull(responseEntity.getBody()).size());
    }

    @Test
    @DisplayName("testando metodo deletarEndereco com sucesso!")
    void test04() {
        //Cenário
        when(enderecoCore.excluirEndereco(any())).thenReturn(true);
        //Ação
        ResponseEntity<Boolean> responseEntity = enderecoController.deletarEndereco(1L);
        //Resultado
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(Boolean.TRUE, responseEntity.getBody());
    }

    @Test
    @DisplayName("testando metodo deletarEndereco com erro!")
    void test05() {
        //Cenário
        when(enderecoCore.excluirEndereco(any())).thenReturn(false);
        //Ação
        ResponseEntity<Boolean> responseEntity = enderecoController.deletarEndereco(1L);
        //Resultado
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertNotEquals(Boolean.TRUE, responseEntity.getBody());
    }

    @Test
    @DisplayName("testando metodo buscarEndereco com sucesso!")
    void test06() {
        //Cenário
        when(enderecoCore.buscarEndereco(any())).thenReturn(endereco);
        //Ação
        ResponseEntity<Endereco> responseEntity = enderecoController.buscarEndereco(1L);
        //Resultado
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(1L, Objects.requireNonNull(responseEntity.getBody()).getId());
        assertEquals("rua", Objects.requireNonNull(responseEntity.getBody()).getRua());
        assertEquals(123, Objects.requireNonNull(responseEntity.getBody()).getNumero());
        assertEquals("bairro", Objects.requireNonNull(responseEntity.getBody()).getBairro());
        assertEquals("complemento", Objects.requireNonNull(responseEntity.getBody()).getComplemento());
        assertEquals("cep", Objects.requireNonNull(responseEntity.getBody()).getCep());
        assertEquals(1L, Objects.requireNonNull(responseEntity.getBody()).getIdUsuario());
    }

    @Test
    @DisplayName("testando metodo buscarEndereco com erro!")
    void test07() {
        //Cenário
        when(enderecoCore.buscarEndereco(any())).thenReturn(null);
        //Ação
        ResponseEntity<Endereco> responseEntity = enderecoController.buscarEndereco(1L);
        //Resultado
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());
    }
}