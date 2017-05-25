package v2v1.representation;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import v2v1.entity.Parcelamento;

public class ParcelamentoRepresentation extends ResourceSupport {

	@JsonInclude(Include.NON_NULL)
	private Long identifier;
	@JsonInclude(Include.NON_NULL)
	private int dia;
	@JsonInclude(Include.NON_NULL)
	private String descricao;
	@JsonInclude(Include.NON_NULL)
	private String mes;
	@JsonInclude(Include.NON_NULL)
	private int ano;
	@JsonInclude(Include.NON_NULL)
	private int quantParcelas;
	@JsonInclude(Include.NON_NULL)
	private int valorParcela;

	public ParcelamentoRepresentation() {
		super();
	}

	public ParcelamentoRepresentation(Parcelamento parcelamento) {
		this.identifier = parcelamento.getId();
		this.dia = parcelamento.getDia();
		this.descricao = parcelamento.getDescricao();
		this.mes = parcelamento.getMes();
		this.ano = parcelamento.getAno();
		this.quantParcelas = parcelamento.getQuantParcelas();
		this.valorParcela = parcelamento.getValorParcela();
	}

	public static Parcelamento build(ParcelamentoRepresentation parcelamentoRepresentation) {
		Parcelamento parcelamento = new Parcelamento();
		parcelamento.setId(parcelamentoRepresentation.getIdentifier());
		parcelamento.setDia(parcelamentoRepresentation.getDia());
		parcelamento.setDescricao(parcelamentoRepresentation.getDescricao());
		parcelamento.setMes(parcelamentoRepresentation.getMes());
		parcelamento.setAno(parcelamentoRepresentation.getAno());
		parcelamento.setQuantParcelas(parcelamentoRepresentation.getQuantParcelas());
		parcelamento.setValorParcela(parcelamentoRepresentation.getValorParcela());

		return parcelamento;
	}

	public Long getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Long identifier) {
		this.identifier = identifier;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getQuantParcelas() {
		return quantParcelas;
	}

	public void setQuantParcelas(int quantParcelas) {
		this.quantParcelas = quantParcelas;
	}

	public int getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(int valorParcela) {
		this.valorParcela = valorParcela;
	}

}
