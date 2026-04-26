package com.fluxplay.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginRequestDTO {

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Email inválido")
    public String email;

    @NotBlank(message = "A senha é obrigatória")
    public String senha;
}
