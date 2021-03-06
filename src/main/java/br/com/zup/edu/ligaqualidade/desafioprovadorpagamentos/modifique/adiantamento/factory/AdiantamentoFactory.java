package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.adiantamento.factory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.AdiantamentoDTO;

public class AdiantamentoFactory implements AbstractFactory<AdiantamentoDTO> {

	private static final Pattern pattern = Pattern.compile(",");

	private static final AdiantamentoFactory instance;

	private AdiantamentoFactory() {
	}

	static {
		instance = new AdiantamentoFactory();
	}

	public static AdiantamentoFactory getInstance() {
		return instance;
	}

	@Override
	public List<AdiantamentoDTO> create(List<String> listAdiantamentos) {
		List<AdiantamentoDTO> adiantamentos = new ArrayList<>();

		listAdiantamentos.stream().forEach(row -> {
			String[] line = pattern.split(row);
			adiantamentos.add(new AdiantamentoDTO(Long.valueOf(line[0]), new BigDecimal(line[1])));
		});

		return adiantamentos;
	}

}