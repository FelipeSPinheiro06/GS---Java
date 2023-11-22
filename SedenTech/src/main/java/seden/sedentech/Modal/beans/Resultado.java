package seden.sedentech.Modal.beans;

import jakarta.persistence.*;
import lombok.*;
import seden.sedentech.Modal.repository.request.Resultado.RequestResultado;
import seden.sedentech.Modal.repository.request.Resultado.ResponseResultado;

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

    @PrimaryKeyJoinColumn(name = "diagnosticos")
    @OneToOne
    private Diagnostico diagnostico;

    @PrimaryKeyJoinColumn(name = "feedbacks")
    @OneToOne
    private Feedback feedback;

    public Resultado (RequestResultado requestResultado){
        this.diagnostico = requestResultado.diagnostico();
        this.feedback = requestResultado.feedback();
    }

    public Resultado upResultado (ResponseResultado responseResultado){
        Resultado resultado = new Resultado();

        //Trocar variáveis
        if(responseResultado.diagnostico() != null) this.diagnostico = responseResultado.diagnostico();
        if(responseResultado.feedback() != null) this.feedback = responseResultado.feedback();
        return resultado;
    }


}
