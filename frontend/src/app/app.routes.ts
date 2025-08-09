import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: 'cidades',
    loadComponent: () =>
      import('./pages/cidade-list').then(m => m.CidadeListComponent)
  },
  { path: '', redirectTo: 'cidades', pathMatch: 'full' }
];