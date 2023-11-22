package seden.sedentech.Modal.repository.request.Resultado;

import jakarta.validation.constraints.NotBlank;
import seden.sedentech.Modal.beans.Diagnostico;
import seden.sedentech.Modal.beans.Feedback;

public record RequestResultado (
        @NotBlank int id,
        @NotBlank Diagnostico diagnostico,
        @NotBlank Feedback feedback
){ }
