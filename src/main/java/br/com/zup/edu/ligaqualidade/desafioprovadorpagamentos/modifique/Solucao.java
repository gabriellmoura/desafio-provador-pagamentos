package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import java.util.List;
import java.util.stream.Collectors;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.adiantamento.factory.AdiantamentoFactory;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosTransacao;

public class Solucao {

	private static final DadosTransacaoFactory dadosTransacaoFactory = DadosTransacaoFactory.getInstance();

	private static final AdiantamentoFactory adiantamentoFactory = AdiantamentoFactory.getInstance();

	public static List<String[]> executa(List<String> infoTransacoes, List<String> infoAdiantamentos) {
		final List<DadosTransacao> transacoes = dadosTransacaoFactory.criar(infoTransacoes);
		final List<AdiantamentoDTO> adiantamentos = adiantamentoFactory.create(infoAdiantamentos);

		RecebivelFactory recebivelFactory = RecebivelFactory.getInstance();
		final List<Recebivel> recebiveis = recebivelFactory.criar(transacoes);

		return recebiveis.stream().map(Recebivel::toArray).collect(Collectors.toList());
	}

}
