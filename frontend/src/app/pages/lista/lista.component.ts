import { CarroService } from './../../services/carro-service.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Carro } from 'src/app/model/Carro';

@Component({
  selector: 'app-lista',
  templateUrl: './lista.component.html',
  styleUrls: ['./lista.component.css']
})
export class ListaComponent implements OnInit {
number(arg0: number|undefined): number {
throw new Error('Method not implemented.');
}

  listaCarros: Carro[] = []

  constructor(private router: Router,
              private carroService: CarroService
  ) { }

  ngOnInit(): void {
    this.carroService.buscarCarros().subscribe({
      next: (lista: Carro[]) => {
        this.listaCarros = lista
      }
    })
  }

  excluirCarro(id: number): void {
    this.carroService.excluirCarro(id)
  }

  redirecionar(rota: string) {
    this.router.navigate([rota])
  }

  num(id: any): number {
    let numero = Number(id)
    return numero
  }
}
