package com.io.auth.auth_api.dtos;

import com.io.auth.auth_api.enums.RoleEnum;

public record UsuarioDto(
        String name,
        String login,
        String senha,
        RoleEnum role

) {
}
