package com.bioconnect.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import com.bioconnect.model.Diagnostico;
import com.bioconnect.model.Feedback;
import com.bioconnect.model.Resultado;
import com.bioconnect.model.Usuario;

import javax.sql.DataSource;
import javax.swing.tree.RowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class ResultadoDAO {

	private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ResultadoDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void inserir(Diagnostico diagnostico, Feedback feedback) {
        String query = "INSERT INTO resultados (risco_cardiaco, qtd_exercicio, estado, consultar_medico) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(query, diagnostico.getRiscoCardiaco(), feedback.getQtdExercicio(), feedback.getEstado(), feedback.isConsultarMedico());
    }

    public List<Resultado> listar() {
        String query = "SELECT * FROM resultados";
        return jdbcTemplate.query(query, new ResultadoRowMapper());
    }

    public void atualizar(Resultado resultado) {
        String query = "UPDATE resultados SET risco_cardiaco=?, qtd_exercicio=?, estado=?, consultar_medico=? WHERE id=?";
        jdbcTemplate.update(query, resultado.getD().getRiscoCardiaco(), resultado.getF().getQtdExercicio(), resultado.getF().getEstado(), resultado.getF().isConsultarMedico(), resultado.getId());
    }

    public void deletar(int id) {
        String query = "DELETE FROM resultados WHERE id=?";
        jdbcTemplate.update(query, id);
    }

    private static class ResultadoRowMapper implements org.springframework.jdbc.core.RowMapper<Resultado> {
        public Resultado mapRow(ResultSet resultSet, int i) throws SQLException {
            Resultado resultado = new Resultado();
            resultado.setId(resultSet.getInt("id"));
            resultado.getD().setRiscoCardiaco(resultSet.getString("risco_cardiaco"));
            resultado.getF().setQtdExercicio(resultSet.getInt("qtd_exercicio"));
            resultado.getF().setEstado(resultSet.getString("estado"));
            resultado.getF().setConsultarMedico(resultSet.getBoolean("consultar_medico"));
            return resultado;
        }
    }
    
}
