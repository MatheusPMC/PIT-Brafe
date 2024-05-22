package com.Brafe.Brafe.adapter.in.model;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Usuario {
    private Long id;
    private String email;
    private String password;
    private String nomeCompleto;
    private String cpf;
}