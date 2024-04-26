import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Carro } from '../model/Carro';

@Injectable({
  providedIn: 'root'
})
export class CarroService {

  apiUrl = "http://localhost:8080/api/v1/carros";

  listaCarros: Carro[] =[];

  constructor(private http: HttpClient,
              private router: Router) {
  }

  //VOID
  buscarCarros(): void {
    this.http.get<Carro[]>(this.apiUrl).subscribe({
      next: (lista: Carro[]) => {
        this.listaCarros = [];
        lista.forEach(carro => {
          this.listaCarros.push(carro);
        });
        console.log(this.listaCarros);

      },
      error: error => {
        console.error('Erro ao buscar tabela:', error);
      }
    });
  }



  adicionarCarro(carro: Carro): void {
    this.http.post(this.apiUrl, carro).subscribe({
      next: response => console.log(response)
    })
  }

  atualizarCarro(idCarro: number, carroAtualizar: Carro): void {
    this.http.put(`${this.apiUrl}/${idCarro}`, carroAtualizar ).subscribe({
      next: response => console.log(response)
    })
  }

  excluirCarro(idCarro: number): void {
    this.http.delete(`${this.apiUrl}/${idCarro}`)
  }
}
