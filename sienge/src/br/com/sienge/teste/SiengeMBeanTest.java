package br.com.sienge.teste;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

import br.com.sienge.controller.SiengeMBean;
import br.com.sienge.entidade.Transporte;

public class SiengeMBeanTest {
	
	private static SiengeMBean siengeMBean;
	
	private Transporte novoTransporte;
	
	public static void main(String[] args) {
		siengeMBean = new SiengeMBean();
		calculaValorCaminhaoBau();
		calculaValorCacamba();
		carreta();
	}
	
	public static void calculaValorCaminhaoBau() {
		Transporte transporteBau = new Transporte();
		transporteBau.setVeiculo("A");
		transporteBau.setDistanciaRodoviaPavimentada(10l);
		transporteBau.setDistanciaRodoviaNaoPavimentada(70l);
		transporteBau.setCarga(6l);
		BigDecimal retorno = calcular(transporteBau);
		NumberFormat nf = NumberFormat.getCurrencyInstance();  
		String formatado = nf.format (retorno);
		System.out.println("O custo do transporte para calculaValorCaminhaoBau é: " + formatado);
	}
	
	public static void calculaValorCacamba() {
		Transporte transporteCacamba = new Transporte();		
		transporteCacamba.setVeiculo("B");
		transporteCacamba.setDistanciaRodoviaPavimentada(80l);
		transporteCacamba.setDistanciaRodoviaNaoPavimentada(50l);
		transporteCacamba.setCarga(3l);
		BigDecimal retorno = calcular(transporteCacamba);
		NumberFormat nf = NumberFormat.getCurrencyInstance();  
		String formatado = nf.format (retorno);
		System.out.println("O custo do transporte para calculaValorCacamba é: " + formatado);
	}
	
	public static void carreta() {
		Transporte transporteCarreta = new Transporte();
		transporteCarreta.setVeiculo("C");
		transporteCarreta.setDistanciaRodoviaPavimentada(40l);
		transporteCarreta.setDistanciaRodoviaNaoPavimentada(20l);
		transporteCarreta.setCarga(9l);
		BigDecimal retorno = calcular(transporteCarreta);
		NumberFormat nf = NumberFormat.getCurrencyInstance();  
		String formatado = nf.format (retorno);
		System.out.println("O custo do transporte para carreta é: " + formatado);
	}
	
	/**
	 * Método para teste, mesmos calculos da Classe SiengeMBean, somente assinatura
	 * e retorno foram alterados
	 */
	public static BigDecimal calcular(Transporte transporteRecebido) {
		if (transporteRecebido != null) {
			Double custoPavimento = 0d;
			Double custoNaoPavimento = 0d;
			Double fatorMultiplicador = 0d;
			Double custoTotal = 0d;
			//Calcula o custo de trecho pavimentado.
			if (transporteRecebido.getDistanciaRodoviaPavimentada() != null) {
				custoPavimento = 0.54 * transporteRecebido.getDistanciaRodoviaPavimentada().doubleValue();
			} else {
				transporteRecebido.setDistanciaRodoviaPavimentada(0l);
			}
			//Calcula o custo de trecho não pavimentado.
			if (transporteRecebido.getDistanciaRodoviaNaoPavimentada() != null) {
				custoNaoPavimento = 0.62 * transporteRecebido.getDistanciaRodoviaNaoPavimentada().doubleValue();
			} else {
				transporteRecebido.setDistanciaRodoviaNaoPavimentada(0l);
			}
			// Fator multiplicador por veiculo;
			if (transporteRecebido.getVeiculo() != null) {
				//Reaproveita método que calcula o Fator Multiplicador.
				fatorMultiplicador = siengeMBean.custoPorveiculo(transporteRecebido.getVeiculo());
			}
			// Calcula inicialmente o valor total do transporte.
			custoTotal = (custoPavimento + custoNaoPavimento) * fatorMultiplicador;
			// Verifica se peso ultrapassa as 5 toneladas, se sim continuar calculando o
			// valor total do transporte por tonelada e km rodado.
			if (transporteRecebido.getCarga() != null && transporteRecebido.getCarga() > 5) {
				Double valoExecedente = 0d;
				Long km = transporteRecebido.getDistanciaRodoviaPavimentada() + transporteRecebido.getDistanciaRodoviaNaoPavimentada();
				Long cargaExecedente = transporteRecebido.getCarga() - 5;
				valoExecedente = km * 0.02 * cargaExecedente;
				custoTotal += valoExecedente;
			}
			// Define o valor total do transporte.
			transporteRecebido.setCustoTransporte(new BigDecimal(custoTotal).setScale(2, RoundingMode.HALF_EVEN));
		} 
		return transporteRecebido.getCustoTransporte();
	}
	
	public Transporte getNovoTransporte() {
		return novoTransporte;
	}

	public void setNovoTransporte(Transporte novoTransporte) {
		this.novoTransporte = novoTransporte;
	}

}