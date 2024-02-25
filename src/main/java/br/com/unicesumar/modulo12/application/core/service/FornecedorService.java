package br.com.unicesumar.modulo12.application.core.service;

import java.util.List;

import br.com.unicesumar.modulo12.application.core.domain.Fornecedor;
import br.com.unicesumar.modulo12.application.core.exception.DominioObrigatorioException;
import br.com.unicesumar.modulo12.application.core.exception.RegistroNaoEncontradoException;
import br.com.unicesumar.modulo12.application.ports.in.FornecedorServicePort;
import br.com.unicesumar.modulo12.application.ports.out.FornecedorCrudPort;

public class FornecedorService implements FornecedorServicePort{

	private FornecedorCrudPort fornecedorCrudPort;

	public FornecedorService(FornecedorCrudPort fornecedorCrudPort) {	
		this.fornecedorCrudPort = fornecedorCrudPort;
	}

	@Override
	public Fornecedor salvar(Fornecedor fornecedor) {
		
		if (fornecedor != null) {
			Fornecedor fornecedorSalvo = fornecedorCrudPort.salvar(fornecedor);			
			return fornecedorSalvo;
		}
		
		throw new DominioObrigatorioException("O fornecedor é obrigatório");		
			
	}

	@Override
	public List<Fornecedor> listarPor(String nome) {
		
		if (nome != null && !nome.isBlank()) {		
			List<Fornecedor> fornecedores = fornecedorCrudPort.listarPor(nome);
			return fornecedores;
		}
		
		throw new IllegalArgumentException("O nome para listagem é obrigatória");
		
	}

	@Override
	public Fornecedor buscarPor(Integer id) {
		
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("O id deve ser positivo");
		}
		
		Fornecedor fornecedorEncontrado = fornecedorCrudPort.buscarPor(id);
		
		if (fornecedorEncontrado == null) {
			throw new RegistroNaoEncontradoException("Não foi encontrado "
					+ "fornecedor vinculado ao id informado");
		}
		
		return fornecedorEncontrado;
		
	}

	@Override
	public Fornecedor removerPor(Integer id) {
		Fornecedor fornecedorEnconrado = buscarPor(id);
		this.fornecedorCrudPort.removerPor(fornecedorEnconrado.getId());
		return fornecedorEnconrado;
	}
		
}
