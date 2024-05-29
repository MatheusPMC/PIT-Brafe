package com.Brafe.Brafe.domain.core;

import com.Brafe.Brafe.MockObj;
import com.Brafe.Brafe.adapter.in.model.Login;
import com.Brafe.Brafe.adapter.in.model.Usuario;
import com.Brafe.Brafe.adapter.out.repository.UsuarioRepository;
import com.Brafe.Brafe.domain.entity.UsuarioEntity;
import com.Brafe.Brafe.domain.mapper.UsuarioMapper;
import com.Brafe.Brafe.port.in.ValidationUtilPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class UsuarioCoreTest {
    @InjectMocks
    private UsuarioCore usuarioCore;
    @Mock
    private ValidationUtilPort validationUtil;
    @Mock
    private UsuarioRepository usuarioRepository;
    @Mock
    private UsuarioMapper usuarioMapper;

    private Login login;
    private Usuario usuario;
    private UsuarioEntity usuarioEntity;

    @BeforeEach
    void setUp() {
        login = new Login("email", "password");
        usuario = new MockObj().usuario();
        usuarioEntity = new MockObj().usuarioEntity();
    }

    @Test
    @DisplayName("testando metodo login com sucesso!")
    void test01() {
        //Cenário
        when(usuarioRepository.findByEmailAndPassword(any(), any())).thenReturn(usuarioEntity);
        when(usuarioMapper.map(usuarioEntity)).thenReturn(usuario);
        //Ação
        Usuario response = usuarioCore.login(login);
        //Resultado
        assertEquals(response, usuario);
    }

    @Test
    @DisplayName("testando metodo cadastrar com sucesso!")
    void test02() {
        //Cenário
        when(usuarioRepository.save(any())).thenReturn(usuarioEntity);
        when(usuarioMapper.map(usuarioEntity)).thenReturn(usuario);
        //Ação
        Usuario response = usuarioCore.cadastrar(usuario);
        //Resultado
        assertEquals(response, usuario);
    }

    @Test
    @DisplayName("testando metodo atualizar com sucesso!")
    void test03() {
        //Cenário
        when(usuarioRepository.findById(any())).thenReturn(Optional.of(usuarioEntity));
        when(validationUtil.validandoDadosNulosUsuarios(any(), any())).thenReturn(usuarioEntity);
        when(usuarioRepository.saveAndFlush(any())).thenReturn(usuarioEntity);
        when(usuarioMapper.map(usuarioEntity)).thenReturn(usuario);
        //Ação
        Usuario response = usuarioCore.atualizar(usuario);
        //Resultado
        assertEquals(response, usuario);
    }

    @Test
    @DisplayName("testando metodo atualizar com exception!")
    void test04() {
        //Cenário
        usuario.setId(null);
        //Ação
        RuntimeException response = assertThrows(RuntimeException.class, () ->
                usuarioCore.atualizar(usuario)
        );
        //Resultado
        assertEquals(response.getMessage(), "Este usuário não possui id");
    }
}