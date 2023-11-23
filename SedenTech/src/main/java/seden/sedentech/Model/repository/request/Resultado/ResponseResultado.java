package seden.sedentech.Model.repository.request.Resultado;

import jakarta.validation.constraints.NotNull;
import seden.sedentech.Model.beans.Resultado;

public record ResponseResultado (
        @NotNull int id,

        String diagnostico,

        String feedback

){
    public ResponseResultado(Resultado resultado){
        this(
                resultado.getId(),
                resultado.getResultado_diagnostico(),
                resultado.getFeedback_mensagem()
        );
    }
}
