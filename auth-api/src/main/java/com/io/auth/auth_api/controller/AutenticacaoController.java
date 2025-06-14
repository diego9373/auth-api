package com.io.auth.auth_api.controller;

import com.io.auth.auth_api.dtos.AuthDto;
import com.io.auth.auth_api.services.AutenticacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AutenticacaoService autenticacaoService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public String auth(@RequestBody AuthDto authDto) {
        var usuarioAutenticationToken = new UsernamePasswordAuthenticationToken(authDto.login(),authDto.senha());
        authenticationManager.authenticate(usuarioAutenticationToken);


        return autenticacaoService.obterToken(authDto);
    }
}
