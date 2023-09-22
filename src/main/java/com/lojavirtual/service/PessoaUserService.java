package com.lojavirtual.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lojavirtual.model.PessoaJuridica;
import com.lojavirtual.model.Usuario;
import com.lojavirtual.repository.PessoaRepository;
import com.lojavirtual.repository.UsuarioRepository;

@Service
public class PessoaUserService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public PessoaJuridica salvarPessoaJuridica(PessoaJuridica pessoaJuridica) {

		pessoaJuridica = pessoaRepository.save(pessoaJuridica);

		Usuario usuarioPj = usuarioRepository.findUserByPessoaPj(pessoaJuridica.getId(), pessoaJuridica.getEmail());
		/*
		 * manipulação do cod para remover restrição de constraint estava sendo gerada e
		 * não pode ter no BD. Banco gera uma chave ao executar o JPA "UNIQUE" na coluna
		 * de acesso (Usuario_acesso), se tiver a chave no banco pode causar erro ao
		 * salvar. CONSTRAINT unique_acesso_user UNIQUE(usuario_id, acesso_id)
		 */
		
		/*
		 * O comando BEGIN inicia um bloco de transação, ou seja, todos os comandos após
		 * o comando BEGIN serão executados em uma única transação, até que seja
		 * fornecido um comando COMMIT ou ROLLBACK explícito.
		 */
		if (usuarioPj == null) {
			
			String constraint = usuarioRepository.consultaConstraintAcesso();
			if (constraint != null) {
				jdbcTemplate.execute("begin; alter table usuarios_acesso drop constraint " + constraint + "; commit;");
			}

			usuarioPj = new Usuario();
			usuarioPj.setDataAtualSenha(Calendar.getInstance().getTime());
			usuarioPj.setEmpresa(pessoaJuridica);
			usuarioPj.setPessoa(pessoaJuridica);
			usuarioPj.setLogin(pessoaJuridica.getEmail());

			String senha = "" + Calendar.getInstance().getTimeInMillis();
			String senhaCript = new BCryptPasswordEncoder().encode(senha);

			usuarioPj.setSenha(senhaCript);
			usuarioPj = usuarioRepository.save(usuarioPj);

			usuarioRepository.insereAcessoUserPj(usuarioPj.getId());

		}
		return pessoaJuridica;
	}

}
