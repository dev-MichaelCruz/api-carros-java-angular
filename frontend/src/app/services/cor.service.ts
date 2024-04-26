import { Injectable } from '@angular/core';
import { Cor } from '../model/Cor';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CorService {

  apiUrl = "http://localhost:8080/api/v1/cores";
  listaCores: Cor[] =[];

  constructor(private http: HttpClient) { }

  //OK
  buscarCores(): void {
    this.http.get<Cor[]>(this.apiUrl).subscribe({
      next: (lista: Cor[]) => {
        this.listaCores = [];
        lista.forEach(cor => {
          this.listaCores.push(cor);
        });
        console.log(this.listaCores);

      },
      error: error => {
        console.error('Erro ao buscar tabela:', error);
      }
    });
  }

  adicionarCor(listaCores: Cor[]): void {
    this.http.post<Cor[]>(this.apiUrl, listaCores)
  }
}
