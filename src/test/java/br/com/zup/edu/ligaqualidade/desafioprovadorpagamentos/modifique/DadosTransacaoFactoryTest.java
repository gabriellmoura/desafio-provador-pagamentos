package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosTransacao;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.MetodoPagamento;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DadosTransacaoFactoryTest {

    private final DadosTransacaoFactory factory = DadosTransacaoFactory.getInstance();

    @Test
    public void deveCriarUmaInstanciaEstaticaDaClasseValida() {
        assertNotNull(factory);
    }

    @Test
    public void deveCriarDadosTransacaoQuandoOsDadosForemvalidos() {
        List<DadosTransacao> transacaoCriada = factory.criar(List.of("200.0,CREDITO,22222,ELIAS,01/12/2022,222,202020"));
        List<DadosTransacao> transacaoEsperada = List.of(new DadosTransacao(BigDecimal.valueOf(200.0), MetodoPagamento.CREDITO, "22222", "ELIAS", LocalDate.of(2022, 12, 1), 222, 202020));
        assertEquals(transacaoEsperada.get(0).valor, transacaoCriada.get(0).valor);
        assertEquals(transacaoEsperada.get(0).metodo, transacaoCriada.get(0).metodo);
        assertEquals(transacaoEsperada.get(0).numero, transacaoCriada.get(0).numero);
        assertEquals(transacaoEsperada.get(0).nome, transacaoCriada.get(0).nome);
        assertEquals(transacaoEsperada.get(0).validade, transacaoCriada.get(0).validade);
        assertEquals(transacaoEsperada.get(0).cvv, transacaoCriada.get(0).cvv);
        assertEquals(transacaoEsperada.get(0).id, transacaoCriada.get(0).id);
    }

    @Test
    public void naoDeveCriarDadosTransacaoQuandoOsDadosNaoForemvalidos() {
        try {
            factory.criar(List.of("invalid", "CREDITO", "22222", "ELIAS", "01/12/2022", "222", "202020"));
            fail();
        } catch (Exception ignored) {}
    }

}