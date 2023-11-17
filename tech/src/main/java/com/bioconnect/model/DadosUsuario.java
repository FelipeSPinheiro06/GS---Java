package com.bioconnect.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "dados_usuario")
public class DadosUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "idade")
    private int idade;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "usa_alcool")
    private boolean usaAlcool;

    @Column(name = "fuma")
    private boolean fuma;

    @Column(name = "freq_cardiaca")
    private int freqCardiaca;

    @Column(name = "diabetes")
    private boolean diabetes;

    @Column(name = "obesidade")
    private boolean obesidade;

    @Column(name = "pratica_esporte")
    private boolean praticaEsporte;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public boolean isUsaAlcool() {
		return usaAlcool;
	}

	public void setUsaAlcool(boolean usaAlcool) {
		this.usaAlcool = usaAlcool;
	}

	public boolean isFuma() {
		return fuma;
	}

	public void setFuma(boolean fuma) {
		this.fuma = fuma;
	}

	public int getFreqCardiaca() {
		return freqCardiaca;
	}

	public void setFreqCardiaca(int freqCardiaca) {
		this.freqCardiaca = freqCardiaca;
	}

	public boolean isDiabetes() {
		return diabetes;
	}

	public void setDiabetes(boolean diabetes) {
		this.diabetes = diabetes;
	}

	public boolean isObesidade() {
		return obesidade;
	}

	public void setObesidade(boolean obesidade) {
		this.obesidade = obesidade;
	}

	public boolean isPraticaEsporte() {
		return praticaEsporte;
	}

	public void setPraticaEsporte(boolean praticaEsporte) {
		this.praticaEsporte = praticaEsporte;
	}

    
}
