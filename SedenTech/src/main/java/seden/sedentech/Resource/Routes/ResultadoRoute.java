package seden.sedentech.Resource.Routes;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seden.sedentech.Modal.beans.Resultado;
import seden.sedentech.Modal.beans.Usuario;
import seden.sedentech.Modal.repository.Interface.Iresultado;
import seden.sedentech.Modal.repository.request.Resultado.RequestResultado;
import seden.sedentech.Modal.repository.request.Usuario.RequestUsuario;

@RestController
@RequestMapping("/resultado")
public class ResultadoRoute {
    @Autowired
    private Iresultado iresultado;

    @Transactional
    @GetMapping
    public ResponseEntity GetResultado (){
        var resultado = iresultado.findAll();
        return ResponseEntity.ok(resultado);
    }

    @Transactional
    @PostMapping
    public ResponseEntity RegisterResultados(@RequestBody @Valid RequestResultado data){
        Resultado newUsuario = new Resultado(data);
        iresultado.save(newUsuario);

        return ResponseEntity.ok(newUsuario);
    }
}
