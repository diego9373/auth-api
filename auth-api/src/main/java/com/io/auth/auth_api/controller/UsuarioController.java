package com.io.auth.auth_api.controller;

import com.io.auth.auth_api.dtos.UsuarioDto;
import com.io.auth.auth_api.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    private UsuarioDto salvar(@RequestBody UsuarioDto usuarioDto) {
        return   usuarioService.salvar(usuarioDto);
    }

    @GetMapping("/admin")
    private String getOk(){
    return "permissão de administrador";
    }

    @GetMapping("/user")
    private String getUser() {
        return "permissão de usuario";
    }


}
