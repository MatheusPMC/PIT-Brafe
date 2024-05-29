package com.Brafe.Brafe.domain.core;

import com.Brafe.Brafe.MockObj;
import com.Brafe.Brafe.adapter.in.model.Endereco;
import com.Brafe.Brafe.adapter.in.model.Pagamento;
import com.Brafe.Brafe.adapter.out.repository.*;
import com.Brafe.Brafe.domain.entity.EnderecoEntity;
import com.Brafe.Brafe.domain.entity.PagamentoEntity;
import com.Brafe.Brafe.domain.entity.ProdutoEntity;
import com.Brafe.Brafe.domain.entity.UsuarioEntity;
import com.Brafe.Brafe.domain.mapper.PagamentoMapper;
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
class PagamentoCoreTest {
    @InjectMocks
    private PagamentoCore pagamentoCore;
    @Mock
    private PagamentoMapper pagamentoMapper;
    @Mock
    private PagamentoRepository pagamentoRepository;
    @Mock
    private CompraRepository compraRepository;
    @Mock
    private UsuarioRepository usuarioRepository;
    @Mock
    private EnderecoRepository enderecoRepository;
    @Mock
    private ProdutoRepository produtoRepository;

    private Pagamento pagamento;
    private EnderecoEntity enderecoEntity;
    private ProdutoEntity produtoEntity;
    private UsuarioEntity usuarioEntity;
    private PagamentoEntity pagamentoEntity;

    @BeforeEach
    void setUp() {
        pagamento = new MockObj().pagamento();
        enderecoEntity = new MockObj().enderecoEntity();
        produtoEntity = new MockObj().produtoEntity();
        pagamentoEntity = new MockObj().pagamentoEntity();
        usuarioEntity = new MockObj().usuarioEntity();
    }

    @Test
    @DisplayName("testando metodo cadastrar com sucesso!")
    void test01() {
        //Cenário
        when(produtoRepository.findById(any())).thenReturn(Optional.of(produtoEntity));
        when(produtoRepository.saveAll(any())).thenReturn(List.of(produtoEntity));
        when(enderecoRepository.findById(any())).thenReturn(Optional.of(enderecoEntity));
        when(usuarioRepository.findById(any())).thenReturn(Optional.of(usuarioEntity));
        when(pagamentoRepository.save(any())).thenReturn(pagamentoEntity);

        //Ação
        boolean response = pagamentoCore.salvarPagamento(pagamento);
        //Resultado
        assertTrue(response);
    }
}