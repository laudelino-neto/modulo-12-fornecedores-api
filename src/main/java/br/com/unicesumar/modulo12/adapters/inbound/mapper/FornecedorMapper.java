package br.com.unicesumar.modulo12.adapters.inbound.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import br.com.unicesumar.modulo12.adapters.inbound.dto.FornecedorDTO;
import br.com.unicesumar.modulo12.adapters.inbound.entity.FornecedorEntity;
import br.com.unicesumar.modulo12.application.core.domain.Fornecedor;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Component
@Valid
public class FornecedorMapper {

	public Fornecedor toDomain(
			@NotNull(message = "O dto é obrigatório")
			FornecedorDTO dto) {
		Fornecedor domain = new Fornecedor();
		BeanUtils.copyProperties(dto, domain);
		return domain;
	}
	
	public Fornecedor toDomain(
			@NotNull(message = "A entidade é obrigatória")
			FornecedorEntity entity) {
		Fornecedor domain = new Fornecedor();
		BeanUtils.copyProperties(entity, domain);
		return domain;
	}
	
	public FornecedorEntity toEntity(
			@NotNull(message = "O domínio é obrigatório")
			Fornecedor domain) {
		FornecedorEntity entity = new FornecedorEntity();
		BeanUtils.copyProperties(domain, entity);
		return entity;
	}

}
