package com.bioconnect.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bioconnect.model.Usuario;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obterUsuario(@PathVariable int id) {
        // Implementação...
    }

    @PostMapping
    public ResponseEntity<Void> criarUsuario(@RequestBody Usuario user) {
        // Implementação...
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> alterarUsuario(@PathVariable int id, @RequestBody User user) {
        // Implementação...
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable int id) {
        // Implementação...
    }

    // Outros métodos...
}

