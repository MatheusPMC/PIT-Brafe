package com.Brafe.Brafe.domain.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "TAB_PAGAMENTO")
public class PagamentoEntity {
    @Id
    @Column(name = "ID_PAGAMENTO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NUMERO_CARTAO")
    private String numeroCartao;

    @Column(name = "DATA_EXPIRACAO")
    private String dataExpiracao;

    @Column(name = "CVV")
    private Integer cvv;

    @Column(name = "NOME_COMPLETO")
    private String nomeCompleto;

    @Column(name = "CPF")
    private String cpf;

}