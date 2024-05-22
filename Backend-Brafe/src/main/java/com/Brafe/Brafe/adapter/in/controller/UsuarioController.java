package com.Brafe.Brafe.adapter.in.controller;

import com.Brafe.Brafe.adapter.in.model.Login;
import com.Brafe.Brafe.adapter.in.model.Usuario;
import com.Brafe.Brafe.adapter.out.repository.EnderecoRepository;
import com.Brafe.Brafe.adapter.out.repository.UsuarioRepository;
import com.Brafe.Brafe.domain.entity.EnderecoEntity;
import com.Brafe.Brafe.domain.entity.UsuarioEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    private Usuario usuario;


    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<Usuario> login(@RequestBody Login loginRequest) {
        System.out.println(loginRequest);
        if (usuario != null && loginRequest.getEmail().equalsIgnoreCase(usuario.getEmail()) && loginRequest.getPassword().equals(usuario.getPassword())) {
            return ResponseEntity.status(HttpStatus.OK).body(usuario);
        } else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }

    @PostMapping("/cadastro")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<Usuario> cadastro(@RequestBody Usuario cadastroRequest) {
        System.out.println(cadastroRequest);
        if (usuario == null)
            usuario = new Usuario();
        if (usuario.getId() != null)
            cadastroRequest.setId(usuario.getId() + 1L);
        else
            cadastroRequest.setId(1L);

        usuario = cadastroRequest;
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }


    @Transactional
    @GetMapping("/test")
    @CrossOrigin(origins = "http://localhost:8080")
    public void test() {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
//usuarioEntity.setId(1L);
        usuarioEntity.setCpf("12345678910");
        usuarioEntity.setEmail("matheus@test.com");
        usuarioEntity.setPassword("123456");
        usuarioEntity.setNomeCompleto("Matheus do Prado Marques da Costa");
        UsuarioEntity usuarioSalvo = usuarioRepository.save(usuarioEntity);

        EnderecoEntity enderecoEntity = new EnderecoEntity();
        enderecoEntity.setRua("Testando a rua!");
        enderecoEntity.setNumero(123);
        enderecoEntity.setBairro("Centro");
        enderecoEntity.setComplemento("Casa");
        enderecoEntity.setCep("12345-123");
        enderecoEntity.setUsuario(usuarioSalvo);
        enderecoRepository.save(enderecoEntity);
        System.out.println(enderecoRepository.findAll());

        System.out.println(usuarioRepository.findAll());

    }

    @PutMapping("/atualizar")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<Usuario> atualizar(@RequestBody Usuario cadastroRequest) {
        System.out.println(cadastroRequest);

        return ResponseEntity.status(HttpStatus.OK).body(cadastroRequest);
    }
}