package br.com.unicesumar.modulo12.adapters.inbound.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import br.com.unicesumar.modulo12.adapters.inbound.dto.FornecedorDTO;
import br.com.unicesumar.modulo12.adapters.inbound.entity.FornecedorEntity;
import br.com.unicesumar.modulo12.application.core.domain.Fornecedor;
import jakarta.validation.constraints.NotNull;

@Component
@Validated
public class FornecedorMapper {

	public Fornecedor toDomain(FornecedorDTO dto) {
		Fornecedor domain = new Fornecedor();
		BeanUtils.copyProperties(dto, domain);
		return domain;			
	}
	
	public Fornecedor toDomain(
			@NotNull(message = "A entidade (FornecedorEntity) não pode ser nula")
			FornecedorEntity entity) {
		Fornecedor domain = new Fornecedor();
		BeanUtils.copyProperties(entity, domain);
		return domain;
	}
	
	public FornecedorEntity toEntity(Fornecedor domain) {
		FornecedorEntity entity = new FornecedorEntity();
		BeanUtils.copyProperties(domain, entity);
		return entity;
	}
	
}
