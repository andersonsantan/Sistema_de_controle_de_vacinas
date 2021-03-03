package com.zup.desafio.controledevacinasapp.controller;



import com.zup.desafio.controledevacinasapp.DTO.MensagemRespostaDTO;
import com.zup.desafio.controledevacinasapp.DTO.VacinaDTO;
import com.zup.desafio.controledevacinasapp.entity.Vacina;
import com.zup.desafio.controledevacinasapp.service.VacinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(path = "/api/v1/vacina")
public class VacinaController {

   VacinaService vacinaService;

    @Autowired
    public VacinaController(VacinaService vacinaService) {
        this.vacinaService = vacinaService;
    }

    //Inicio das chamadas de métodos CRUD da camada de serviço

    @PostMapping()
    public ResponseEntity<Vacina> cadastrarVacina(@RequestBody @Valid VacinaDTO vacinaDTO){
        Vacina vacinaCadastrada = vacinaService.cadastrarVacina(vacinaDTO.dtoParaVacina());
        if (vacinaDTO.equals(null)){
            return new ResponseEntity<>(vacinaCadastrada, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(vacinaCadastrada, HttpStatus.CREATED);

    }

    @GetMapping
    public List<Vacina> consultarTodas(){
        return vacinaService.consultarTodas();
    }

    @GetMapping(path = "/{id}")
    public Vacina consultarVacinacaoPorId(@PathVariable("id") long id){
        return vacinaService.consultarPorId(id);
    }

    @DeleteMapping(path = "/{id}")
    public MensagemRespostaDTO deletarCadastro(@PathVariable("id") long id){
        return vacinaService.deletarCadastro(id);
    }

}
