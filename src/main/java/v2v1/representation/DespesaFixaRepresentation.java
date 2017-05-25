package v2v1.representation;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import v2v1.entity.DespesaFixa;

public class DespesaFixaRepresentation extends ResourceSupport {

	@JsonInclude(Include.NON_NULL)
	private Long identifier;
	@JsonInclude(Include.NON_NULL)
	private int diaPgto;
	@JsonInclude(Include.NON_NULL)
	private String descricao;
	@JsonInclude(Include.NON_NULL)
	private String mes;
	@JsonInclude(Include.NON_NULL)
	private int ano;

	public DespesaFixaRepresentation() {
		super();
	}

	public DespesaFixaRepresentation(DespesaFixa despesaFixa) {
		this.identifier = despesaFixa.getId();
		this.diaPgto = despesaFixa.getDiaPgto();
		this.descricao = despesaFixa.getDescricao();
		this.mes = despesaFixa.getMes();
		this.ano = despesaFixa.getAno();
	}

	public static DespesaFixa build(DespesaFixaRepresentation despesaFixaRepresentation) {
		DespesaFixa despesaFixa = new DespesaFixa();
		despesaFixa.setId(despesaFixaRepresentation.getIdentifier());
		despesaFixa.setDiaPgto(despesaFixaRepresentation.getDiaPgto());
		despesaFixa.setDescricao(despesaFixaRepresentation.getDescricao());
		despesaFixa.setMes(despesaFixaRepresentation.getMes());
		despesaFixa.setAno(despesaFixaRepresentation.getAno());

		return despesaFixa;
	}

	public Long getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Long identifier) {
		this.identifier = identifier;
	}

	public int getDiaPgto() {
		return diaPgto;
	}

	public void setDiaPgto(int diaPgto) {
		this.diaPgto = diaPgto;
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

}
