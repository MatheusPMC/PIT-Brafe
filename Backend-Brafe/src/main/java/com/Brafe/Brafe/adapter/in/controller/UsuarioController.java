package com.Brafe.Brafe.adapter.in.controller;

import com.Brafe.Brafe.adapter.in.model.Login;
import com.Brafe.Brafe.adapter.in.model.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login")
public class UsuarioController {

    @PostMapping
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<Usuario> login(@RequestBody Login loginRequest) {

        System.out.println(loginRequest);
        if (loginRequest.getEmail().equalsIgnoreCase("matheus@test.com.br")) {
            Usuario usuario = new Usuario();
            usuario.setTestando("testando");
            usuario.setUsername("Matheus");
            usuario.setTestando2("testando2");
            System.out.println("entrou aq");
            return ResponseEntity.status(HttpStatus.OK).body(usuario);
        } else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
}