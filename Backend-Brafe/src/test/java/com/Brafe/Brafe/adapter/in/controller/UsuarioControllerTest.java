package com.Brafe.Brafe.adapter.in.controller;

import com.Brafe.Brafe.MockObj;
import com.Brafe.Brafe.adapter.in.model.Login;
import com.Brafe.Brafe.adapter.in.model.Usuario;
import com.Brafe.Brafe.port.in.UsuarioCorePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class UsuarioControllerTest {
    @InjectMocks
    private UsuarioController usuarioController;
    @Mock
    private UsuarioCorePort usuarioCore;

    private Usuario usuario;
    private Login login;

    @BeforeEach
    void setUp() {
        usuario = new MockObj().usuario();
        login = new Login("email", "password");
    }

    @Test
    @DisplayName("testando metodo login com sucesso!")
    void test01() {
        //Cenário
        when(usuarioCore.login(any())).thenReturn(usuario);
        //Ação
        ResponseEntity<Usuario> responseEntity = usuarioController.login(login);
        //Resultado
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(1, Objects.requireNonNull(responseEntity.getBody()).getId());
        assertEquals("email", Objects.requireNonNull(responseEntity.getBody()).getEmail());
        assertEquals("nomeCompleto", Objects.requireNonNull(responseEntity.getBody()).getNomeCompleto());
        assertEquals("password", Objects.requireNonNull(responseEntity.getBody()).getPassword());
        assertEquals("cpf", Objects.requireNonNull(responseEntity.getBody()).getCpf());
    }

    @Test
    @DisplayName("testando metodo login com erro!")
    void test02() {
        //Cenário
        when(usuarioCore.login(any())).thenReturn(null);
        //Ação
        ResponseEntity<Usuario> responseEntity = usuarioController.login(login);
        //Resultado
        assertEquals(HttpStatus.UNAUTHORIZED, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());
    }

    @Test
    @DisplayName("testando metodo cadastro com sucesso!")
    void test03() {
        //Cenário
        when(usuarioCore.cadastrar(any())).thenReturn(usuario);
        //Ação
        ResponseEntity<Usuario> responseEntity = usuarioController.cadastro(usuario);
        //Resultado
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(1, Objects.requireNonNull(responseEntity.getBody()).getId());
        assertEquals("email", Objects.requireNonNull(responseEntity.getBody()).getEmail());
        assertEquals("nomeCompleto", Objects.requireNonNull(responseEntity.getBody()).getNomeCompleto());
        assertEquals("password", Objects.requireNonNull(responseEntity.getBody()).getPassword());
        assertEquals("cpf", Objects.requireNonNull(responseEntity.getBody()).getCpf());
    }

    @Test
    @DisplayName("testando metodo cadastro com erro!")
    void test04() {
        //Cenário
        when(usuarioCore.cadastrar(any())).thenReturn(null);
        //Ação
        ResponseEntity<Usuario> responseEntity = usuarioController.cadastro(usuario);
        //Resultado
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());
    }

    @Test
    @DisplayName("testando metodo atualizar com sucesso!")
    void test05() {
        //Cenário
        when(usuarioCore.atualizar(any())).thenReturn(usuario);
        //Ação
        ResponseEntity<Usuario> responseEntity = usuarioController.atualizar(usuario);
        //Resultado
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(1, Objects.requireNonNull(responseEntity.getBody()).getId());
        assertEquals("email", Objects.requireNonNull(responseEntity.getBody()).getEmail());
        assertEquals("nomeCompleto", Objects.requireNonNull(responseEntity.getBody()).getNomeCompleto());
        assertEquals("password", Objects.requireNonNull(responseEntity.getBody()).getPassword());
        assertEquals("cpf", Objects.requireNonNull(responseEntity.getBody()).getCpf());
    }

    @Test
    @DisplayName("testando metodo atualizar com erro!")
    void test06() {
        //Cenário
        when(usuarioCore.atualizar(any())).thenReturn(null);
        //Ação
        ResponseEntity<Usuario> responseEntity = usuarioController.atualizar(usuario);
        //Resultado
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());
    }
}