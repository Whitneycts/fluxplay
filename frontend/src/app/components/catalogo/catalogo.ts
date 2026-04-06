import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { ConteudoService, Conteudo } from '../../services/conteudo';

@Component({
  selector: 'app-catalogo',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './catalogo.html',
  styleUrl: './catalogo.scss'
})
export class Catalogo implements OnInit {
  conteudos: Conteudo[] = [];
  filmes: Conteudo[] = [];
  series: Conteudo[] = [];
  destaque: Conteudo | null = null;
  carregando = true;
  filtro: string = 'todos';
  generoSelecionado: string = 'Todos';
  generos: string[] = [];

  constructor(
    private conteudoService: ConteudoService,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.filtro = this.route.snapshot.data['filtro'] || 'todos';

    this.conteudoService.listarTodos().subscribe({
      next: (dados) => {
        this.conteudos = dados;
        this.filmes = dados.filter(c => c.tipo === 'FILME');
        this.series = dados.filter(c => c.tipo === 'SERIE');
        this.destaque = dados.find(c => c.titulo === 'Stranger Things') || dados[0];

        // pega os gêneros únicos de todos os conteúdos
        const generosUnicos = new Set(dados.map(c => c.genero));
        this.generos = ['Todos', ...Array.from(generosUnicos)];

        this.carregando = false;
      },
      error: (err) => {
        console.error('Erro ao buscar conteúdos:', err);
        this.carregando = false;
      }
    });
  }

  filtrarGenero(genero: string) {
    this.generoSelecionado = genero;
  }

  get filmesFiltrados(): Conteudo[] {
    if (this.generoSelecionado === 'Todos') return this.filmes;
    return this.filmes.filter(c => c.genero === this.generoSelecionado);
  }

  get seriesFiltradas(): Conteudo[] {
    if (this.generoSelecionado === 'Todos') return this.series;
    return this.series.filter(c => c.genero === this.generoSelecionado);
  }
}