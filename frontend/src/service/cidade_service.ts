import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Cidade {
  id?: string;
  nome: string;
  estado: string;
}

@Injectable({
  providedIn: 'root'
})
export class CidadeService {
  private apiUrl = 'http://localhost:8080/api/cidades';

  constructor(private http: HttpClient) {}

  getAll(): Observable<Cidade[]> {
    return this.http.get<Cidade[]>(this.apiUrl);
  }

  getById(id: string): Observable<Cidade> {
    return this.http.get<Cidade>(`${this.apiUrl}/${id}`);
  }

  create(cidade: Cidade): Observable<Cidade> {
    return this.http.post<Cidade>(this.apiUrl, cidade);
  }

  update(id: string, cidade: Cidade): Observable<Cidade> {
    return this.http.put<Cidade>(`${this.apiUrl}/${id}`, cidade);
  }

  delete(id: string): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}