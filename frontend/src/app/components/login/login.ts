import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { AuthService } from '../../services/auth';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, RouterLink, CommonModule],
  templateUrl: './login.html',
  styleUrl: './login.scss'
})
export class Login {
  email = '';
  senha = '';
  erro = '';
  carregando = false;

  constructor(private authService: AuthService, private router: Router) {}

  entrar() {
    this.erro = '';
    this.carregando = true;

    this.authService.login({ email: this.email, senha: this.senha }).subscribe({
      next: (resposta) => {
        this.authService.salvarUsuario(resposta);
        this.router.navigate(['/']);
      },
      error: () => {
        this.erro = 'Email ou senha incorretos.';
        this.carregando = false;
      }
    });
  }
}