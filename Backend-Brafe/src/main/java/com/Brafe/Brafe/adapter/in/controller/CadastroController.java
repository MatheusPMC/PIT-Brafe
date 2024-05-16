package com.Brafe.Brafe.adapter.in.controller;

import com.Brafe.Brafe.adapter.in.model.Login;
import com.Brafe.Brafe.adapter.in.model.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cadastro")
public class CadastroController {

    @PostMapping
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<Usuario> login(@RequestBody String cadastroRequest) {

        System.out.println(cadastroRequest);

        Usuario usuario = new Usuario();
        usuario.setTestando("testando");
        usuario.setUsername("Matheus");
        usuario.setTestando2("testando2");
        System.out.println("entrou aq");
            return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }
}