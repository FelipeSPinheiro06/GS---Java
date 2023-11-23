package seden.sedentech.Controller.BO;

import org.springframework.stereotype.Service;
import seden.sedentech.Model.beans.Diagnostico;
import seden.sedentech.Model.beans.Feedback;

@Service
public class FeedbackBO {

    public Feedback gerarFeedback(Diagnostico diagnostico) {
        Feedback f = new Feedback();
        if(diagnostico.getRiscoCardiaco() == "Baixo Risco") {
            f.setQtdExercicio(1);
            f.setEstado("Bom");
            f.setConsultarMedico(false);

            String mensagem = String.format("Seu resultado é %s! É recomendado você fazer %d exercícios por semana! "
                            + "O seu estado é %s. Você deve consultar o médico com urgência? A resposta é %b. "
                            + "Porém, se sentir algo, é sempre bom consultar um cardiologista.",
                    diagnostico.getRiscoCardiaco(),
                    f.getQtdExercicio(),
                    f.getEstado(),
                    f.isConsultarMedico());
        }
        else if(diagnostico.getRiscoCardiaco() == "Moderado Risco") {
            f.setQtdExercicio(2);
            f.setEstado("Relativamente bom");
            f.setConsultarMedico(false);

            String mensagem = String.format("Seu resultado é %s! É recomendado você fazer %d exercícios por semana! "
                            + "O seu estado é %s. Você deve consultar o médico com urgência? A resposta é %b.",
                    diagnostico.getRiscoCardiaco(),
                    f.getQtdExercicio(),
                    f.getEstado(),
                    f.isConsultarMedico());
        }
        else if(diagnostico.getRiscoCardiaco() == "Alto Risco") {
            f.setQtdExercicio(4);
            f.setEstado("ruim");
            f.setConsultarMedico(true);

            String mensagem = String.format("Seu resultado é %s! É recomendado você fazer %d exercícios por semana! "
                            + "O seu estado é %s. Você deve consultar o médico com urgência? A resposta é %b.",
                    diagnostico.getRiscoCardiaco(),
                    f.getQtdExercicio(),
                    f.getEstado(),
                    f.isConsultarMedico());
        }

        return f;
    }
}
