package com.example.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "complexo_eolico")
@Entity
public class ComplexoEolico extends AbstractEntity{
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String uf;
	@Column(nullable = false)
	private String identificador;
		
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
}
