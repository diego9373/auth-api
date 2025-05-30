package com.io.auth.auth_api.services.impl;

import com.io.auth.auth_api.dtos.UsuarioDto;
import com.io.auth.auth_api.models.Usuario;
import com.io.auth.auth_api.repository.UsuarioRepository;
import com.io.auth.auth_api.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioDto salvar(UsuarioDto usuarioDto) {

        Usuario usuarioJaExiste = usuarioRepository.findByLogin(usuarioDto.login());

        if (usuarioJaExiste != null) {
            throw new RuntimeException("Usuário já existe!");
        }

        Usuario entity = new Usuario(usuarioDto.name(),usuarioDto.login(),usuarioDto.senha());
        Usuario novoUsuario =  usuarioRepository.save(entity);
        return new UsuarioDto(novoUsuario.getName(),novoUsuario.getLogin(),novoUsuario.getSenha());
    }
}
