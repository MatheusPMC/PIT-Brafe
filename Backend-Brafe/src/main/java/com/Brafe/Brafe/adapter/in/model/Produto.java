package com.Brafe.Brafe.adapter.in.model;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Produto {
    private Long id;
    private String nome;
    private Double preco;
    private String descricao;
    private Integer quantidade;
    private String imagem;
}