package com.Brafe.Brafe.adapter.in.controller;

import com.Brafe.Brafe.adapter.in.model.Produto;
import com.Brafe.Brafe.adapter.in.model.Produtos;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @GetMapping
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<Produtos> carrinho() {
        System.out.println("entrou aq");
    Produtos produtos = new Produtos();
    List<Produto> list = new ArrayList<>();
    Produto produto = new Produto();
        produto.setId(1L);
        produto.setDados("test");
        produto.setNome("test");
        produto.setPreco(5.0);
        produto.setQuantidade(5);
        produto.setImagem("img/cafe-5.jpg");
    list.add(produto);

        Produto produto2 = new Produto();
        produto2.setId(2L);
        produto2.setDados("test2");
        produto2.setNome("test2");
        produto2.setPreco(10.0);
        produto2.setQuantidade(10);
        produto2.setImagem("img/cafe-6.jpg");
        list.add(produto2);
    produtos.setProdutos(list);


        System.out.println(produtos);
    return ResponseEntity.status(HttpStatus.OK).body(produtos);
    }
}