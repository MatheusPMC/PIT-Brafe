package com.Brafe.Brafe.adapter.in.model;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private Long id;
    private String email;
    private String password;
    private String nomeCompleto;
    private String cpf;

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                '}';
    }
}