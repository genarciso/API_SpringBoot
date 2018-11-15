package com.example.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "aerogerador")
public class Aerogerador extends AbstractEntity{
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String modelo;
	private float latitude;
	private float longitude;
	@Column(name = "altura_torre")
	private float alturaTorre;
	@Column(name = "diametro_varredura")
	private float diametroVarrdura;
	
	@ManyToOne(fetch = FetchType.LAZY, optional=false)
	@JoinColumn(name="parque_eolico_id")
	private ParqueEolico parqueEolico;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getAlturaTorre() {
		return alturaTorre;
	}

	public void setAlturaTorre(float alturaTorre) {
		this.alturaTorre = alturaTorre;
	}

	public float getDiametroVarrdura() {
		return diametroVarrdura;
	}

	public void setDiametroVarrdura(float diametroVarrdura) {
		this.diametroVarrdura = diametroVarrdura;
	}

	public ParqueEolico getParqueEolico() {
		return parqueEolico;
	}

	public void setParqueEolico(ParqueEolico parqueEolico) {
		this.parqueEolico = parqueEolico;
	}
}
