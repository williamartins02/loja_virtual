package com.lojavirtual.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lojavirtual.model.Acesso;
import com.lojavirtual.service.AcessoService;


@Controller
@RestController
public class AcessoController {
	
	@Autowired
	private AcessoService acessoService;
	
	
	
	@ResponseBody
	@PostMapping(value = "/salvarAcesso") 
	public ResponseEntity<Acesso> salvarAcesso(@RequestBody Acesso acesso) { 
		
		Acesso acessoSalvo = acessoService.save(acesso);
		
		return new ResponseEntity<Acesso>(acessoSalvo, HttpStatus.OK);
	}
	
	
}