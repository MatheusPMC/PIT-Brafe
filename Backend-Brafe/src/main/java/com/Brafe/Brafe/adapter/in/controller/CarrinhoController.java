package com.Brafe.Brafe.adapter.in.controller;

import com.Brafe.Brafe.adapter.in.model.Produto;
import com.Brafe.Brafe.adapter.in.model.Produtos;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping("carrinho")
public class CarrinhoController {

    @PostMapping
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<Produtos> carrinho(@RequestBody Produtos produtos) {

        System.out.println(produtos);
        List<Produto> produtoComprado = new ArrayList<>();
        AtomicReference<Double> valor = new AtomicReference<>(0.0);
        produtos.getProdutos().forEach(produto -> {
            if (produto.getQuantidade() > 0) {
                produtoComprado.add(produto);
                valor.updateAndGet(v -> v + produto.getPreco());
            }
        });
        Produto produto = produtos.getProdutos().get(0);

        Produtos novosProdutos = new Produtos();
        novosProdutos.setProdutos(produtoComprado);
        novosProdutos.setFrete(10.0);
        novosProdutos.setValorCompra(valor.get());
        novosProdutos.setValorTotal(valor.get() + novosProdutos.getFrete());
        return ResponseEntity.status(HttpStatus.OK).body(novosProdutos);
    }
}