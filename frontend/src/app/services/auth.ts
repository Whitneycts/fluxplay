import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

export interface LoginRequest {
  email: string;
  senha: string;
}

export interface LoginResponse {
  id: number;
  nome: string;
  email: string;
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8081/usuarios';

  constructor(private http: HttpClient, private router: Router) {}

  login(dados: LoginRequest): Observable<LoginResponse> {
    return this.http.post<LoginResponse>(`${this.apiUrl}/login`, dados);
  }

  salvarUsuario(usuario: LoginResponse) {
    localStorage.setItem('fluxplay_usuario', JSON.stringify(usuario));
  }

  getUsuario(): LoginResponse | null {
    const dados = localStorage.getItem('fluxplay_usuario');
    return dados ? JSON.parse(dados) : null;
  }

  estaLogado(): boolean {
    return !!this.getUsuario();
  }

  logout() {
    localStorage.removeItem('fluxplay_usuario');
    this.router.navigate(['/login']);
  }
}