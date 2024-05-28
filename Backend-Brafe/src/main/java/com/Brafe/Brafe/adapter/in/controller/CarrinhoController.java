package com.Brafe.Brafe.adapter.in.controller;

import com.Brafe.Brafe.adapter.in.model.Compra;
import com.Brafe.Brafe.adapter.in.model.Produto;
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
    public ResponseEntity<Compra> carrinho(@RequestBody Compra compraRequest) {
        List<Produto> produtoComprado = new ArrayList<>();

        AtomicReference<Double> valor = new AtomicReference<>(0.0);
        compraRequest.getProdutos().forEach(produto -> {
            System.out.println(produto.getId());
            if (produto.getQuantidade() > 0) {
                produtoComprado.add(produto);
                valor.updateAndGet(v -> v + (produto.getPreco() * produto.getQuantidade()));
            }
        });

        Compra compra = new Compra();
        compra.setProdutos(produtoComprado);
        compra.setFrete(10.0);
        compra.setValorCompra(valor.get());
        compra.setValorTotal(valor.get() + compra.getFrete());
        return ResponseEntity.status(HttpStatus.OK).body(compra);
    }
}