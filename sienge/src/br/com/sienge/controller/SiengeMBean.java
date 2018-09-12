package br.com.sienge.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import br.com.sienge.entidade.Transporte;

@ManagedBean
@RequestScoped
public class SiengeMBean {

	private List<SelectItem> listaVeiculo;

	private Transporte novoTransporte;

	@PostConstruct
	/** Método para inicialização de objetos de tela e objeto principal Transporte. */
	public void init() {
		// Cria novo objeto Transporte.
		this.novoTransporte = new Transporte();
		// Cria a Lista de Veiculos.
		if (this.listaVeiculo == null) {
			this.listaVeiculo = new ArrayList<SelectItem>();
			this.listaVeiculo.add(new SelectItem("A", "Caminhão baú"));
			this.listaVeiculo.add(new SelectItem("B", "Caminhão caçamba"));
			this.listaVeiculo.add(new SelectItem("C", "Carreta"));
		}
	}

	/** Ação que controla o calculo do Transporte */
	public void calcular() {
		if (this.getNovoTransporte() != null) {
			Double custoPavimento = 0d;
			Double custoNaoPavimento = 0d;
			Double fatorMultiplicador = 0d;
			Double custoTotal = 0d;
			//Calcula o custo de trecho pavimentado.
			if (this.getNovoTransporte().getDistanciaRodoviaPavimentada() != null) {
				custoPavimento = 0.54 * this.getNovoTransporte().getDistanciaRodoviaPavimentada().doubleValue();
			} else {
				this.getNovoTransporte().setDistanciaRodoviaPavimentada(0l);
			}
			//Calcula o custo de trecho não pavimentado.
			if (this.getNovoTransporte().getDistanciaRodoviaNaoPavimentada() != null) {
				custoNaoPavimento = 0.62 * this.getNovoTransporte().getDistanciaRodoviaNaoPavimentada().doubleValue();
			} else {
				this.getNovoTransporte().setDistanciaRodoviaNaoPavimentada(0l);
			}
			// Fator multiplicador por veiculo;
			if (this.getNovoTransporte().getVeiculo() != null) {
				fatorMultiplicador = this.custoPorveiculo(this.getNovoTransporte().getVeiculo());
			}
			// Calcula inicialmente o valor total do transporte.
			custoTotal = (custoPavimento + custoNaoPavimento) * fatorMultiplicador;
			// Verifica se peso ultrapassa as 5 toneladas, se sim continuar calculando o
			// valor total do transporte por tonelada e km rodado.
			if (this.getNovoTransporte().getCarga() != null && this.getNovoTransporte().getCarga() > 5) {
				Double valoExecedente = 0d;
				Long km = this.getNovoTransporte().getDistanciaRodoviaPavimentada() + this.getNovoTransporte().getDistanciaRodoviaNaoPavimentada();
				Long cargaExecedente = this.getNovoTransporte().getCarga() - 5;
				valoExecedente = km * 0.02 * cargaExecedente;
				custoTotal += valoExecedente;
			}
			// Define o valor total do transporte.
			this.getNovoTransporte().setCustoTransporte(new BigDecimal(custoTotal).setScale(2, RoundingMode.HALF_EVEN));
		} else {
			this.limpar();
		}
	}

	/** Define o fator multiplicador por tipo de Veículo */
	public Double custoPorveiculo(String tipoVeiculo) {
		if (tipoVeiculo.equals("A")) {
			return 1.00;
		} else if (tipoVeiculo.equals("B")) {
			return 1.05;
		} else {
			return 1.12;
		}
	}
	
	/** Ação que limpa os campos do formulario.*/
	public void limpar() {
		this.setNovoTransporte(null);
	}

	public Transporte getNovoTransporte() {
		return novoTransporte;
	}

	public void setNovoTransporte(Transporte novoTransporte) {
		this.novoTransporte = novoTransporte;
	}

	public List<SelectItem> getListaVeiculo() {
		return listaVeiculo;
	}

	public void setListaVeiculo(List<SelectItem> listaVeiculo) {
		this.listaVeiculo = listaVeiculo;
	}

}