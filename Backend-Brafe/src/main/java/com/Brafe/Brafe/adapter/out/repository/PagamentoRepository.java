package com.Brafe.Brafe.adapter.out.repository;

import com.Brafe.Brafe.domain.entity.PagamentoEntity;
import com.Brafe.Brafe.domain.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PagamentoRepository extends JpaRepository<PagamentoEntity, Long> {
}