package com.lojavirtual;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lojavirtual.model.Acesso;
import com.lojavirtual.repository.AcessoRepository;
import com.lojavirtual.service.AcessoService;

@SpringBootTest(classes = LojaVirtualApplication.class)
public class LojaVirtualApplicationTests {
	
	@Autowired
	private AcessoService acessoService;
	@Autowired
	private AcessoRepository acessoRepository;

	@Test
	public void testCadastraAcesso() {
		
		Acesso acesso = new Acesso();
		
		acesso.setDescricao("ROLE_ADMIN");
		acesso.setDescricao("ROLE_SECRETARIA");
		
		
		acessoRepository.save(acesso);
	}

	
	
}
