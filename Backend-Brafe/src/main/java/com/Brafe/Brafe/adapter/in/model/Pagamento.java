package com.Brafe.Brafe.adapter.in.model;

import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pagamento {
    private Long id;
    private String numeroCartao;
    private String dataExpiracao;
    private Integer cvv;
    private String nomeCompleto;
    private String cpf;
    private Long idUsuariao;
    private Long idEntrega;
    private Double valor;
    private Double frete;
    private Double valorTotal;
    private List<Produto> produtos;
}