package com.lojavirtual.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lojavirtual.model.PessoaJuridica;
import com.lojavirtual.repository.PessoaRepository;
import com.lojavirtual.service.PessoaUserService;
import com.lojavirtual.service.exception.ExceptionJava;

@RestController
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private PessoaUserService pessoaUserService;

	/* end-point é microsservicos é um API */
	/*EndPoint para salvar pessoa juridica. e fazer validação se já existe o CNPJ no banco.*/
	@ResponseBody
	@PostMapping(value = "/salvarPj")
	public ResponseEntity<PessoaJuridica> salvarPj(@RequestBody PessoaJuridica pessoaJuridica) throws ExceptionJava {
         
		if (pessoaJuridica == null) {
			throw new ExceptionJava("Pessoa juridica não pode ser NULL");
		}
		
		if (pessoaJuridica.getId() == null && pessoaRepository.existeCnpjCadastrado(pessoaJuridica.getCnpj()) != null) {
			throw new ExceptionJava("Já existe CNPJ cadastrado com o número: " + pessoaJuridica.getCnpj());
		}
         /*Se for diferente de NULL, e não existir no BD, salvar o CNPJ*/
		pessoaJuridica = pessoaUserService.salvarPessoaJuridica(pessoaJuridica);

		return new ResponseEntity<PessoaJuridica>(pessoaJuridica, HttpStatus.OK);
	}
}
