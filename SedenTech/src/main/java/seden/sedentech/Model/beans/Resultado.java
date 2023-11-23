package seden.sedentech.Model.beans;

import jakarta.persistence.*;
import lombok.*;
import seden.sedentech.Model.repository.request.Resultado.RequestResultado;
import seden.sedentech.Model.repository.request.Resultado.ResponseResultado;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "resultados")
public class Resultado {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "diagnostico")
    private String resultado_diagnostico;

    @Column(name = "feedbacks")
    private String feedback_mensagem;

    /*@PrimaryKeyJoinColumn(name = "feedbacks")
    @OneToOne
    private Feedback feedback;

    @PrimaryKeyJoinColumn(name = "diagnosticos")
    @OneToOne
    private Diagnostico diagnostico;

    @PrimaryKeyJoinColumn(name = "usuario")
    @OneToOne
    private Usuario usuario;*/

    public Resultado (RequestResultado requestResultado){
        this.resultado_diagnostico = requestResultado.diagnostico();
        this.feedback_mensagem = requestResultado.feedback();
    }

    public Resultado upResultado (ResponseResultado responseResultado){
        Resultado resultado = new Resultado();

        if(responseResultado.diagnostico() != null) {
            this.resultado_diagnostico = responseResultado.diagnostico();
        }

        if(responseResultado.feedback() != null) {
            this.feedback_mensagem = responseResultado.feedback();
        }
        return resultado;
    }

    /*public void getRiscoCardiaco() {
        UsuarioBO usuarioBO = new UsuarioBO();
        resultado_diagnostico = usuarioBO.calcularRisco(usuario);
    }
    public void getMensagemFeedback() {
        DiagnosticoBO diagnosticoBO = new DiagnosticoBO();
        feedback_mensagem = diagnosticoBO.fazerDiagnostico(usuario);
    }*/
}
