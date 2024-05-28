package com.Brafe.Brafe.port.in;

import com.Brafe.Brafe.adapter.in.model.Produto;
import com.Brafe.Brafe.adapter.in.model.Usuario;

import java.util.List;

public interface ProdutoCorePort {
    List<Produto> buscarProdutos();

    Produto criarProduto(Produto produto);
}