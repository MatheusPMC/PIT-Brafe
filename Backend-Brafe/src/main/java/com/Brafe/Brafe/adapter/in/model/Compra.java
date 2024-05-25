package com.Brafe.Brafe.adapter.in.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Compra {
    List<Produto> produtos;
    Double frete;
    Double valorCompra;
    Double valorTotal;
}