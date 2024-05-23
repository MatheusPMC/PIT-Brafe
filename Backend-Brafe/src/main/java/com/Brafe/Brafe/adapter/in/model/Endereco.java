package com.Brafe.Brafe.adapter.in.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Endereco {
    private Long id;

    private String rua;

    private Integer numero;

    private String bairro;

    private String complemento;

    private String cep;

    private Long idUsuario;
}