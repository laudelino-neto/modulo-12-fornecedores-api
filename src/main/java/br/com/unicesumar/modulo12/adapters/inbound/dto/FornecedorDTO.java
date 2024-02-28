package br.com.unicesumar.modulo12.adapters.inbound.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FornecedorDTO {
	
	@EqualsAndHashCode.Include
	private Integer id;
	
	private String razaoSocial;
	
	private String nomeFantasia;
	
	private String cnpj;

}
