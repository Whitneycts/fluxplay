import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { AuthService } from './auth';

describe('AuthService', () => {
  let service: AuthService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, RouterTestingModule],
      providers: [AuthService]
    });
    service = TestBed.inject(AuthService);
  });

  it('deve ser criado', () => {
    expect(service).toBeTruthy();
  });

  it('deve salvar e recuperar usuário', () => {
    const usuario = { id: 1, nome: 'Whitney', email: 'w@gmail.com' };
    service.salvarUsuario(usuario);
    expect(service.getUsuario()?.nome).toBe('Whitney');
  });

  it('deve retornar true quando estiver logado', () => {
    const usuario = { id: 1, nome: 'Whitney', email: 'w@gmail.com' };
    service.salvarUsuario(usuario);
    expect(service.estaLogado()).toBeTrue();
  });

  it('deve retornar false após logout', () => {
    service.logout();
    expect(service.estaLogado()).toBeFalse();
  });
});