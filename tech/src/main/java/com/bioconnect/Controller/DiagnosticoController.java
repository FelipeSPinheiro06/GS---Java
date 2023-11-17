package com.bioconnect.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/diagnostico")
public class DiagnosticoController {

    @PostMapping("/fazerDiagnostico")
    public ResponseEntity<Diagnostico> fazerDiagnostico(@RequestBody DadosUsuarioController dadosUsuarioController) {
        // Implementação...
    }

    // Outros métodos...
}
