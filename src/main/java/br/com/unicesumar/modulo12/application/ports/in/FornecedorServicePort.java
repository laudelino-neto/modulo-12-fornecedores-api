package br.com.unicesumar.modulo12.application.ports.in;

import java.util.List;

import br.com.unicesumar.modulo12.application.core.domain.Fornecedor;

public interface FornecedorServicePort {

	public Fornecedor salvar(Fornecedor fornecedor);
	
	public List<Fornecedor> listarPor(String nome);
	
	public Fornecedor buscarPor(Integer id);
	
	public Fornecedor removerPor(Integer id);
	
}
