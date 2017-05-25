package v2v1.representation;

import java.math.BigDecimal;
import java.sql.Date;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import v2v1.entity.Emprestimo;

public class EmprestimoRepresentation extends ResourceSupport {

	@JsonInclude(Include.NON_NULL)
	private Long identifier;
	@JsonInclude(Include.NON_NULL)
	private Date data;
	@JsonInclude(Include.NON_NULL)
	private String descricao;
	@JsonInclude(Include.NON_NULL)
	private BigDecimal valor;
	@JsonInclude(Include.NON_NULL)
	private Date limitepgto;

	public EmprestimoRepresentation() {
		super();
	}

	public EmprestimoRepresentation(Emprestimo emprestimo) {
		this.identifier = emprestimo.getId();
		this.data = emprestimo.getData();
		this.descricao = emprestimo.getDescricao();
		this.valor = emprestimo.getValor();
		this.limitepgto = emprestimo.getLimitepgto();
	}

	public static Emprestimo build(EmprestimoRepresentation emprestimoRepresentation) {
		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setId(emprestimoRepresentation.getIdentifier());
		emprestimo.setData(emprestimoRepresentation.getData());
		emprestimo.setDescricao(emprestimoRepresentation.getDescricao());
		emprestimo.setValor(emprestimoRepresentation.getValor());
		emprestimo.setLimitepgto(emprestimoRepresentation.getLimitepgto());

		return emprestimo;
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

	public Date getLimitepgto() {
		return limitepgto;
	}

	public void setLimitepgto(Date limitepgto) {
		this.limitepgto = limitepgto;
	}

}
