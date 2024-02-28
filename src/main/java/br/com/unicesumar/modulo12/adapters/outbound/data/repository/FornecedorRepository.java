package br.com.unicesumar.modulo12.adapters.outbound.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.unicesumar.modulo12.adapters.inbound.entity.FornecedorEntity;

public interface FornecedorRepository 
	extends JpaRepository<FornecedorEntity, Integer>{
	
	@Query(value = 
			"SELECT f "
			+ "FROM Fornecedor f "
			+ "WHERE Upper(f.nomeFantasia) LIKE Upper(:nomeFantasia) ")
	public List<FornecedorEntity> listarPor(String nomeFantasia);
	
	@Query(value = 
			"SELECT f "
			+ "FROM Fornecedor f "
			+ "WHERE f.id = :id ")
	public FornecedorEntity buscarPor(Integer id);

}
