
package com.Brafe.Brafe.adapter.in.controller;

import com.Brafe.Brafe.adapter.in.model.Login;
import com.Brafe.Brafe.adapter.in.model.Usuario;
import com.Brafe.Brafe.adapter.out.repository.EnderecoRepository;
import com.Brafe.Brafe.adapter.out.repository.ProdutoRepository;
import com.Brafe.Brafe.adapter.out.repository.UsuarioRepository;
import com.Brafe.Brafe.domain.entity.EnderecoEntity;
import com.Brafe.Brafe.domain.entity.ProdutoEntity;
import com.Brafe.Brafe.domain.entity.UsuarioEntity;
import com.Brafe.Brafe.port.in.UsuarioCorePort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MockController {
    private final UsuarioRepository usuarioRepository;
    private final EnderecoRepository enderecoRepository;
    private final ProdutoRepository produtoRepository;

    @GetMapping("/test")
    public void test() {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setCpf("12345678910");
        usuarioEntity.setEmail("matheus@test.com");
        usuarioEntity.setPassword("123456");
        usuarioEntity.setNomeCompleto("Matheus do Prado Marques da Costa");
        UsuarioEntity usuarioSalvo = usuarioRepository.save(usuarioEntity);

        EnderecoEntity enderecoEntity = new EnderecoEntity();
        enderecoEntity.setRua("Testando a rua!");
        enderecoEntity.setNumero(123);
        enderecoEntity.setBairro("Centro");
        enderecoEntity.setComplemento("Casa");
        enderecoEntity.setCep("12345-123");
        enderecoEntity.setUsuario(usuarioSalvo);
        enderecoRepository.save(enderecoEntity);

        List<ProdutoEntity> list = new ArrayList<>();
        ProdutoEntity produto = new ProdutoEntity();
        produto.setDescricao("test");
        produto.setNome("test");
        produto.setPreco(5.0);
        produto.setQuantidade(5);
        produto.setImagem("img/cafe-5.jpg");
        list.add(produto);

        ProdutoEntity produto2 = new ProdutoEntity();
        produto2.setDescricao("test2");
        produto2.setNome("test2");
        produto2.setPreco(10.0);
        produto2.setQuantidade(10);
        produto2.setImagem("img/cafe-6.jpg");
        list.add(produto2);

        produtoRepository.saveAll(list);
    }
}