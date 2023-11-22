package seden.sedentech.Modal.BO;

import org.springframework.stereotype.Service;
import seden.sedentech.Modal.beans.Diagnostico;
import seden.sedentech.Modal.beans.Usuario;

@Service
public class DiagnosticoBO {

    public Diagnostico fazerDiagnostico(Usuario usuario) {

        // Chama o método para calcular o risco no controlador de dados do usuário
        String riscoCardiaco = UsuarioBO.calcularRisco(usuario);

        // Cria um objeto de Diagnostico com base no risco calculado
        Diagnostico diagnostico = new Diagnostico();
        diagnostico.setRiscoCardiaco(riscoCardiaco);

        // Adiciona lógica adicional de diagnóstico, se necessário

        return new Diagnostico();
    }
}
