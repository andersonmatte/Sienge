package br.com.teste2.mbean;

import java.util.Iterator;
import java.util.List;

public class GeradorObservacao {

	// Textos pré-definidos.
	public static final String NOTA_PADRAO_TEXTO = "Fatura da nota fiscal de simples remessa: ";
	public static final String NOTAS_PADRAO_TEXTO = "Fatura das notas fiscais de simples remessa: ";

	/**
	 * Gera observações, com texto pre-definido, incluindo os números, das notas
	 * fiscais, recebidos no parâmetro.
	 */
	public String geraObservacao(List<Integer> lista) {
		if (!lista.isEmpty()) {
			String separador = "";
			StringBuilder cod = new StringBuilder();
			// Acha e define o separador entre os parâmetros recebidos.
			for (Iterator<Integer> iterator = lista.iterator(); iterator.hasNext();) {
				Integer c = iterator.next();
				if (cod.toString() == null || cod.toString().length() <= 0) {
					separador = "";
				} else if (iterator.hasNext()) {
					separador = ", ";
				} else {
					separador = " e ";
				}
				cod.append(separador + c);
			}
			// Se na lista tiver mais de dois parametros muda a mensagem de retorno.
			if (cod.toString().contains(",") || cod.toString().contains("e")) {
				return NOTAS_PADRAO_TEXTO + cod + ".";
			}
			return NOTA_PADRAO_TEXTO + cod + ".";
		}
		return "";
	}

}