import { TestBed } from '@angular/core/testing';
import { Catalogo } from './catalogo';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { RouterTestingModule } from '@angular/router/testing';

describe('Catalogo', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Catalogo, HttpClientTestingModule, RouterTestingModule],
    }).compileComponents();
  });

  it('deve criar o componente', () => {
    const fixture = TestBed.createComponent(Catalogo);
    expect(fixture.componentInstance).toBeTruthy();
  });

  it('deve iniciar com listas vazias', () => {
    const fixture = TestBed.createComponent(Catalogo);
    expect(fixture.componentInstance.filmes.length).toBe(0);
    expect(fixture.componentInstance.series.length).toBe(0);
  });

  it('deve iniciar carregando', () => {
    const fixture = TestBed.createComponent(Catalogo);
    expect(fixture.componentInstance.carregando).toBeTrue();
  });
});