package com.lojavirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lojavirtual.model.Acesso;

@Repository
@Transactional //gerenciar as transações do banco...
public interface AcessoRepository extends JpaRepository<Acesso, Long>  {

}
