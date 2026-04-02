package com.fluxplay.dto;

import com.fluxplay.entity.TipoConteudo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

//entrada
public class ConteudoRequestDTO {

    @NotBlank(message = "O título é obrigatório")
    @Size (min = 2, max = 100, message = "O título deve ter entre 2 e 100 caracteres")
    public String titulo;

    @NotBlank(message = "A descrição é obrigatória")
    public String descricao;

    @NotBlank(message = "O gênero é obrigatório")
    public String genero;

    @NotNull(message = "O tipo é obrigatório")
    public TipoConteudo tipo;

    @NotNull(message = "O ano de lançamento é obrigatório")
    public Integer anoLancamento;

    public String urlImagem;
}
