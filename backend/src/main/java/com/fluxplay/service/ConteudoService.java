package com.fluxplay.service;

import com.fluxplay.dto.ConteudoRequestDTO;
import com.fluxplay.dto.ConteudoResponseDTO;
import com.fluxplay.entity.Conteudo;
import com.fluxplay.entity.TipoConteudo;
import com.fluxplay.repository.ConteudoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.util.List;

@ApplicationScoped
public class ConteudoService {

    @Inject
    ConteudoRepository conteudoRepository;

    // Converte Entity -> ResponseDTO
    private ConteudoResponseDTO toResponseDTO(Conteudo conteudo) {
        ConteudoResponseDTO dto = new ConteudoResponseDTO();

        dto.id = conteudo.id;
        dto.titulo = conteudo.titulo;
        dto.descricao = conteudo.descricao;
        dto.genero = conteudo.genero;
        dto.tipo = conteudo.tipo;
        dto.anoLancamento = conteudo.anoLancamento;
        dto.urlImagem = conteudo.urlImagem;

        return dto;
    }

    // Converte RequestDTO -> Entity
    private Conteudo toEntity(ConteudoRequestDTO dto) {
        Conteudo conteudo = new Conteudo();

        conteudo.titulo = dto.titulo;
        conteudo.descricao = dto.descricao; 
        conteudo.genero = dto.genero;
        conteudo.tipo = dto.tipo;
        conteudo.anoLancamento = dto.anoLancamento;
        conteudo.urlImagem = dto.urlImagem;

        return conteudo;
    }

    // Lista todos os conteúdos
    public List<ConteudoResponseDTO> listarTodos() {
        return conteudoRepository.listAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    // Busca um conteúdo por id
    public ConteudoResponseDTO buscarPorId(Long id) {
        Conteudo conteudo = conteudoRepository.findById(id);

        if (conteudo == null) {
            throw new NotFoundException("Conteúdo não encontrado");
        }

        return toResponseDTO(conteudo);
    }

    @Transactional
    public ConteudoResponseDTO criar(ConteudoRequestDTO dto) {
        Conteudo conteudo = toEntity(dto);
        conteudoRepository.persist(conteudo);
        return toResponseDTO(conteudo);
    }

    // Deleta conteúdo por id
    @Transactional
    public boolean deletar(Long id) {
        boolean deletado = conteudoRepository.deleteById(id);

        if (!deletado) {
            throw new NotFoundException("Conteúdo não encontrado");
        }

        return true;
    }

    // Busca por tipo
    public List<ConteudoResponseDTO> buscarPorTipo(TipoConteudo tipo) {
        return conteudoRepository.buscarPorTipo(tipo)
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    // Busca por gênero
    public List<ConteudoResponseDTO> buscarPorGenero(String genero) {
        return conteudoRepository.buscarPorGenero(genero)
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    // Busca por título
    public List<ConteudoResponseDTO> buscarPorTitulo(String titulo) {
        return conteudoRepository.buscarPorTitulo(titulo)
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    // Lista ordenado por ano crescente
    public List<ConteudoResponseDTO> listarOrdenadoPorAnoAsc() {
        return conteudoRepository.listarOrdenadoPorAnoAsc()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    // Lista ordenado por ano decrescente
    public List<ConteudoResponseDTO> listarOrdenadoPorAnoDesc() {
        return conteudoRepository.listarOrdenadoPorAnoDesc()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    // Atualiza todos os dados
    @Transactional
    public ConteudoResponseDTO atualizar(Long id, ConteudoRequestDTO dto) {
        Conteudo conteudo = conteudoRepository.findById(id);

        if (conteudo == null) {
            throw new NotFoundException("Conteúdo não encontrado");
        }

        conteudo.titulo = dto.titulo;
        conteudo.descricao = dto.descricao;
        conteudo.genero = dto.genero;
        conteudo.tipo = dto.tipo;
        conteudo.anoLancamento = dto.anoLancamento;
        conteudo.urlImagem = dto.urlImagem;

        return toResponseDTO(conteudo);
    }

    // Atualiza apenas os campos preenchidos
    @Transactional
    public ConteudoResponseDTO atualizarParcial(Long id, ConteudoRequestDTO dto) {
        Conteudo conteudo = conteudoRepository.findById(id);

        if (conteudo == null) {
            throw new NotFoundException("Conteúdo não encontrado");
        }

        if (dto.titulo != null) {
            conteudo.titulo = dto.titulo;
        }

        if (dto.descricao != null) {
            conteudo.descricao = dto.descricao;
        }

        if (dto.genero != null) {
            conteudo.genero = dto.genero;
        }

        if (dto.tipo != null) {
            conteudo.tipo = dto.tipo;
        }

        if (dto.anoLancamento != null) {
            conteudo.anoLancamento = dto.anoLancamento;
        }

        if (dto.urlImagem != null) {
            conteudo.urlImagem = dto.urlImagem;
        }

        return toResponseDTO(conteudo);
    }
}