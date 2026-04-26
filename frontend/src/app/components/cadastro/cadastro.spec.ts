import { TestBed } from '@angular/core/testing';
import { Cadastro } from './cadastro';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { RouterTestingModule } from '@angular/router/testing';

describe('Cadastro', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Cadastro, HttpClientTestingModule, RouterTestingModule],
    }).compileComponents();
  });

  it('deve criar o componente', () => {
    const fixture = TestBed.createComponent(Cadastro);
    expect(fixture.componentInstance).toBeTruthy();
  });

  it('deve iniciar com campos vazios', () => {
    const fixture = TestBed.createComponent(Cadastro);
    expect(fixture.componentInstance.nome).toBe('');
    expect(fixture.componentInstance.email).toBe('');
    expect(fixture.componentInstance.senha).toBe('');
  });
});