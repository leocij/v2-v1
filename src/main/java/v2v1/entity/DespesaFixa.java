package v2v1.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DespesaFixa implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int diaPgto;
	private String descricao;
	private BigDecimal valor;
	private String mes;
	private int ano;

	public DespesaFixa() {
		super();
	}

	public DespesaFixa(Long id, int diaPgto, BigDecimal valor, String descricao, String mes, int ano) {
		super();
		this.id = id;
		this.diaPgto = diaPgto;
		this.valor = valor;
		this.descricao = descricao;
		this.mes = mes;
		this.ano = ano;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getDiaPgto() {
		return diaPgto;
	}

	public void setDiaPgto(int diaPgto) {
		this.diaPgto = diaPgto;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
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

	@Override
	public String toString() {
		return "DespesaFixa [id=" + id + ", diaPgto=" + diaPgto + ", descricao=" + descricao + ", valor=" + valor
				+ ", mes=" + mes + ", ano=" + ano + "]";
	}

}
