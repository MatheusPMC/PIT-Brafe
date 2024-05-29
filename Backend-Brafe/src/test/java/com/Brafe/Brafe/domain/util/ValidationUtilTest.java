package com.Brafe.Brafe.domain.util;

import com.Brafe.Brafe.MockObj;
import com.Brafe.Brafe.adapter.in.model.Usuario;
import com.Brafe.Brafe.domain.entity.UsuarioEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ValidationUtilTest {
    @InjectMocks
    private ValidationUtil validationUtil;

    private Usuario usuario;
    private UsuarioEntity usuarioEntity;

    @BeforeEach
    void setUp() {
        usuario = new MockObj().usuario();
        usuarioEntity = new MockObj().usuarioEntity();
    }

    @Test
    @DisplayName("testando metodo validandoDadosNulosUsuarios com sucesso!")
    void test01() {
        //Ação
        UsuarioEntity response = validationUtil.validandoDadosNulosUsuarios(usuario, usuarioEntity);
        //Resultado
        assertEquals(response, usuarioEntity);
    }

    @Test
    @DisplayName("testando metodo validandoDadosNulosUsuarios com dados nulos!")
    void test02() {
        //Cenário
        usuario.setId(null);
        usuario.setPassword("");
        usuario.setEmail("");
        usuario.setCpf("");
        usuario.setNomeCompleto("");
        //Ação
        UsuarioEntity response = validationUtil.validandoDadosNulosUsuarios(usuario, usuarioEntity);
        //Resultado
        assertEquals(response, usuarioEntity);
    }
}