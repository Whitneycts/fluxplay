package com.fluxplay.service;

import com.fluxplay.dto.LoginRequestDTO;
import com.fluxplay.dto.UsuarioRequestDTO;
import com.fluxplay.dto.UsuarioResponseDTO;
import com.fluxplay.entity.Usuario;
import com.fluxplay.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.NotAuthorizedException;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class UsuarioService {

    @Inject
    UsuarioRepository usuarioRepository;

    private UsuarioResponseDTO toResponseDTO(Usuario usuario) {
        UsuarioResponseDTO dto = new UsuarioResponseDTO();
        dto.id = usuario.id;
        dto.nome= usuario.nome;
        dto.email = usuario.email;

        return dto;
    }

    @Transactional
    public UsuarioResponseDTO cadastrar(@Valid UsuarioRequestDTO dto) {
        Usuario existente = usuarioRepository.buscarPorEmail(dto.email);

        if(existente != null) {
            throw new BadRequestException("Já existe um usuário com esse email");
        }

        Usuario usuario = new Usuario();
        usuario.nome = dto.nome;
        usuario.email = dto.email;
        usuario.senha = dto.senha;

        usuarioRepository.persist(usuario);

        return toResponseDTO(usuario);
    }

    public UsuarioResponseDTO login(LoginRequestDTO dto) {
        Usuario usuario = usuarioRepository.buscarPorEmail(dto.email);

        if (usuario == null) {
            throw new NotFoundException("Usuário não encontrado");
        }

        // ← verifica se a senha bate com a salva no banco
        if (!dto.senha.equals(usuario.senha)) {
            throw new NotAuthorizedException("Senha inválida");
        }

        return toResponseDTO(usuario);
    }

}
