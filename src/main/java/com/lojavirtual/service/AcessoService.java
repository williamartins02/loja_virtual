package com.lojavirtual.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lojavirtual.model.Acesso;
import com.lojavirtual.repository.AcessoRepository;

@Service
public class AcessoService {
	
	
	@Autowired
	private AcessoRepository acessoRepository;
	
	
	public Acesso save(Acesso acesso) {
		
		return acessoRepository.save(acesso);
	}


}
