package com.Brafe.Brafe.adapter.in.controller;

import com.Brafe.Brafe.adapter.in.model.Login;
import com.Brafe.Brafe.adapter.in.model.Usuario;
import com.Brafe.Brafe.adapter.out.repository.EnderecoRepository;
import com.Brafe.Brafe.adapter.out.repository.ProdutoRepository;
import com.Brafe.Brafe.adapter.out.repository.UsuarioRepository;
import com.Brafe.Brafe.domain.entity.EnderecoEntity;
import com.Brafe.Brafe.domain.entity.ProdutoEntity;
import com.Brafe.Brafe.domain.entity.UsuarioEntity;
import com.Brafe.Brafe.port.in.UsuarioCorePort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("usuario")
@RequiredArgsConstructor
@Slf4j
public class UsuarioController {
    private final UsuarioCorePort usuarioCore;
    private final UsuarioRepository usuarioRepository;
    private final EnderecoRepository enderecoRepository;
    private final ProdutoRepository produtoRepository;

    private Usuario usuario;


    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody Login loginRequest) {
        String nomeMetodo = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("Entrou no {}: {}", nomeMetodo, loginRequest.getEmail());
        Usuario usuario = usuarioCore.login(loginRequest);

        if (usuario != null) {
            log.info("Saindo do {}: {}", nomeMetodo, HttpStatus.OK);
            return ResponseEntity.status(HttpStatus.OK).body(usuario);
        } else {
            log.info("Saindo do {}: {}", nomeMetodo, HttpStatus.UNAUTHORIZED);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Usuario> cadastro(@RequestBody Usuario cadastroRequest) {
        String nomeMetodo = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("Entrou no {}: {}", nomeMetodo, cadastroRequest);
        Usuario usuario = usuarioCore.cadastrar(cadastroRequest);

        if (usuario != null) {
            log.info("Saindo do {}: {}", nomeMetodo, HttpStatus.CREATED);
            return ResponseEntity.status(HttpStatus.CREATED).body(usuario);

        } else {
            log.info("Saindo do {}: {}", nomeMetodo, HttpStatus.INTERNAL_SERVER_ERROR);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Usuario> atualizar(@RequestBody Usuario cadastroRequest) {
        String nomeMetodo = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("Entrou no {}: {}", nomeMetodo, cadastroRequest);
        Usuario usuario = usuarioCore.atualizar(cadastroRequest);

        if (usuario != null) {
            log.info("Saindo do {}: {}", nomeMetodo, HttpStatus.OK);
            return ResponseEntity.status(HttpStatus.OK).body(usuario);

        } else {
            log.info("Saindo do {}: {}", nomeMetodo, HttpStatus.INTERNAL_SERVER_ERROR);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}