package com.Brafe.Brafe.adapter.in.controller;

import com.Brafe.Brafe.adapter.in.model.Endereco;
import com.Brafe.Brafe.port.in.EnderecoCorePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("endereco")
@RequiredArgsConstructor
@Slf4j
public class EnderecoController {
    private final EnderecoCorePort enderecoCore;

    @PostMapping("/cadastro")
    public ResponseEntity<Endereco> cadastro(@RequestBody Endereco enderecoRequest) {
        String nomeMetodo = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("Entrou no {}: {}", nomeMetodo, enderecoRequest);

        Endereco endereco = enderecoCore.cadastrar(enderecoRequest);

        if (endereco != null) {
            log.info("Saindo do {}: {}", nomeMetodo, HttpStatus.CREATED);
            return ResponseEntity.status(HttpStatus.CREATED).body(endereco);
        } else {
            log.info("Saindo do {}: {}", nomeMetodo, HttpStatus.INTERNAL_SERVER_ERROR);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{idEndereco}")
    public ResponseEntity<Endereco> buscarEndereco(@PathVariable Long idEndereco) {
        String nomeMetodo = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("Entrou no {}: {}", nomeMetodo, idEndereco);

        Endereco endereco = enderecoCore.buscarEndereco(idEndereco);

        if (endereco != null) {
            log.info("Saindo do {}:, quantidade: {}, {}", nomeMetodo, endereco, HttpStatus.OK);
            return ResponseEntity.status(HttpStatus.OK).body(endereco);
        } else {
            log.info("Saindo do {}:, quantidade: {}, {}", nomeMetodo, endereco, HttpStatus.BAD_REQUEST);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<Endereco>> buscarEnderecosDoUsuario(@PathVariable Long idUsuario) {
        String nomeMetodo = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("Entrou no {}: {}", nomeMetodo, idUsuario);

        List<Endereco> enderecos = enderecoCore.buscarEnderecosPorUsuario(idUsuario);

        log.info("Saindo do {}:, quantidade: {}, {}", nomeMetodo, enderecos.size(), HttpStatus.OK);
        return ResponseEntity.status(HttpStatus.OK).body(enderecos);

    }

    @DeleteMapping("/{idEndereco}")
    public ResponseEntity<Boolean> deletarEndereco(@PathVariable Long idEndereco) {
        String nomeMetodo = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("Entrou no {}: {}", nomeMetodo, idEndereco);
        if (enderecoCore.excluirEndereco(idEndereco)) {
            log.info("Saindo do {}: {}", nomeMetodo, HttpStatus.OK);
            return ResponseEntity.status(HttpStatus.OK).body(true);
        } else {
            log.info("Saindo do {}: {}", nomeMetodo, HttpStatus.INTERNAL_SERVER_ERROR);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }
}