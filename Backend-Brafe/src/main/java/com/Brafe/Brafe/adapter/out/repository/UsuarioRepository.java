package com.Brafe.Brafe.adapter.out.repository;

import com.Brafe.Brafe.domain.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    UsuarioEntity findByEmailAndPassword(String email, String password);
}