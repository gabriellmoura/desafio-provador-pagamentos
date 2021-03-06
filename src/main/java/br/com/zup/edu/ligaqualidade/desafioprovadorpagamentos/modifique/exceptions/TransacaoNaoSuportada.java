package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.exceptions;

public class TransacaoNaoSuportada extends RuntimeException {

	private static final long serialVersionUID = -897922385889487943L;

	public TransacaoNaoSuportada() {
		super();
	}

	public TransacaoNaoSuportada(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public TransacaoNaoSuportada(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public TransacaoNaoSuportada(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public TransacaoNaoSuportada(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
