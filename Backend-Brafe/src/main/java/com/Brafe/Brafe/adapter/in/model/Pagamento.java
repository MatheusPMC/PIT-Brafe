package com.Brafe.Brafe.adapter.in.model;

import lombok.*;


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
    private Double valorTotal;
}