package seden.sedentech.Modal.repository.request.Usuario;

import jakarta.validation.constraints.NotNull;
import seden.sedentech.Modal.beans.Usuario;

public record ResponseUsuario(
        @NotNull int id,
        String username,
        String email,
        String senha,
        int idade,
        String sexo,
        boolean usaAlcool,
        boolean e_fumante,
        int freqCardiaca,
        boolean possuiDiabetes,
        boolean possuiObesidade,
        boolean praticaEsporte
) {
    public ResponseUsuario(Usuario usuario){
        this(
                usuario.getId(),
                usuario.getUsername(),
                usuario.getEmail(),
                usuario.getSenha(),
                usuario.getIdade(),
                usuario.getSexo(),
                usuario.isUsaAlcool(),
                usuario.isE_fumante(),
                usuario.getFreqCardiaca(),
                usuario.isPossuiDiabetes(),
                usuario.isPossuiObesidade(),
                usuario.isPraticaEsporte()
        );
    }
}