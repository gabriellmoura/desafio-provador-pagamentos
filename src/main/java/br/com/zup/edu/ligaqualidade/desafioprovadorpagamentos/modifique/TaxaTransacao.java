package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import java.math.BigDecimal;

public enum TaxaTransacao {
	
	DEBITO(new BigDecimal(0.03)), CREDITO(new BigDecimal(0.03));
	
	
	private TaxaTransacao(BigDecimal desconto) {
		this.desconto = desconto;
	}

	private BigDecimal desconto;

	public BigDecimal value() {
		return this.desconto;
	}
}
