import { Component, inject } from '@angular/core';
import { CidadeService, Cidade } from '../../service/cidade_service';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-cidade-list',
  standalone: true,
  imports: [CommonModule, RouterModule],
  template: `
    <h2>Lista de Cidades</h2>
    <ul>
      <li *ngFor="let cidade of cidades">
        {{ cidade.nome }} - {{ cidade.estado }}
      </li>
    </ul>
  `
})
export class CidadeListComponent {
  cidades: Cidade[] = [];
  private cidadeService = inject(CidadeService);

  ngOnInit() {
    this.cidadeService.getAll().subscribe(cidades => {
      this.cidades = cidades;
    });
  }
}
