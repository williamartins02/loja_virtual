package com.lojavirtual;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages = "com.lojavirtual.model")/*anotação para criação de tabelas, se por acaso ñ tiver criando força criação*/
@ComponentScan(basePackages = {"com.*"}) /*Ele procurar por anotações e recurso que estamos ativando com spring boot ele subir as anotações quando ativasr o servidore.*/
@EnableJpaRepositories(basePackages = {"com.lojavirtual.repository"})
@EnableTransactionManagement  /*para genrenciar as transações com banco de dados.*/
public class LojaVirtualApplication {

	public static void main(String[] args) {
		
		
		SpringApplication.run(LojaVirtualApplication.class, args);
	}

}
