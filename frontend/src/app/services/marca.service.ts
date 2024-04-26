import { Injectable } from '@angular/core';
import { Marca } from '../model/Marca';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MarcaService {

  apiUrl = "http://localhost:8080/api/v1/marcas";

  listaMarcas: Marca[] =[]

  constructor(private http: HttpClient) { }

  buscarMarcas(): void {
    this.http.get<Marca[]>(this.apiUrl).subscribe({
      next: (lista: Marca[]) => {
        this.listaMarcas = [];
        lista.forEach(cor => {
          this.listaMarcas.push(cor);
        });
        console.log(this.listaMarcas);
      }
    })
  }
}
