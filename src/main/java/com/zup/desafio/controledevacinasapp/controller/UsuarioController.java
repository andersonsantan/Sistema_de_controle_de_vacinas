package com.zup.desafio.controledevacinasapp.controller;


import com.zup.desafio.controledevacinasapp.DTO.MensagemRespostaDTO;
import com.zup.desafio.controledevacinasapp.DTO.UsuarioDTO;
import com.zup.desafio.controledevacinasapp.entity.Usuario;
import com.zup.desafio.controledevacinasapp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(path = "/api/v1/usuario")
public class UsuarioController {

    UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    //Inicio das Cahamadas de métodos CRUD

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario criarUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO){
         Usuario usuarioSalvo =  usuarioService.salvar(usuarioDTO.dtoParaUsuario());
         return usuarioSalvo;
    }

    @GetMapping
    public List<Usuario> consultarTodos(){
        return usuarioService.consultarTodos();
    }

    @GetMapping(path = "/{id}")
    public Usuario consultarUsuario(@PathVariable("id") long id){
        return usuarioService.consultarUsuario(id);
    }


    @DeleteMapping(path = "/{id}")
    public MensagemRespostaDTO deletarUsuario(@PathVariable("id") long id){
        return usuarioService.deletarUsuario(id);
        }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario atualizarUsuario(@PathVariable("id") long id, @RequestBody @Valid UsuarioDTO usuarioDTO){
        Usuario usuarioAtualizado = usuarioService.atualizarUsuario(id, usuarioDTO.dtoParaUsuario());
        return usuarioAtualizado;
    }


}

