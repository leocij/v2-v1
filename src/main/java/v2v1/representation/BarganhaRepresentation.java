package v2v1.representation;

import java.math.BigDecimal;
import java.sql.Date;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import v2v1.entity.Barganha;

public class BarganhaRepresentation extends ResourceSupport {

	@JsonInclude(Include.NON_NULL)
	private Long identifier;
	@JsonInclude(Include.NON_NULL)
	private Date data;
	@JsonInclude(Include.NON_NULL)
	private String descricao;
	@JsonInclude(Include.NON_NULL)
	private BigDecimal valor;

	public BarganhaRepresentation() {
		super();
	}

	public BarganhaRepresentation(Barganha barganha) {
		this.identifier = barganha.getId();
		this.data = barganha.getData();
		this.descricao = barganha.getDescricao();
		this.valor = barganha.getValor();
	}

	public static Barganha build(BarganhaRepresentation barganhaRepresentation) {
		Barganha barganha = new Barganha();
		barganha.setId(barganhaRepresentation.getIdentifier());
		barganha.setData(barganhaRepresentation.getData());
		barganha.setDescricao(barganhaRepresentation.getDescricao());
		barganha.setValor(barganhaRepresentation.getValor());
		return barganha;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
}
