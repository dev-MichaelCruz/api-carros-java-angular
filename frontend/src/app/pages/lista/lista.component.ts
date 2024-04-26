import { CarroService } from './../../services/carro-service.service';
import { Component, DoCheck, OnChanges, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Carro } from 'src/app/model/Carro';

@Component({
  selector: 'app-lista',
  templateUrl: './lista.component.html',
  styleUrls: ['./lista.component.css']
})
export class ListaComponent implements OnInit {

  carregando!: boolean;

  listaCarros: Carro[] = []
  carroExclusao!: Carro;


  constructor(private router: Router,
              private carroService: CarroService
  ) { }

  ngOnInit(): void {
    setTimeout(() => {
      this.carregando= true
    }, 20000);
    this.carroService.buscarCarros().subscribe({
      next: (lista: Carro[]) => {
        this.listaCarros = lista
      }
    })
    this.carregando =false
  }

  buscarCarroExclusao(index: number): void {
    this.carroExclusao = this.listaCarros[index]
  }


  excluirCarro(id: number): void {
    this.carroService.excluirCarro(id)
  }

  redirecionar(rota: string) {
    this.router.navigate([rota])
  }

}
