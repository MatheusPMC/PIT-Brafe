package com.Brafe.Brafe.adapter.out.repository;

import com.Brafe.Brafe.domain.entity.CompraEntity;
import com.Brafe.Brafe.domain.entity.PagamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CompraRepository extends JpaRepository<CompraEntity, Long> {
}