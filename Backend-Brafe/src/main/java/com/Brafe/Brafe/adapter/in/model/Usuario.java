package com.Brafe.Brafe.adapter.in.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private String username;
    private String testando;
    private String testando2;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTestando() {
        return testando;
    }

    public void setTestando(String testando) {
        this.testando = testando;
    }

    public String getTestando2() {
        return testando2;
    }

    public void setTestando2(String testando2) {
        this.testando2 = testando2;
    }
}
