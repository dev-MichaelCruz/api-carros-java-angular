import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Carro } from '../model/Carro';
import { Observable } from 'rxjs';

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
  buscarCarros(): Observable<Carro[]>{
    return this.http.get<Carro[]>(this.apiUrl)
  }


  adicionarCarro(carro: Carro): void {
    this.http.post(this.apiUrl, {carro}).subscribe({
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
