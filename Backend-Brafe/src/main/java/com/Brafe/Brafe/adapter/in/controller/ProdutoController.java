package com.Brafe.Brafe.adapter.in.controller;

import com.Brafe.Brafe.adapter.in.model.Produto;
import com.Brafe.Brafe.port.in.ProdutoCorePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("produtos")
@RequiredArgsConstructor
@Slf4j
public class ProdutoController {
    private final ProdutoCorePort produtoCore;

    @GetMapping
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<List<Produto>> buscarProdutos() {
        String nomeMetodo = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("Entrou no {}", nomeMetodo);
        List<Produto> list = produtoCore.buscarProdutos();

        log.info("Saindo do {}: {}", nomeMetodo, HttpStatus.OK);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
}