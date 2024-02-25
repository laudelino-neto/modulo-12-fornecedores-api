package br.com.unicesumar.modulo12.application.core.exception;

public class AtributoObrigatorioException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public AtributoObrigatorioException(String mensagem) {
		super(mensagem);
	}

}
