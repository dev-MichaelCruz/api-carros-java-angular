import { Router } from '@angular/router';
import { CarroService } from './../../services/carro-service.service';
import { Component } from '@angular/core';
import { CorService } from 'src/app/services/cor.service';

@Component({
  selector: 'app-card-inicio',
  templateUrl: './card-inicio.component.html',
  styleUrls: ['./card-inicio.component.css']
})
export class CardInicioComponent {

  constructor(private router: Router,
              private carroService: CarroService,
              private corService: CorService
  ){}

  redirecionar(rota: string) {
    this.router.navigate([rota])
  }

  buscarDados() {
    this.corService.buscarCores();
  }
}
