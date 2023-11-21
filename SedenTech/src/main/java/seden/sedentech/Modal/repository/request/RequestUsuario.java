package seden.sedentech.Modal.repository.request;

import jakarta.validation.constraints.NotBlank;

public record RequestUsuario(
    @NotBlank String username,
    @NotBlank String email,
    @NotBlank String senha

) { }