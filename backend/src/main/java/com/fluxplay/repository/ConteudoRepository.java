package com.fluxplay.repository;

import com.fluxplay.entity.Conteudo;
import com.fluxplay.entity.TipoConteudo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ConteudoRepository implements PanacheRepository<Conteudo> {
    public List<Conteudo> buscarPorTipo(TipoConteudo tipo) {
        return find("tipo", tipo).list();
    }

    public List<Conteudo> buscarPorGenero(String genero) {
        return find("genero", genero).list();
    }

    public List<Conteudo> buscarPorTitulo(String titulo) {
        return find("lower(titulo) like lower(?1)", "%" + titulo + "%").list();
    }

    public List<Conteudo> listarOrdenadoPorAnoAsc() {
        return find("order by anoLancamento asc").list();
    }

    public List<Conteudo> listarOrdenadoPorAnoDesc() {
        return find("order by anoLancamento desc").list();
    }
}