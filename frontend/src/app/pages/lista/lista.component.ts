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

  redirecionar(rota: string) {
    this.router.navigate([rota])
  }

}
