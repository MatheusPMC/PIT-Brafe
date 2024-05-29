package com.Brafe.Brafe.adapter.in.controller;

import com.Brafe.Brafe.MockObj;
import com.Brafe.Brafe.adapter.in.model.Pagamento;
import com.Brafe.Brafe.port.in.PagamentoCorePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class PagamentoControllerTest {
    @InjectMocks
    private PagamentoController pagamentoController;
    @Mock
    private PagamentoCorePort pagamentoCore;

    private Pagamento pagamento;

    @BeforeEach
    void setUp() {
        pagamento = new MockObj().pagamento();
    }

    @Test
    @DisplayName("testando metodo pagamento com sucesso!")
    void test01() {
        //Cenário
        when(pagamentoCore.salvarPagamento(any())).thenReturn(true);
        //Ação
        ResponseEntity<Boolean> responseEntity = pagamentoController.pagamento(pagamento);
        //Resultado
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(Boolean.TRUE, responseEntity.getBody());
    }

    @Test
    @DisplayName("testando metodo cadastro com erro!")
    void test02() {
        //Cenário
        when(pagamentoCore.salvarPagamento(any())).thenReturn(false);
        //Ação
        ResponseEntity<Boolean> responseEntity = pagamentoController.pagamento(pagamento);
        //Resultado
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertNotEquals(Boolean.TRUE, responseEntity.getBody());
    }

    @Test
    @DisplayName("testando metodo cadastro com exception!")
    void test03() {
        //Cenário
        when(pagamentoCore.salvarPagamento(any())).thenThrow(new RuntimeException("test"));
        //Ação
        ResponseEntity<Boolean> responseEntity = pagamentoController.pagamento(pagamento);
        //Resultado
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertNotEquals(Boolean.TRUE, responseEntity.getBody());
    }
}