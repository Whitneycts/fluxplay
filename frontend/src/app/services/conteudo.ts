import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Conteudo {
  id: number;
  titulo: string;
  descricao: string;
  genero: string;
  tipo: string;
  anoLancamento: number;
  urlImagem: string;
}

@Injectable({
  providedIn: 'root'
})
export class ConteudoService {
  private apiUrl = 'http://localhost:8081/conteudos';

  constructor(private http: HttpClient) {}

  listarTodos(): Observable<Conteudo[]> {
    return this.http.get<Conteudo[]>(this.apiUrl);
  }
}