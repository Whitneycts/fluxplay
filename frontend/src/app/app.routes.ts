import { Routes } from '@angular/router';
import { Login } from './components/login/login';
import { Catalogo } from './components/catalogo/catalogo';
import { Cadastro } from './components/cadastro/cadastro';

export const routes: Routes = [
  { path: '', component: Catalogo },
  { path: 'filmes', component: Catalogo, data: { filtro: 'filmes' } },
  { path: 'series', component: Catalogo, data: { filtro: 'series' } },
  { path: 'login', component: Login },
  { path: 'cadastro', component: Cadastro }
];