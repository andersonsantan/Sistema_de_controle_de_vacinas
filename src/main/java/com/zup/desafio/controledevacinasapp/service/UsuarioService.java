package com.zup.desafio.controledevacinasapp.service;

import com.zup.desafio.controledevacinasapp.DTO.MensagemRespostaDTO;
import com.zup.desafio.controledevacinasapp.entity.Usuario;
import com.zup.desafio.controledevacinasapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Inicio dos métodos CRUD

    public Usuario salvar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> consultarTodos(){
        return usuarioRepository.findAll();
    }

    public Usuario consultarUsuario(long id) {
        return usuarioRepository.findById(id);
    }

    public MensagemRespostaDTO deletarUsuario(long id) {
        usuarioRepository.deleteById(id);
        String mensagem = "Usuário deletado com Sucesso";
        return new MensagemRespostaDTO(mensagem);
    }

    public Usuario atualizarUsuario( long id , Usuario usuario) {
        Usuario atualizarUsuario = usuarioRepository.findById(id);
        atualizarUsuario.setNome(usuario.getNome());
        atualizarUsuario.setCPF(usuario.getCPF());
        atualizarUsuario.setEmail(usuario.getEmail());
        atualizarUsuario.setDataNascimento(usuario.getDataNascimento());
        return usuarioRepository.save(atualizarUsuario);

    }
}
