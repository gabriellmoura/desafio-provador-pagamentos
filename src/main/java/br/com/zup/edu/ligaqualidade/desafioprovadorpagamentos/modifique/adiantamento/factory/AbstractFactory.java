package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.adiantamento.factory;

import java.util.List;

public interface AbstractFactory<T> {

	List<T> create(List<String> row);
}
