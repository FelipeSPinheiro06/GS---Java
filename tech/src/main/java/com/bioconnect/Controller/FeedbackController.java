package com.bioconnect.Controller;

import org.springframework.web.bind.annotation.*;

import com.bioconnect.model.Diagnostico;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @PostMapping("/gerarFeedback")
    public ResponseEntity<Feedback> gerarFeedback(@RequestBody Diagnostico diagnostico) {
        // Implementação...
    }

    // Outros métodos...
}

