package com.lojavirtual;

import java.util.Calendar;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import com.lojavirtual.controller.PessoaController;
import com.lojavirtual.model.PessoaJuridica;
import com.lojavirtual.service.exception.ExceptionJava;

import junit.framework.TestCase;

@Profile("test")
@SpringBootTest(classes = LojaVirtualApplication.class)
public class TestePessoaUsuario extends TestCase {

	@Autowired
	private PessoaController pessoaController;

	@Test
	public void testCadPessoaFisica() throws ExceptionJava {

		PessoaJuridica pessoaJuridica = new PessoaJuridica();
		pessoaJuridica.setCnpj("54563644000117" + Calendar.getInstance().getTimeInMillis());
		pessoaJuridica.setNome("Thiago Bruno Eliano da Mata");
		pessoaJuridica.setEmail("thiago@gmail.com");
		pessoaJuridica.setTelefone("11988878428");
		pessoaJuridica.setInscEstadual("709423639755");
		pessoaJuridica.setInscMunicipal("5555");
		pessoaJuridica.setNomeFantasia("Thiago e Filipe Pães e Doces Ltda");
		pessoaJuridica.setRazaoSocial("4656656566");

		pessoaController.salvarPj(pessoaJuridica);

	}

}