package com.bioconnect.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bioconnect.model.DadosUsuario;
import com.bioconnect.model.Diagnostico;

@RestController
@RequestMapping("/diagnostico")
public class DiagnosticoController {

    @PostMapping("/fazerDiagnostico")
    public ResponseEntity<Diagnostico> fazerDiagnostico(@RequestBody DadosUsuarioController dadosUsuarioController, DadosUsuario dadosUsuario) {
    	// Chama o método para calcular o risco no controlador de dados do usuário
        String riscoCardiaco = dadosUsuarioController.calcularRisco(dadosUsuario);

        // Cria um objeto de Diagnostico com base no risco calculado
        Diagnostico diagnostico = new Diagnostico();
        diagnostico.setRiscoCardiaco(riscoCardiaco);

        // Adiciona lógica adicional de diagnóstico, se necessário

        return new ResponseEntity<>(diagnostico, HttpStatus.OK);
    }
}
