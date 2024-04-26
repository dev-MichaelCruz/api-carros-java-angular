import { Router } from '@angular/router';
import { CarroService } from './../../services/carro-service.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-card-inicio',
  templateUrl: './card-inicio.component.html',
  styleUrls: ['./card-inicio.component.css']
})
export class CardInicioComponent {

  constructor(private router: Router,
              private carroService: CarroService
  ){}

  redirecionar(rota: string) {
    this.router.navigate([rota])
  }

  buscarDados() {
    this.carroService.buscarCarros();
  }
}
