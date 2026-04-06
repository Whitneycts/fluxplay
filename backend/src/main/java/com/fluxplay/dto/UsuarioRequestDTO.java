package com.fluxplay.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioRequestDTO {

    @NotBlank(message = "O nome é obrigatório")
    public String nome;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Email inválido")
    public String email;

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 4, message = "A senha deve ter pelo mneos 4 caracteres")
    public String senha;

}
