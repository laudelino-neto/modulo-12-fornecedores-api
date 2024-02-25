package br.com.unicesumar.modulo12.application.core.domain;

import java.util.Objects;

import br.com.unicesumar.modulo12.application.core.exception.AtributoObrigatorioException;

public class Fornecedor {

	private Integer id;
	
	private String razaoSocial;
	
	private String nomeFantasia;
	
	private String cnpj;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {

		if (razaoSocial == null || razaoSocial.isBlank()) {
			throw new AtributoObrigatorioException("A razão social é obrigatória");
		}

		this.razaoSocial = razaoSocial;

	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {

		if (nomeFantasia == null || nomeFantasia.isBlank()) {
			throw new AtributoObrigatorioException("O nome fantasia é obrigatório");
		}
		
		this.nomeFantasia = nomeFantasia;

	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		
		if (cnpj == null || cnpj.isBlank()) {
			throw new AtributoObrigatorioException("O cnpj é obrigatório");
		}
		
		this.cnpj = cnpj;
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		return Objects.equals(id, other.id);
	}

}
