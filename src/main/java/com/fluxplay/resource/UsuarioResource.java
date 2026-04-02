package com.fluxplay.resource;

import com.fluxplay.dto.LoginRequestDTO;
import com.fluxplay.dto.UsuarioRequestDTO;
import com.fluxplay.dto.UsuarioResponseDTO;
import com.fluxplay.entity.Usuario;
import com.fluxplay.service.UsuarioService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @Inject
    UsuarioService usuarioService;

    @POST
    @Path("/cadastro")
    public UsuarioResponseDTO cadastrar(@Valid UsuarioRequestDTO dto) {
        return usuarioService.cadastrar(dto);
    }

    @POST
    @Path("/login")
    public UsuarioResponseDTO login(@Valid LoginRequestDTO dto) {
        return usuarioService.login(dto);
    }
}
