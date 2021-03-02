package com.zup.desafio.controledevacinasapp.controller;



import com.zup.desafio.controledevacinasapp.entity.Vacina;
import com.zup.desafio.controledevacinasapp.repository.UsuarioRepository;
import com.zup.desafio.controledevacinasapp.repository.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping(path = "/api/v1/vacina")
public class VacinaController {

    VacinaRepository vacinaRepository;
    UsuarioRepository usuarioRepository;

    @Autowired
    public VacinaController(VacinaRepository vacinaRepository, UsuarioRepository usuarioRepository) {
        this.vacinaRepository = vacinaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping()
    public Vacina cadastrarVacina(@RequestBody Vacina vacina){
        return vacinaRepository.save(vacina);

    }

    @GetMapping
    public List<Vacina> consultarTodas(){
        return vacinaRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Vacina consultarVacinacaoPorId(@PathVariable("id") long id){
        return vacinaRepository.findById(id);
    }

    @DeleteMapping(path = "/{id}")
    public Vacina deletarCadastro(@PathVariable("id") long id){
        return vacinaRepository.deleteById(id);
    }
    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Vacina atualizarCadastro(@PathVariable("id") long id ,@RequestBody Vacina vacina){
        Vacina atualizarVvacina = vacinaRepository.findById(id);
        atualizarVvacina.setNomeVacina(vacina.getNomeVacina());
        atualizarVvacina.setDataVacinacao(vacina.getDataVacinacao());
        atualizarVvacina.setEmail(vacina.getEmail());
        return vacinaRepository.save(atualizarVvacina);
    }



}
