package br.com.unicesumar.modulo12.adapters.inbound.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.unicesumar.modulo12.adapters.inbound.dto.FornecedorDTO;
import br.com.unicesumar.modulo12.adapters.inbound.mapper.FornecedorMapper;
import br.com.unicesumar.modulo12.application.core.domain.Fornecedor;
import br.com.unicesumar.modulo12.application.ports.in.FornecedorServicePort;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

	@Autowired
	private FornecedorServicePort fornecedorServicePort;
	
	@Autowired
	private FornecedorMapper mapper;
	
	@PostMapping
	public ResponseEntity<?> inserir(
			@RequestBody
			FornecedorDTO dto){
		
		if (dto.getId() != null) {
			throw new IllegalArgumentException("O fornecedor não pode possuir id");
		}
		
		Fornecedor novoFornecedor = mapper.toDomain(dto);
		
		Fornecedor fornecedorSalvo = fornecedorServicePort.salvar(novoFornecedor);
		
		return ResponseEntity.created(URI.create("/fornecedores/id/" 
				+ fornecedorSalvo.getId())).build();
		
	}
	
	@PutMapping
	public ResponseEntity<?> alterar(
			@RequestBody
			FornecedorDTO dto){
		
		if (dto.getId() == null) {
			throw new IllegalArgumentException("O id do fornecedor é obrigatório");
		}
		
		Fornecedor fornecedor = mapper.toDomain(dto);
		
		Fornecedor fornecedorAlterado = fornecedorServicePort.salvar(fornecedor);
		
		return ResponseEntity.ok(fornecedorAlterado);		
		
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> buscar(
			@PathVariable("id")
			Integer id){
		Fornecedor fornecedorEncontrada = fornecedorServicePort.buscarPor(id);
		return ResponseEntity.ok(fornecedorEncontrada);
	}
	
	@GetMapping
	public ResponseEntity<?> listarPor(
			@RequestParam("nome")
			String nome) {
		List<Fornecedor> fornecedores = fornecedorServicePort.listarPor(nome);
		if (!fornecedores.isEmpty()) {		
			return ResponseEntity.ok(fornecedores);
		}
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/id/{id}")
	public ResponseEntity<?> removerPor(
			@PathVariable("id")
			Integer id){
		Fornecedor fornecedorExcluido = fornecedorServicePort.removerPor(id);
		return ResponseEntity.ok(fornecedorExcluido);
	}
	
}
