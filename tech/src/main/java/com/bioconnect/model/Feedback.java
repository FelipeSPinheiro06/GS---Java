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
@Table(name = "feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "qtd_exercicio")
    private int qtdExercicio;

    @Column(name = "estado")
    private String estado;

    @Column(name = "consultar_medico")
    private boolean consultarMedico;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
	
    public Feedback() {}
    
    public Feedback(int id, int qtdExercicio, String estado, boolean consultarMedico) {
		this.id = id;
		this.qtdExercicio = qtdExercicio;
		this.estado = estado;
		this.consultarMedico = consultarMedico;
	}
    
    
    public int getQtdExercicio() {
		return qtdExercicio;
	}

	public void setQtdExercicio(int qtdExercicio) {
		this.qtdExercicio = qtdExercicio;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public boolean isConsultarMedico() {
		return consultarMedico;
	}
	public void setConsultarMedico(boolean consultarMedico) {
		this.consultarMedico = consultarMedico;
	}

    
}
