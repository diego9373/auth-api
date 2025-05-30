package com.io.auth.auth_api.services;

import com.io.auth.auth_api.dtos.UsuarioDto;
import com.io.auth.auth_api.repository.UsuarioRepository;

public interface UsuarioService {

    public UsuarioDto salvar(UsuarioDto usuarioDto);
}
