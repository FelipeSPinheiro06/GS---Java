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
@Table(name = "diagnostico")
public class Diagnostico {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "risco_cardiaco")
    private String riscoCardiaco;
    
    
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
	
    public Diagnostico() {}
    
	public Diagnostico(int id, String riscoCardiaco, Usuario usuario) {
		this.id = id;
		this.riscoCardiaco = riscoCardiaco;
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRiscoCardiaco() {
		return riscoCardiaco;
	}

	public void setRiscoCardiaco(String riscoCardiaco) {
		this.riscoCardiaco = riscoCardiaco;
	}

    
}
