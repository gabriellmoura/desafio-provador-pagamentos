package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.exceptions.TransacaoNaoSuportada;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosTransacao;

public class RecebivelFactory {
    private RecebivelFactory() {}

    private static final RecebivelFactory instance;

    static {
        instance = new RecebivelFactory();
    }

    public static RecebivelFactory getInstance() {
        return instance;
    }

    public List<Recebivel> criar(List<DadosTransacao> transacoes) {
        final List<Recebivel> recebiveis = new ArrayList<>();
        for (DadosTransacao transacao : transacoes) {
            Recebivel recebivel = criar(transacao);
            recebiveis.add(recebivel);
        }

        return recebiveis;
    }

    private Recebivel criar(DadosTransacao transacao) {

        if (transacao.metodoEhDebito()) {
			return new Recebivel(StatusRecebivel.PAGO, LocalDate.now(), transacao.valor, TaxaTransacao.DEBITO.value());
        } else if (transacao.metodoEhCredito()) {
			return new Recebivel(StatusRecebivel.AGUARDANDO_LIBERACAO_FUNDOS, LocalDate.now().plusDays(30), //
					transacao.valor, TaxaTransacao.CREDITO.value());
        }
		throw new TransacaoNaoSuportada(
				new StringJoiner("").add("Não foi possível criar um recebível para esse transação (")//
						.add(transacao.toString())//
						.add(")").toString());
    }
}
