package com.zup.desafio.controledevacinasapp.controller;


import com.zup.desafio.controledevacinasapp.entity.Usuario;
import com.zup.desafio.controledevacinasapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/usuario")
public class UsuarioController {

    UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario criarUsuario(@RequestBody Usuario usuario){
        usuarioRepository.save(usuario);
        return usuario;
    }

    @GetMapping
    public List<Usuario> consultarUsuario(){
        return usuarioRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Usuario consultarUsuario(@PathVariable("id") long id){
        Usuario usuario = usuarioRepository.findById(id);
        return usuario;
    }


    @DeleteMapping(path = "/{id}")
    public Usuario deletarCadastro(@PathVariable("id") long id){
        return usuarioRepository.deleteById(id);
    }
    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario atualizarUsuario(@PathVariable("id") long id ,@RequestBody Usuario usuario) {
        Usuario atualizarUsuario = usuarioRepository.findById(id);
        atualizarUsuario.setNome(usuario.getNome());
        atualizarUsuario.setCPF(usuario.getCPF());
        atualizarUsuario.setEmail(usuario.getEmail());
        atualizarUsuario.setDataNascimento(usuario.getDataNascimento());
        return usuarioRepository.save(atualizarUsuario);

    }

}

