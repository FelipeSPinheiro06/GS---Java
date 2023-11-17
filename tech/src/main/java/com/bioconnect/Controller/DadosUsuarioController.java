package com.bioconnect.Controller;

import org.springframework.web.bind.annotation.*;

import com.bioconnect.model.DadosUsuario;

@RestController
@RequestMapping("/dadosUsuario")
public class DadosUsuarioController {

    @PostMapping("/calcularRisco")
    public String calcularRisco(@RequestBody DadosUsuario dadosUsuario) {
    	 int pontos = 0;

         // Fatores de risco hipotéticos (ajuste conforme necessário)
         int idadeMaxima = 45;
         int freqCardiacaAlta = 120;
         boolean usaAlcool = dadosUsuario.isUsaAlcool();
         boolean fuma = dadosUsuario.isFuma();
         boolean diabetes = dadosUsuario.isDiabetes();
         boolean obesidade = dadosUsuario.isObesidade();
         boolean praticaEsporte = dadosUsuario.isPraticaEsporte();

         // Verificação de idade
         if (dadosUsuario.getIdade() > idadeMaxima) {
             pontos += 2;
         }

         // Verificação de frequência cardíaca alta
         if (dadosUsuario.getFreqCardiaca() > freqCardiacaAlta) {
             pontos += 1;
         }

         // Outras verificações de fatores de risco
         if (usaAlcool) {
             pontos += 1;
         }

         if (fuma) {
             pontos += 2;
         }

         if (diabetes) {
             pontos += 1;
         }

         if (obesidade) {
             pontos += 2;
         }

         if (!praticaEsporte) {
             pontos += 1;
         }

         // Classificação de risco hipotética (ajuste conforme necessário)
         if (pontos <= 2) {
             return "Baixo Risco";
         } else if (pontos <= 5) {
             return "Moderado Risco";
         } else {
             return "Alto Risco";
         }
    }

    // Outros métodos...
}

