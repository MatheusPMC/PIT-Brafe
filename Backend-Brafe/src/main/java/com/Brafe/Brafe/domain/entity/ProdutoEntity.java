package com.Brafe.Brafe.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TAB_PRODUTO")
public class ProdutoEntity {
    @Id
    @Column(name = "ID_PRODUTO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "PRECO")
    private Double preco;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "QUANTIDADE")
    private Integer quantidade;

    @Column(name = "IMAGEM")
    private String imagem;

    @ManyToMany(mappedBy = "produtos")
    private Set<CompraEntity> compras = new HashSet<>();
}