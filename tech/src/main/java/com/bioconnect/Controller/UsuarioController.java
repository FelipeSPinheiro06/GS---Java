package com.bioconnect.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bioconnect.DAO.UsuarioDAO;
import com.bioconnect.model.Usuario;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioDAO usuarioDAO;

    // Endpoint para inserir um novo usuário
    @PostMapping("/inserir")
    public ResponseEntity<Usuario> inserirUsuario(@RequestBody Usuario usuario) {
        try {
			usuarioDAO.inserir(usuario);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    // Endpoint para listar todos os usuários
    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> listarUsuarios() throws SQLException {
        List<Usuario> usuarios = usuarioDAO.listar();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    // Endpoint para obter detalhes de um usuário específico pelo ID
    @GetMapping("/detalhes/{id}")
    public ResponseEntity<Usuario> obterDetalhesUsuario(@PathVariable int id) {
        Usuario usuario = usuarioDAO.obterPorId(id);
        if (usuario != null) {
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para atualizar informações de um usuário existente
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable int id, @RequestBody Usuario usuarioAtualizado) {
        Usuario usuarioExistente = usuarioDAO.obterPorId(id);
        if (usuarioExistente != null) {
            usuarioExistente.setLogin(usuarioAtualizado.getLogin());
            usuarioExistente.setSenha(usuarioAtualizado.getSenha());
            try {
				usuarioDAO.alterar(usuarioExistente.getId(), usuarioExistente);
			} catch (SQLException e) {
				e.printStackTrace();
			}
            return new ResponseEntity<>(usuarioExistente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para excluir um usuário pelo ID
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable int id) {
        Usuario usuarioExistente = usuarioDAO.obterPorId(id);
        if (usuarioExistente != null) {
            try {
				usuarioDAO.excluir(id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
