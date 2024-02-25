package br.com.unicesumar.modulo12.application.core.exception;

public class DominioObrigatorioException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public DominioObrigatorioException(String mensagem) {
		super(mensagem);
	}
	
}
