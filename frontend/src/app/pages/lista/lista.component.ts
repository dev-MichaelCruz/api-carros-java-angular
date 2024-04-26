import { CarroService } from './../../services/carro-service.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-lista',
  templateUrl: './lista.component.html',
  styleUrls: ['./lista.component.css']
})
export class ListaComponent implements OnInit {

  carregando!: boolean;

  constructor(private router: Router,
              private carroService: CarroService
  ) { }

  ngOnInit(): void {
    this.carregando = true
    this.carregarTabela()

  }
  carregarTabela(): void {
  }

  redirecionar(rota: string) {
    this.router.navigate([rota])
  }

}
