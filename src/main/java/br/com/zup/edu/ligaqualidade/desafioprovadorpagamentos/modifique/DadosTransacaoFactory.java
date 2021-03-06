package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosTransacao;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.MetodoPagamento;

public class DadosTransacaoFactory {
    private DadosTransacaoFactory() {
    }

    private static final DadosTransacaoFactory instance;

    static {
        instance = new DadosTransacaoFactory();
    }

    public static DadosTransacaoFactory getInstance() {
        return instance;
    }

    public List<DadosTransacao> criar(List<String> infoTransacoes) {
        final List<DadosTransacao> transacoes = new ArrayList<>();
		infoTransacoes.stream().forEach(row -> transacoes.add(criar(row.split(","))));
        return transacoes;
    }

    private DadosTransacao criar(String[] transacao) {
		return new DadosTransacao(BigDecimal.valueOf(Double.parseDouble(transacao[0])),
				MetodoPagamento.valueOf(transacao[1]), transacao[2], transacao[3],
				LocalDate.parse(transacao[4], DateTimeFormatter.ofPattern("dd/MM/yyyy")),
				Integer.parseInt(transacao[5]), Integer.parseInt(transacao[6]));
    }
}
