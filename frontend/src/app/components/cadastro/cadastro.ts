import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-cadastro',
  standalone: true,
  imports: [FormsModule, RouterLink, CommonModule],
  templateUrl: './cadastro.html',
  styleUrl: './cadastro.scss'
})
export class Cadastro {
  nome = '';
  email = '';
  senha = '';
  erro = '';
  sucesso = '';
  carregando = false;

  constructor(private http: HttpClient, private router: Router) {}

  cadastrar() {
    this.erro = '';
    this.sucesso = '';
    this.carregando = true;

    this.http.post('http://localhost:8081/usuarios/cadastro', {
      nome: this.nome,
      email: this.email,
      senha: this.senha
    }).subscribe({
      next: () => {
        this.sucesso = 'Conta criada com sucesso! Redirecionando...';
        setTimeout(() => this.router.navigate(['/login']), 2000);
      },
      error: (err) => {
        this.erro = err.error?.message || 'Erro ao criar conta. Tente novamente.';
        this.carregando = false;
      }
    });
  }
}