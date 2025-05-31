package com.io.auth.auth_api.config;

import com.io.auth.auth_api.models.Usuario;
import com.io.auth.auth_api.repository.UsuarioRepository;
import com.io.auth.auth_api.services.AutenticacaoService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private AutenticacaoService autenticacaoService;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token = extraiTokenHeader(request);

        if (token != null) {
              String login =  autenticacaoService.validarTokenJwt(token);
              Usuario usuario = usuarioRepository.findByLogin(login);


              var autentication = new UsernamePasswordAuthenticationToken(usuario, null ,usuario.getAuthorities());

              SecurityContextHolder.getContext().setAuthentication(autentication);


        }
        filterChain.doFilter(request,response);

    }

    public String extraiTokenHeader(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");

        if (authHeader == null) {
            return null;
        }

        if (authHeader.split(" ")[0].equals("Bearer")) {
            return  null;
        }

        return authHeader.split(" ")[1];
    }
}
