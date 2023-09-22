package com.lojavirtual.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lojavirtual.model.Usuario;


/*Repository para consultar usuario no banco de dados..*/
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	@Query(value = "select u from Usuario u where u.login = ?1")
	Usuario findUserByLogin(String login);

	@Query(value = "select u from Usuario u where u.pessoa.id = ?1 or u.login =?2")
	Usuario findUserByPessoaPj(Long id, String email);

	/*SQL puro para identificar a constraint no banco para poder salvar sem erro.*/
	@Query(nativeQuery = true, value = "select constraint_name from information_schema.constraint_column_usage where table_name = "
			+ "'usuarios_acesso' and column_name = 'acesso_id' and constraint_name <> 'unique_acesso_user")
	String consultaConstraintAcesso();

	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "insert into usuarios_acesso(usuario_id, acesso_id) values (?1, (select id from acesso where "
			+ "descricao = 'ROLE_USER'))")
	void insereAcessoUserPj(Long iduser);

}
 