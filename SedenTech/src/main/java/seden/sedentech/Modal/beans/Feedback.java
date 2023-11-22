package seden.sedentech.Modal.beans;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "feedbacks")
public class Feedback {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "qtd_exercicio")
    private int qtdExercicio;

    @Column(name = "estado_paciente")
    private String estado;

    @Column(name = "precisa_consulta")
    private boolean consultarMedico;

    @PrimaryKeyJoinColumn(name = "feedbacks")
    @OneToOne
    private Feedback feedback;
}
