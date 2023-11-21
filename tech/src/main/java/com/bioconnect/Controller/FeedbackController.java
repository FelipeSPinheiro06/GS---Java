package com.bioconnect.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bioconnect.model.Diagnostico;
import com.bioconnect.model.Feedback;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @PostMapping("/gerarFeedback")
    public ResponseEntity<Feedback> gerarFeedback(@RequestBody Diagnostico diagnostico) {
    	Feedback f = new Feedback();
    	if(diagnostico.getRiscoCardiaco() == "Baixo Risco") {
    		String mensagem = String.format("Seu resultado é %s! É recomendado você fazer %d exercícios por semana! "
    				+ "O seu estado é %s. Você deve consultar o médico com urgência? A resposta é %b. "
    				+ "Porém, se sentir algo, é sempre bom consultar um cardiologista.",
                    diagnostico.getRiscoCardiaco(), 
                    f.getQtdExercicio(),
                    f.getEstado(), 
                    f.isConsultarMedico());
    	}
    	else if(diagnostico.getRiscoCardiaco() == "Moderado Risco") {
    		String mensagem = String.format("Seu resultado é %s! É recomendado você fazer %d exercícios por semana! "
    				+ "O seu estado é %s. Você deve consultar o médico com urgência? A resposta é %b.",
                    diagnostico.getRiscoCardiaco(), 
                    f.getQtdExercicio(),
                    f.getEstado(), 
                    f.isConsultarMedico());
    	}
    	else if(diagnostico.getRiscoCardiaco() == "Alto Risco") {
    		String mensagem = String.format("Seu resultado é %s! É recomendado você fazer %d exercícios por semana! "
    				+ "O seu estado é %s. Você deve consultar o médico com urgência? A resposta é %b.",
                    diagnostico.getRiscoCardiaco(), 
                    f.getQtdExercicio(),
                    f.getEstado(), 
                    f.isConsultarMedico());
    	}
    	
    	return new ResponseEntity<>(f, HttpStatus.OK);
    }

    
}

