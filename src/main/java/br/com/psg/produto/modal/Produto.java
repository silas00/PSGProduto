package br.com.psg.produto.modal;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LISTA")
public class Produto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PRODUTO_ID")
	private Long id;
	@Column(name="NOME")
	private String nome;
	@Column(name="TIPO")
	private String tipo;
	@Column(name="PRECO")
	private double preco;
	@Column(name="VENCIMENTO")
	private String vencimento;
	@Column(name="ARQUIVO")
	private String arquivo;
	
	public Produto() {
		
	}
	
	public Produto(String nome, String tipo, double preco, String vencimento) {
		this.nome = nome;
		this.tipo = tipo;
		this.preco = preco;
		this.vencimento = vencimento;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getVencimento() {
		return vencimento;
	}
	public void setVencimento(String vencimento) {
		this.vencimento = vencimento;
	}

	public String getArquivo() {
		return arquivo;
	}

	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}
	
}	