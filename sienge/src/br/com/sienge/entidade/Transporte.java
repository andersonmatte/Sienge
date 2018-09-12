package br.com.sienge.entidade;

import java.math.BigDecimal;

public class Transporte {
	
	private Long distanciaRodoviaPavimentada;
	
	private Long distanciaRodoviaNaoPavimentada;

	private String veiculo;

	private Long carga;
	
	private BigDecimal custoTransporte;
	
	public Long getDistanciaRodoviaPavimentada() {
		return distanciaRodoviaPavimentada;
	}

	public void setDistanciaRodoviaPavimentada(Long distanciaRodoviaPavimentada) {
		this.distanciaRodoviaPavimentada = distanciaRodoviaPavimentada;
	}

	public Long getDistanciaRodoviaNaoPavimentada() {
		return distanciaRodoviaNaoPavimentada;
	}

	public void setDistanciaRodoviaNaoPavimentada(Long distanciaRodoviaNaoPavimentada) {
		this.distanciaRodoviaNaoPavimentada = distanciaRodoviaNaoPavimentada;
	}

	public String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}
	
	public Long getCarga() {
		return carga;
	}

	public void setCarga(Long carga) {
		this.carga = carga;
	}

	public BigDecimal getCustoTransporte() {
		return custoTransporte;
	}

	public void setCustoTransporte(BigDecimal custoTransporte) {
		this.custoTransporte = custoTransporte;
	}
	
}