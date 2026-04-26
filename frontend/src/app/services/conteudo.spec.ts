import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { ConteudoService } from './conteudo';

describe('ConteudoService', () => {
  let service: ConteudoService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [ConteudoService]
    });
    service = TestBed.inject(ConteudoService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('deve ser criado', () => {
    expect(service).toBeTruthy();
  });

  it('deve chamar o endpoint correto ao listar conteúdos', () => {
    const mockConteudos = [
      { id: 1, titulo: 'Naruto', descricao: 'Um ninja', genero: 'Ação', tipo: 'SERIE', anoLancamento: 2002, urlImagem: '' }
    ];

    service.listarTodos().subscribe(conteudos => {
      expect(conteudos.length).toBe(1);
      expect(conteudos[0].titulo).toBe('Naruto');
    });

    const req = httpMock.expectOne('http://localhost:8081/conteudos');
    expect(req.request.method).toBe('GET');
    req.flush(mockConteudos);
  });
});