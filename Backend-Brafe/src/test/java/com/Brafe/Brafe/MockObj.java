package com.Brafe.Brafe;

import com.Brafe.Brafe.adapter.in.model.Endereco;
import com.Brafe.Brafe.adapter.in.model.Pagamento;
import com.Brafe.Brafe.adapter.in.model.Produto;
import com.Brafe.Brafe.adapter.in.model.Usuario;
import com.Brafe.Brafe.domain.entity.EnderecoEntity;
import com.Brafe.Brafe.domain.entity.PagamentoEntity;
import com.Brafe.Brafe.domain.entity.ProdutoEntity;
import com.Brafe.Brafe.domain.entity.UsuarioEntity;

import java.util.List;

public class MockObj {

    public Produto produto() {
        return new Produto(1L, "Produto1", 10.0, "test", 2, null);
    }

    public ProdutoEntity produtoEntity() {
        return new ProdutoEntity(1L, "Produto1", 10.0, "test", 2, null, null);

    }

    public List<Produto> produtos() {
        return List.of(produto());
    }

    public Endereco endereco() {
        return new Endereco(1L, "rua", 123, "bairro", "complemento", "cep", 1L);
    }
    public EnderecoEntity enderecoEntity() {
        return new EnderecoEntity(1L, "rua", 123, "bairro", "complemento", "cep", null);
    }

    public List<Endereco> enderecos() {
        return List.of(endereco());
    }

    public Pagamento pagamento() {
        return new Pagamento(1L, "numeroCartao", "dataExpiracao", 123, "nomeCompleto", "cpf", 1L, 1L, 10.0, 10.0, 20.0, produtos());
    }

    public PagamentoEntity pagamentoEntity() {
        return new PagamentoEntity(1L, "numeroCartao", "dataExpiracao", 123, "nomeCompleto", "cpf");

    }

    public Usuario usuario() {
        return new Usuario(1L, "email", "password", "nomeCompleto", "cpf");
    }

    public UsuarioEntity usuarioEntity() {
        return new UsuarioEntity(1L, "email", "password", "nomeCompleto", "cpf");

    }
}