package com.Brafe.Brafe.adapter.in.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pagamento")
public class PagamentoController {

    @PostMapping
    public ResponseEntity<String> login(@RequestBody String loginRequest) {

        System.out.println(loginRequest);
        return ResponseEntity.status(HttpStatus.OK).body(loginRequest);
    }
}