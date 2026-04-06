package com.fluxplay.service;

import com.fluxplay.dto.ConteudoRequestDTO;
import com.fluxplay.dto.ConteudoResponseDTO;
import com.fluxplay.entity.Conteudo;

import com.fluxplay.entity.TipoConteudo;
import io.quarkus.test.junit.QuarkusTest;

import jakarta.inject.Inject;


import org.junit.jupiter.api.Test;

import java.util.List;

import jakarta.ws.rs.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class ConteudoServiceTest {

    @Inject
    ConteudoService conteudoService;

    @Test
    public void deveListarConteudos() {

        List<ConteudoResponseDTO> lista = conteudoService.listarTodos();

        assertNotNull(lista);
    }

    @Test
    public void deveLancarErroQuandoNaoEncontrarConteudoPorId() {

        assertThrows(NotFoundException.class, () -> {
            conteudoService.buscarPorId(999999L);

        });
    }

    @Test
    public void deveCriarConteudo() {
        ConteudoRequestDTO dto = new ConteudoRequestDTO();
        dto.titulo = "Teste";
        dto.descricao = "Desc teste";
        dto.genero = "Ação";
        dto.tipo = TipoConteudo.FILME;
        dto.anoLancamento = 2026;
        dto.urlImagem = "imagem.jpg";

        conteudoService.criar(dto);

        List<ConteudoResponseDTO> lista = conteudoService.listarTodos();

        assertNotNull(lista);
        assertFalse(lista.isEmpty());
    }
}
