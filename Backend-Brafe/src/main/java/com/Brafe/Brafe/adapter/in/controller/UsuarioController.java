package com.Brafe.Brafe.adapter.in.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login")
public class UsuarioController {

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:8080")
    public Usuario login() {
        System.out.println("entrou aq!");
        Usuario usuario = new Usuario();
        usuario.setTestando("testando");
        usuario.setUsername("Matheus");
        usuario.setTestando2("testando2");
        return usuario;
    }
}
