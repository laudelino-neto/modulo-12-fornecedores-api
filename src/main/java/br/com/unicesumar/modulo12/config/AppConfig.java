package br.com.unicesumar.modulo12.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.unicesumar.modulo12.adapters.outbound.data.FornecedorCrudAdapter;
import br.com.unicesumar.modulo12.application.core.service.FornecedorService;

@Configuration
public class AppConfig {

	@Bean
	public FornecedorService fornecedorService(FornecedorCrudAdapter fornecedorCrudAdapter) {
		return new FornecedorService(fornecedorCrudAdapter);
	}
	
}
