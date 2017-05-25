package v2v1.representation;

import java.math.BigDecimal;
import java.sql.Date;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import v2v1.entity.Ganho;

public class GanhoRepresentation extends ResourceSupport {

	@JsonInclude(Include.NON_NULL)
	private Long identifier;
	@JsonInclude(Include.NON_NULL)
	private Date data;
	@JsonInclude(Include.NON_NULL)
	private String diaSemana;
	@JsonInclude(Include.NON_NULL)
	private String descricao;
	@JsonInclude(Include.NON_NULL)
	private String sessao;
	@JsonInclude(Include.NON_NULL)
	private BigDecimal pagou;
	@JsonInclude(Include.NON_NULL)
	private BigDecimal deve;

	public GanhoRepresentation() {
		super();
	}

	public GanhoRepresentation(Ganho ganho) {
		this.identifier = ganho.getId();
		this.data = ganho.getData();
		this.diaSemana = ganho.getDiaSemana();
		this.descricao = ganho.getDescricao();
		this.sessao = ganho.getSessao();
		this.pagou = ganho.getPagou();
		this.deve = ganho.getDeve();
	}

	public static Ganho build(GanhoRepresentation ganhoRepresentation) {
		Ganho ganho = new Ganho();
		ganho.setId(ganhoRepresentation.getIdentifier());
		ganho.setData(ganhoRepresentation.getData());
		ganho.setDiaSemana(ganhoRepresentation.getDiaSemana());
		ganho.setDescricao(ganhoRepresentation.getDescricao());
		ganho.setSessao(ganhoRepresentation.getSessao());
		ganho.setPagou(ganhoRepresentation.getPagou());
		ganho.setDeve(ganhoRepresentation.getDeve());

		return ganho;
	}

	public Long getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Long identifier) {
		this.identifier = identifier;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSessao() {
		return sessao;
	}

	public void setSessao(String sessao) {
		this.sessao = sessao;
	}

	public BigDecimal getPagou() {
		return pagou;
	}

	public void setPagou(BigDecimal pagou) {
		this.pagou = pagou;
	}

	public BigDecimal getDeve() {
		return deve;
	}

	public void setDeve(BigDecimal deve) {
		this.deve = deve;
	}

}
