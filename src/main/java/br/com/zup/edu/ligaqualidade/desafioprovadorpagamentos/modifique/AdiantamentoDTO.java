package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import java.math.BigDecimal;

public class AdiantamentoDTO {

	private Long idTransacao;

	private BigDecimal valor;

	public AdiantamentoDTO(Long idTransacao, BigDecimal valor) {
		this.idTransacao = idTransacao;
		this.valor = valor;
	}

	public Long getIdTransacao() {
		return idTransacao;
	}

	public void setIdTransacao(Long idTransacao) {
		this.idTransacao = idTransacao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}