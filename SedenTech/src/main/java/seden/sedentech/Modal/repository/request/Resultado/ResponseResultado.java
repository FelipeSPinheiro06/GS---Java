package seden.sedentech.Modal.repository.request.Resultado;

import jakarta.validation.constraints.NotNull;
import seden.sedentech.Modal.beans.Diagnostico;
import seden.sedentech.Modal.beans.Feedback;
import seden.sedentech.Modal.beans.Resultado;
import seden.sedentech.Modal.beans.Usuario;

public record ResponseResultado (
        @NotNull int id,

        Diagnostico diagnostico,

        Feedback feedback

){
    public ResponseResultado(Resultado resultado){
        this(
                resultado.getId(),
                resultado.getDiagnostico(),
                resultado.getFeedback()
        );
    }
}
