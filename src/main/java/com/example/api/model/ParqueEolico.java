package com.example.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "parque_eolico")
public class ParqueEolico extends AbstractEntity{
	
	@Column(nullable = false)
	private String nome;
	private int latitude;
	private int longitude;
	@Column(name = "potencia_instalada")
	private float potenciaInstalada;
	
	@ManyToOne(fetch = FetchType.LAZY, optional=false)
	@JoinColumn(name="complexo_eolico_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
	private ComplexoEolico complexo;
	
	public ComplexoEolico getComplexoEolico() {
		return complexo;
	}
	public void setComplexoEolico(ComplexoEolico complexo) {
		this.complexo = complexo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getLatitude() {
		return latitude;
	}
	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}
	public int getLongitude() {
		return longitude;
	}
	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}
	public float getPotenciaInstalada() {
		return potenciaInstalada;
	}
	public void setPotenciaInstalada(float potenciaInstalada) {
		this.potenciaInstalada = potenciaInstalada;
	}
}
