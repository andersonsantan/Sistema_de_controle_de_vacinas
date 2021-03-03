package com.zup.desafio.controledevacinasapp.service;

import com.zup.desafio.controledevacinasapp.DTO.MensagemRespostaDTO;
import com.zup.desafio.controledevacinasapp.entity.Vacina;
import com.zup.desafio.controledevacinasapp.repository.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VacinaService {

    VacinaRepository vacinaRepository;


    @Autowired
    public VacinaService(VacinaRepository vacinaRepository) {
        this.vacinaRepository = vacinaRepository;

    }

    //Inicio dos métodos CRUD

    public Vacina cadastrarVacina(Vacina vacina){
        return vacinaRepository.save(vacina);

    }

    public List<Vacina> consultarTodas(){
        return vacinaRepository.findAll();
    }

    public Vacina consultarPorId(long id){
        return vacinaRepository.findById(id);
    }

    public MensagemRespostaDTO deletarCadastro(long id) {
        vacinaRepository.deleteById(id);
        String mensagem = "Cadastro deletado com sucesso";
        return new MensagemRespostaDTO(mensagem);
    }



}
