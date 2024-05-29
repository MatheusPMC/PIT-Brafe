
package com.Brafe.Brafe.adapter.in.controller;

import com.Brafe.Brafe.adapter.in.model.Login;
import com.Brafe.Brafe.adapter.in.model.Usuario;
import com.Brafe.Brafe.adapter.out.repository.*;
import com.Brafe.Brafe.domain.entity.*;
import com.Brafe.Brafe.port.in.UsuarioCorePort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MockController {
    private final UsuarioRepository usuarioRepository;
    private final EnderecoRepository enderecoRepository;
    private final ProdutoRepository produtoRepository;
    private final PagamentoRepository pagamentoRepository;
    private final CompraRepository compraRepository;

    @GetMapping("/test")
    public void test() {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setCpf("123456123");
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
        EnderecoEntity enderecoS = enderecoRepository.save(enderecoEntity);

        List<ProdutoEntity> list = new ArrayList<>();
        ProdutoEntity produto = new ProdutoEntity();
        produto.setId(1L);
        produto.setDescricao("test");
        produto.setNome("test");
        produto.setPreco(5.0);
        produto.setQuantidade(5);
        produto.setImagem("img/cafe-5.jpg");
        list.add(produto);

        ProdutoEntity produto2 = new ProdutoEntity();
        produto2.setId(2L);
        produto2.setDescricao("test2");
        produto2.setNome("test2");
        produto2.setPreco(10.0);
        produto2.setQuantidade(10);
        produto2.setImagem("img/cafe-6.jpg");
        list.add(produto2);

        ProdutoEntity produto3 = new ProdutoEntity();
        produto3.setId(3L);
        produto3.setDescricao("test3");
        produto3.setNome("test3");
        produto3.setPreco(20.0);
        produto3.setQuantidade(2);
        produto3.setImagem("img/cafe-4.jpg");
        list.add(produto3);

        ProdutoEntity produto4 = new ProdutoEntity();
        produto4.setId(4L);
        produto4.setDescricao("test4");
        produto4.setNome("test4");
        produto4.setPreco(30.0);
        produto4.setQuantidade(3);
        produto4.setImagem("img/cafe-3.jpg");
        list.add(produto4);

        List<ProdutoEntity> produtoS = produtoRepository.saveAll(list);

        Set<ProdutoEntity> produtoSet = new HashSet<ProdutoEntity>(produtoS);
        PagamentoEntity pagamentoEntity = new PagamentoEntity();
        pagamentoEntity.setCpf("123456789");
        pagamentoEntity.setCvv(123);
        pagamentoEntity.setDataExpiracao("0102");
        pagamentoEntity.setNumeroCartao("1234123412341234");
        pagamentoEntity.setDataExpiracao("07/06");
        pagamentoEntity.setNomeCompleto("Matheus");

        PagamentoEntity pagamentoS = pagamentoRepository.save(pagamentoEntity);
        CompraEntity compraEntity = new CompraEntity();
        compraEntity.setEndereco(enderecoS);
        compraEntity.setUsuario(usuarioSalvo);
        compraEntity.setPagamento(pagamentoS);
        compraEntity.setProdutos(produtoSet);
        compraEntity.setValor(40.0);
        compraEntity.setFrete(10.0);
        compraEntity.setValorTotal(50.0);

        compraRepository.save(compraEntity);

    }
}