import { TestBed } from '@angular/core/testing';
import { Login } from './login';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { RouterTestingModule } from '@angular/router/testing';

describe('Login', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Login, HttpClientTestingModule, RouterTestingModule],
    }).compileComponents();
  });

  it('deve criar o componente', () => {
    const fixture = TestBed.createComponent(Login);
    expect(fixture.componentInstance).toBeTruthy();
  });

  it('deve iniciar com erro vazio', () => {
    const fixture = TestBed.createComponent(Login);
    expect(fixture.componentInstance.erro).toBe('');
  });

  it('deve iniciar com email vazio', () => {
    const fixture = TestBed.createComponent(Login);
    expect(fixture.componentInstance.email).toBe('');
  });
});