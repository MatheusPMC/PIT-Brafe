package com.Brafe.Brafe.domain.core;

import com.Brafe.Brafe.MockObj;
import com.Brafe.Brafe.adapter.in.model.Endereco;
import com.Brafe.Brafe.adapter.out.repository.EnderecoRepository;
import com.Brafe.Brafe.domain.entity.EnderecoEntity;
import com.Brafe.Brafe.domain.mapper.EnderecoMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class EnderecoCoreTest {
    @InjectMocks
    private EnderecoCore enderecoCore;
    @Mock
    private EnderecoRepository enderecoRepository;
    @Mock
    private EnderecoMapper enderecoMapper;

    private Endereco endereco;
    private EnderecoEntity enderecoEntity;

    @BeforeEach
    void setUp() {
        endereco = new MockObj().endereco();
        enderecoEntity = new MockObj().enderecoEntity();
    }

    @Test
    @DisplayName("testando metodo cadastrar com sucesso!")
    void test01() {
        //Cenário
        when(enderecoMapper.mapToEntity(endereco)).thenReturn(enderecoEntity);
        when(enderecoRepository.save(any())).thenReturn(enderecoEntity);
        when(enderecoMapper.map(enderecoEntity)).thenReturn(endereco);

        //Ação
        Endereco response = enderecoCore.cadastrar(endereco);
        //Resultado
        assertEquals(response, endereco);
    }

    @Test
    @DisplayName("testando metodo buscarEnderecosPorUsuario com sucesso!")
    void test02() {
        //Cenário
        when(enderecoRepository.findAllByUsuario(any())).thenReturn(List.of(enderecoEntity));
        when(enderecoMapper.map(List.of(enderecoEntity))).thenReturn(List.of(endereco));
        //Ação
        List<Endereco> response = enderecoCore.buscarEnderecosPorUsuario(1L);
        //Resultado
        assertEquals(response, List.of(endereco));
    }

    @Test
    @DisplayName("testando metodo excluirEndereco com sucesso!")
    void test03() {
        //Cenário
        when(enderecoRepository.findById(any())).thenReturn(Optional.empty());
        //Ação
        boolean response = enderecoCore.excluirEndereco(1L);
        //Resultado
        assertTrue(response);
        verify(enderecoRepository, times(1)).deleteById(1L);
        verify(enderecoRepository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("testando metodo buscarEndereco com sucesso!")
    void test04() {
        //Cenário
        when(enderecoRepository.findById(any())).thenReturn(Optional.of(enderecoEntity));
        when(enderecoMapper.map(enderecoEntity)).thenReturn(endereco);
        //Ação
        Endereco response = enderecoCore.buscarEndereco(1L);
        //Resultado
        assertEquals(response, endereco);
    }
}