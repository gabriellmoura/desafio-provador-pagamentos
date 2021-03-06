package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosTransacao;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.MetodoPagamento;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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

    /**
     *
     * @param infoTransacoes
     *  dados das transações. A String está formatada da seguinte maneira:
     * 	<b>"valor,metodoPagamento,numeroCartao,nomeCartao,validade,cvv,idTransacao"</b>
     * @return DadosTransacao
     */
    public List<DadosTransacao> criar(List<String> infoTransacoes) {
        final List<DadosTransacao> transacoes = new ArrayList<>();
        for (String dados : infoTransacoes) {
            String[] transacoesEmTexto = dados.split(",");
            DadosTransacao transacao = criar(transacoesEmTexto);
            transacoes.add(transacao);
        }

        return transacoes;
    }

    private DadosTransacao criar(String[] transacao) {
        BigDecimal valor = BigDecimal.valueOf(Double.parseDouble(transacao[0]));
        MetodoPagamento metodoPagamento = MetodoPagamento.valueOf(transacao[1]);
        String numero = transacao[2];
        String nome = transacao[3];
        LocalDate validade = LocalDate.parse(transacao[4], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        int cvv = Integer.parseInt(transacao[5]);
        int id = Integer.parseInt(transacao[6]);

        return new DadosTransacao(valor, metodoPagamento, numero, nome, validade, cvv, id);
    }
}
