package seden.sedentech.Model.beans;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "diagnosticos")
public class Diagnostico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "risco_cardiaco")
    private String riscoCardiaco;

    @JoinColumn(name = "diagnosticos")
    @OneToOne
    private Resultado resultado;

    @OneToOne
    @JoinColumn(name = "diagnostico", referencedColumnName = "diagnostico")
    private Usuario usuario;
}
