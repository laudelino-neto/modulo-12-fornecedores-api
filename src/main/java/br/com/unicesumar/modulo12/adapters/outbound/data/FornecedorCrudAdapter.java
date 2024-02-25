package br.com.unicesumar.modulo12.adapters.outbound.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.unicesumar.modulo12.adapters.inbound.entity.FornecedorEntity;
import br.com.unicesumar.modulo12.adapters.inbound.mapper.FornecedorMapper;
import br.com.unicesumar.modulo12.adapters.outbound.data.repository.FornecedorRepository;
import br.com.unicesumar.modulo12.application.core.domain.Fornecedor;
import br.com.unicesumar.modulo12.application.ports.out.FornecedorCrudPort;

@Component
public class FornecedorCrudAdapter implements FornecedorCrudPort{
	
	@Autowired
	private FornecedorRepository repository;
	
	@Autowired
	private FornecedorMapper mapper;

	@Override
	public Fornecedor salvar(Fornecedor fornecedor) {
		FornecedorEntity entitySalva = repository.save(mapper.toEntity(fornecedor));
		return mapper.toDomain(entitySalva);
	}

	@Override
	public List<Fornecedor> listarPor(String nome) {
		List<FornecedorEntity> entities = repository.listarPor("%" + nome + "%");
		List<Fornecedor> fornecedores = new ArrayList<>();
		for (FornecedorEntity entity : entities) {
			fornecedores.add(mapper.toDomain(entity));
		}
		return fornecedores;
	}

	@Override
	public Fornecedor buscarPor(Integer id) {
		FornecedorEntity entity = repository.buscarPor(id);
		if (entity != null) {		
			return mapper.toDomain(entity);
		}
		return null;
	}

	@Override
	public Fornecedor removerPor(Integer id) {
		Fornecedor fornecedor = buscarPor(id);
		if (fornecedor != null) {		
			this.repository.deleteById(id);
			return fornecedor;
		}
		return null;
	}

}
