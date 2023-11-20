package com.bioconnect.Controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bioconnect.model.Diagnostico;
import com.bioconnect.model.Feedback;
import com.bioconnect.model.Resultado;

@RestController
@RequestMapping("/diagnostico")
public class ResultadoController {
	
	@PostMapping("/gerarresultado")
	public Resultado gerarResultado(Diagnostico d, Feedback f) {
		
		String mensagem = String.format("Seu resultado é %s!"
				+ "É recomendado você fazer %d exercícios por semana!"
				+ "O seu estado é %s"
				+ "Você deve consultar o médico? A resposta é %b", d.getRiscoCardiaco(), 
				f.getQtdExercicio(),
				f.getEstado(), 
				f.isConsultarMedico());
		
		Resultado r = new Resultado(d, f, mensagem);
		
		return r;
	}
}
