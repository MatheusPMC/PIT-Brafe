package com.Brafe.Brafe.adapter.in.controller;

import com.Brafe.Brafe.adapter.in.model.Login;
import com.Brafe.Brafe.adapter.in.model.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pagamento")
public class PagamentoController {

    @PostMapping
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<String> login(@RequestBody String loginRequest) {

        System.out.println(loginRequest);
            return ResponseEntity.status(HttpStatus.OK).body(loginRequest);
//        } else
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
}