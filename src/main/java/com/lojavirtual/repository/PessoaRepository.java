package com.lojavirtual.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lojavirtual.model.PessoaJuridica;

/*Repository para consultar no banco se existe pessoa cadastrada com o CNPJ digitado pelo usuario*/
@Repository
public interface PessoaRepository extends JpaRepository<PessoaJuridica, Long> {
 
	@Query(value = "select pj from PessoaJuridica pj where pj.cnpj = ?1")
	public PessoaJuridica existeCnpjCadastrado(String cnpj);
}
