package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Recebivel {
    private final StatusRecebivel statusRecebivel;
    private final LocalDate dataRecebimento;
    private final BigDecimal valorOriginal;
    private final BigDecimal valorASerRecebido;
	private final BigDecimal desconto;

	public Recebivel(StatusRecebivel statusRecebivel, LocalDate dataRecebimento, //
			BigDecimal valorOriginal, BigDecimal desconto) {
        this.statusRecebivel = statusRecebivel;
        this.dataRecebimento = dataRecebimento;
        this.valorOriginal = valorOriginal;
		this.valorASerRecebido = valorOriginal.multiply(desconto);
        this.desconto = desconto;
    }

    public StatusRecebivel getStatusRecebivel() {
        return statusRecebivel;
    }

    public LocalDate getDataRecebimento() {
        return dataRecebimento;
    }

    public BigDecimal getValorOriginal() {
        return valorOriginal;
    }

    public BigDecimal getValorASerRecebido() {
        return valorASerRecebido;
    }

	public BigDecimal getDesconto() {
        return desconto;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataRecebimento == null) ? 0 : dataRecebimento.hashCode());
		result = prime * result + ((desconto == null) ? 0 : desconto.hashCode());
		result = prime * result + ((statusRecebivel == null) ? 0 : statusRecebivel.hashCode());
		result = prime * result + ((valorASerRecebido == null) ? 0 : valorASerRecebido.hashCode());
		result = prime * result + ((valorOriginal == null) ? 0 : valorOriginal.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recebivel other = (Recebivel) obj;
		if (dataRecebimento == null) {
			if (other.dataRecebimento != null)
				return false;
		} else if (!dataRecebimento.equals(other.dataRecebimento))
			return false;
		if (desconto == null) {
			if (other.desconto != null)
				return false;
		} else if (!desconto.equals(other.desconto))
			return false;
		if (statusRecebivel != other.statusRecebivel)
			return false;
		if (valorASerRecebido == null) {
			if (other.valorASerRecebido != null)
				return false;
		} else if (!valorASerRecebido.equals(other.valorASerRecebido))
			return false;
		if (valorOriginal == null) {
			if (other.valorOriginal != null)
				return false;
		} else if (!valorOriginal.equals(other.valorOriginal))
			return false;
		return true;
	}

	/**
	 *
	 * @return {status, valorOriginal, valorASerRecebido, data}
	 */
    public String[] toArray() {
        return new String[]{statusRecebivel.name(),
                valorOriginal.toString(),
                valorASerRecebido.toString(),
                dataRecebimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))};
    }
}
