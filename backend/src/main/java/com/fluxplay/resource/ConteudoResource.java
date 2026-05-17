package com.fluxplay.resource;

import jakarta.annotation.security.RolesAllowed;

import com.fluxplay.dto.ConteudoRequestDTO;
import com.fluxplay.dto.ConteudoResponseDTO;
import com.fluxplay.entity.TipoConteudo;
import com.fluxplay.service.ConteudoService;

import jakarta.inject.Inject;

import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

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
    @RolesAllowed({"admin", "usuario"})
    public List<ConteudoResponseDTO> listar() {
        return conteudoService.listarTodos();
    }

    // Busca um conteúdo pelo id
    @GET
    @RolesAllowed({"admin", "usuario"})
    @Path("/{id}")
    public ConteudoResponseDTO buscarPorId(@PathParam("id") Long id) {
        return conteudoService.buscarPorId(id);
    }

    // Cria um novo conteúdo
    @POST
    @RolesAllowed("admin")
    public Response criar(@Valid ConteudoRequestDTO dto) {
        ConteudoResponseDTO criado = conteudoService.criar(dto);
        return Response.status(Response.Status.CREATED).entity(criado).build();
    }

    // Deleta um conteúdo pelo id
    @DELETE
    @RolesAllowed("admin")
    @Path("/{id}")
    public boolean deletar(@PathParam("id") Long id) {
        return conteudoService.deletar(id);
    }

    // Atualiza todos os dados de um conteúdo
    @PUT
    @RolesAllowed("admin")
    @Path("/{id}")
    public ConteudoResponseDTO atualizar(@PathParam("id") Long id, @Valid ConteudoRequestDTO dto) {
        return conteudoService.atualizar(id, dto);
    }

    // Atualiza apenas os campos enviados
    @PATCH
    @RolesAllowed("admin")
    @Path("/{id}")
    public ConteudoResponseDTO atualizarParcial(@PathParam("id") Long id, @Valid ConteudoRequestDTO dto) {
        return conteudoService.atualizarParcial(id, dto);
    }

    // Busca conteúdos por tipo
    @GET
    @RolesAllowed({"admin", "usuario"})
    @Path("/tipo/{tipo}")
    public List<ConteudoResponseDTO> buscarPorTipo(@PathParam("tipo") TipoConteudo tipo) {
        return conteudoService.buscarPorTipo(tipo);
    }

    // Busca conteúdos por gênero
    @GET
    @RolesAllowed({"admin", "usuario"})
    @Path("/genero/{genero}")
    public List<ConteudoResponseDTO> buscarPorGenero(@PathParam("genero") String genero) {
        return conteudoService.buscarPorGenero(genero);
    }

    // Busca conteúdos por título
    @GET
    @RolesAllowed({"admin", "usuario"})
    @Path("/titulo/{titulo}")
    public List<ConteudoResponseDTO> buscarPorTitulo(@PathParam("titulo") String titulo) {
        return conteudoService.buscarPorTitulo(titulo);
    }

    // Lista conteúdos ordenados por ano crescente
    @GET
    @RolesAllowed({"admin", "usuario"})
    @Path("/ordenados/ano/asc")
    public List<ConteudoResponseDTO> listarOrdenadoPorAnoAsc() {
        return conteudoService.listarOrdenadoPorAnoAsc();
    }

    // Lista conteúdos ordenados por ano decrescente
    @GET
    @RolesAllowed({"admin", "usuario"})
    @Path("/ordenados/ano/desc")
    public List<ConteudoResponseDTO> listarOrdenadoPorAnoDesc() {
        return conteudoService.listarOrdenadoPorAnoDesc();
    }
}