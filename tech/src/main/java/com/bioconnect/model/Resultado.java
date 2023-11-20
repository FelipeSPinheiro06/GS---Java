package com.bioconnect.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_resultado")
public class Resultado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "usuario_diagnostico")
	private Diagnostico d;
	
	@Column(name = "usuario_feedback")
	private Feedback f;
	
	@Column(name = "usuario_mensagem")
	private String mensagem;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	

	public Resultado(Diagnostico d, Feedback f, String mensagem) {
		this.d = d;
		this.f = f;
		this.mensagem = mensagem;
	}
	
	public Resultado() {
		
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Diagnostico getD() {
		return d;
	}
	public void setD(Diagnostico d) {
		this.d = d;
	}
	public Feedback getF() {
		return f;
	}
	public void setF(Feedback f) {
		this.f = f;
	}

	
	
}
