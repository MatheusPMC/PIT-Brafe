package com.Brafe.Brafe.adapter.in.controller;

import com.Brafe.Brafe.adapter.in.model.Pagamento;
import com.Brafe.Brafe.port.in.PagamentoCorePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pagamento")
@Slf4j
@RequiredArgsConstructor
public class PagamentoController {
    private final PagamentoCorePort pagamentoCore;

    @PostMapping
    public ResponseEntity<Boolean> pagamento(@RequestBody Pagamento pagamentoRequest) {
        String nomeMetodo = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("Entrou no {}", nomeMetodo);

        System.out.println(pagamentoRequest);

        if (pagamentoCore.salvarPagamento(pagamentoRequest)) {
            log.info("Saindo do {}: {}", nomeMetodo, HttpStatus.OK);
            return ResponseEntity.status(HttpStatus.OK).body(true);
        } else {
            log.info("Saindo do {}: {}", nomeMetodo, HttpStatus.INTERNAL_SERVER_ERROR);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }
}