package com.Brafe.Brafe.adapter.in.controller;

import com.Brafe.Brafe.adapter.in.model.Login;
import com.Brafe.Brafe.adapter.in.model.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    private Usuario usuario;

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<Usuario> login(@RequestBody Login loginRequest) {
        System.out.println(loginRequest);
        if (usuario != null && loginRequest.getEmail().equalsIgnoreCase(usuario.getEmail()) && loginRequest.getPassword().equals(usuario.getPassword())) {
            return ResponseEntity.status(HttpStatus.OK).body(usuario);
        } else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
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

    @PutMapping("/atualizar")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<Usuario> atualizar(@RequestBody Usuario cadastroRequest) {
        System.out.println(cadastroRequest);

        return ResponseEntity.status(HttpStatus.OK).body(cadastroRequest);
    }
}