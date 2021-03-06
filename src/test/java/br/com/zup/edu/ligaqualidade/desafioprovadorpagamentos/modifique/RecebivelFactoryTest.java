package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosTransacao;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.StatusRecebivel.AGUARDANDO_LIBERACAO_FUNDOS;
import static br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.StatusRecebivel.PAGO;
import static br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.MetodoPagamento.CREDITO;
import static br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.MetodoPagamento.DEBITO;
import static org.junit.jupiter.api.Assertions.*;

public class RecebivelFactoryTest {

    private final RecebivelFactory factory = RecebivelFactory.getInstance();

    @Test
    public void deveCriarUmaInstanciaEstaticaDaClasseValida() {
        assertNotNull(factory);
    }

    @Test
    public void deveCriarRecebivelCorretoQuandoOMetodoDePagamentoForDebito() {
        BigDecimal valor = BigDecimal.valueOf(200.0);
        List<Recebivel> recebivel = factory.criar(List.of(new DadosTransacao(
                valor
                , DEBITO,
                "22222",
                "ELIAS",
                LocalDate.now(),
                222,
                2020)));
        assertEquals(0.03, recebivel.get(0).getDesconto());
        assertEquals(PAGO, recebivel.get(0).getStatusRecebivel());
        assertEquals(valor, recebivel.get(0).getValorOriginal());
        assertEquals(valor.multiply(BigDecimal.valueOf(0.03)), recebivel.get(0).getValorASerRecebido());
        assertEquals(LocalDate.now(), recebivel.get(0).getDataRecebimento());
    }

    @Test
    public void deveCriarRecebivelCorretoQuandoOMetodoDePagamentoForCredito() {
        BigDecimal valor = BigDecimal.valueOf(200.0);
        List<Recebivel> recebivel = factory.criar(List.of(new DadosTransacao(
                valor
                , CREDITO,
                "22222",
                "ELIAS",
                LocalDate.now(),
                222,
                2020)));
        assertEquals(0.05, recebivel.get(0).getDesconto());
        assertEquals(AGUARDANDO_LIBERACAO_FUNDOS, recebivel.get(0).getStatusRecebivel());
        assertEquals(valor, recebivel.get(0).getValorOriginal());
        assertEquals(valor.multiply(BigDecimal.valueOf(0.05)), recebivel.get(0).getValorASerRecebido());
        assertEquals(LocalDate.now().plusDays(30), recebivel.get(0).getDataRecebimento());
    }

}