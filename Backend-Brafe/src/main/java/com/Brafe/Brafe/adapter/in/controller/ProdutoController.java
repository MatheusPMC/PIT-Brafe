package com.Brafe.Brafe.adapter.in.controller;

import com.Brafe.Brafe.adapter.in.model.Produto;
import com.Brafe.Brafe.adapter.in.model.Usuario;
import com.Brafe.Brafe.port.in.ProdutoCorePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos")
@RequiredArgsConstructor
@Slf4j
public class ProdutoController {
    private final ProdutoCorePort produtoCore;

    @GetMapping
    public ResponseEntity<List<Produto>> buscarProdutos() {
        String nomeMetodo = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("Entrou no {}", nomeMetodo);
        List<Produto> list = produtoCore.buscarProdutos();

        log.info("Saindo do {}: {}", nomeMetodo, HttpStatus.OK);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping
    public ResponseEntity<Produto> salvarProdutos(@RequestBody Produto produtoRequest) {
        String nomeMetodo = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("Entrou no {}", nomeMetodo);
        Produto resposta = produtoCore.criarProduto(produtoRequest);

        log.info("Saindo do {}: {}", nomeMetodo, HttpStatus.CREATED);
        return ResponseEntity.status(HttpStatus.OK).body(resposta);
    }
}