package com.bioconnect.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import com.bioconnect.model.Usuario;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioDAO {

    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UsuarioDAO(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping
    public void inserir(@RequestBody Usuario user) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            String query = "INSERT INTO usuarios (id, login, senha) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, user.getId());
                preparedStatement.setString(2, user.getLogin());
                preparedStatement.setString(3, user.getSenha());
                preparedStatement.executeUpdate();
            }
        }
    }

    @GetMapping
    public List<Usuario> listar() throws SQLException {
        List<Usuario> userList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            String query = "SELECT * FROM usuarios";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Usuario user = new Usuario();
                    user.setId(resultSet.getInt("id"));
                    user.setLogin(resultSet.getString("login"));
                    user.setSenha(resultSet.getString("senha"));
                    userList.add(user);
                }
            }
        }
        return userList;
    }

    public Usuario obterPorId(int id) {
        String query = "SELECT * FROM usuarios WHERE id = ?";
        return jdbcTemplate.queryForObject(query, new UsuarioRowMapper(), id);
    }
    
    @PutMapping("/{id}")
    public void alterar(@PathVariable int id, @RequestBody Usuario user) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            String query = "UPDATE usuarios SET login=?, senha=? WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, user.getLogin());
                preparedStatement.setString(2, user.getSenha());
                preparedStatement.setInt(3, id);
                preparedStatement.executeUpdate();
            }
        }
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable int id) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            String query = "DELETE FROM usuarios WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            }
        }
    }
    
    
    
}
