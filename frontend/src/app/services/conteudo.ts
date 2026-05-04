import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError, throwError } from 'rxjs';
import { environment } from './environments/environment';

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
  private apiUrl = `${environment.apiUrl}/conteudos`;

  constructor(private http: HttpClient) {}

  listarTodos(): Observable<Conteudo[]> {
    return this.http.get<Conteudo[]>(this.apiUrl).pipe(
      catchError(error => {
        console.error('Erro ao listar conteúdos', error);
        return throwError(() => error);
      })
    );
  }
}