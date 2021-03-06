package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.validators;

import java.util.List;
import java.util.stream.Collectors;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.AdiantamentoDTO;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.Recebivel;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.StatusRecebivel;

public class AdiantamentoValidator {

	public List<Recebivel> validate(List<AdiantamentoDTO> adiantamentos, List<Recebivel> recebiveis) {
		List<Recebivel> receivableByWaitingLiberation = filterReceivableByStatusWaitingLiberation(recebiveis);

		if (receivableByWaitingLiberation != null && !receivableByWaitingLiberation.isEmpty()) {
			adiantamentos.stream().forEach(adiantamento -> {
//				if (adiantamento.getIdTransacao().equals(obj))
			});
		}

		return receivableByWaitingLiberation;
	}

	private List<Recebivel> filterReceivableByStatusWaitingLiberation(List<Recebivel> recebiveis) {
		return recebiveis.stream()
				.filter(r -> r.getStatusRecebivel().equals(StatusRecebivel.AGUARDANDO_LIBERACAO_FUNDOS))
				.collect(Collectors.toList());
	}
}