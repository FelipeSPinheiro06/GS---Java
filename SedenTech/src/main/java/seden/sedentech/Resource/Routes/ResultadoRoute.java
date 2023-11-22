package seden.sedentech.Resource.Routes;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seden.sedentech.Modal.beans.Resultado;
import seden.sedentech.Modal.beans.Usuario;
import seden.sedentech.Modal.repository.Interface.Iresultado;
import seden.sedentech.Modal.repository.request.Resultado.RequestResultado;
import seden.sedentech.Modal.repository.request.Resultado.ResponseResultado;
import seden.sedentech.Modal.repository.request.Usuario.RequestUsuario;

import java.util.Optional;

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
        Resultado newResultado = new Resultado(data);
        iresultado.save(newResultado);

        return ResponseEntity.ok(newResultado);
    }

    @Transactional
    @PutMapping
    public ResponseEntity UpdateResultados(@RequestBody @Valid ResponseResultado upData){
        Optional<Resultado> optionalResultado = iresultado.findById(String.valueOf(upData.id()));

        if(!optionalResultado.isPresent()) throw new EntityNotFoundException();

        Resultado upClient = optionalResultado.get();
        upClient.upResultado(upData);

        return ResponseEntity.ok(upClient);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity DelResultado(@PathVariable int id){
        iresultado.deleteById(String.valueOf(id));
        return ResponseEntity.ok("Deletado com sucesso!");
    }
}
