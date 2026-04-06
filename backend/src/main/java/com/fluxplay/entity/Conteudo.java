package com.fluxplay.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Conteudo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public Long id;

    public String titulo;

    public String descricao;

    public String genero;

    @Enumerated(EnumType.STRING)
    public TipoConteudo tipo;

    public Integer anoLancamento;

    public String urlImagem;


}