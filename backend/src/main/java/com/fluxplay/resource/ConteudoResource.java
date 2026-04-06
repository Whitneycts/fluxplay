package com.fluxplay.resource;

import com.fluxplay.dto.ConteudoRequestDTO;
import com.fluxplay.dto.ConteudoResponseDTO;
import com.fluxplay.entity.TipoConteudo;
import com.fluxplay.service.ConteudoService;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

// Define a rota base da API
@Path("/conteudos")

// Diz que a API vai devolver JSON
@Produces(MediaType.APPLICATION_JSON)

// Diz que a API aceita JSON no corpo da requisição
@Consumes(MediaType.APPLICATION_JSON)
public class ConteudoResource {

    @Inject
    ConteudoService conteudoService;

    // Lista todos os conteúdos
    @GET
    public List<ConteudoResponseDTO> listar() {
        return conteudoService.listarTodos();
    }

    // Busca um conteúdo pelo id
    @GET
    @Path("/{id}")
    public ConteudoResponseDTO buscarPorId(@PathParam("id") Long id) {
        return conteudoService.buscarPorId(id);
    }

    // Cria um novo conteúdo
    @POST
    @Transactional
    public void criar(@Valid ConteudoRequestDTO dto) {conteudoService.criar(dto);
    }

    // Deleta um conteúdo pelo id
    @DELETE
    @Path("/{id}")
    @Transactional
    public boolean deletar(@PathParam("id") Long id) {
        return conteudoService.deletar(id);
    }

    // Atualiza todos os dados de um conteúdo
    @PUT
    @Path("/{id}")
    @Transactional
    public ConteudoResponseDTO atualizar(@PathParam("id") Long id, @Valid ConteudoRequestDTO dto) {
        return conteudoService.atualizar(id, dto);
    }

    // Atualiza apenas os campos enviados
    @PATCH
    @Path("/{id}")
    @Transactional
    public ConteudoResponseDTO atualizarParcial(@PathParam("id") Long id, ConteudoRequestDTO dto) {
        return conteudoService.atualizarParcial(id, dto);
    }

    // Busca conteúdos por tipo
    @GET
    @Path("/tipo/{tipo}")
    public List<ConteudoResponseDTO> buscarPorTipo(@PathParam("tipo") TipoConteudo tipo) {
        return conteudoService.buscarPorTipo(tipo);
    }

    // Busca conteúdos por gênero
    @GET
    @Path("/genero/{genero}")
    public List<ConteudoResponseDTO> buscarPorGenero(@PathParam("genero") String genero) {
        return conteudoService.buscarPorGenero(genero);
    }

    // Busca conteúdos por título
    @GET
    @Path("/titulo/{titulo}")
    public List<ConteudoResponseDTO> buscarPorTitulo(@PathParam("titulo") String titulo) {
        return conteudoService.buscarPorTitulo(titulo);
    }

    // Lista conteúdos ordenados por ano crescente
    @GET
    @Path("/ordenados/ano/asc")
    public List<ConteudoResponseDTO> listarOrdenadoPorAnoAsc() {
        return conteudoService.listarOrdenadoPorAnoAsc();
    }

    // Lista conteúdos ordenados por ano decrescente
    @GET
    @Path("/ordenados/ano/desc")
    public List<ConteudoResponseDTO> listarOrdenadoPorAnoDesc() {
        return conteudoService.listarOrdenadoPorAnoDesc();
    }
}