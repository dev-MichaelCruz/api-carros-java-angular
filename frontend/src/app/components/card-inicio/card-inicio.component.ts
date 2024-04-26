import { Router } from '@angular/router';
import { CarroService } from './../../services/carro-service.service';
import { Component } from '@angular/core';
import { CorService } from 'src/app/services/cor.service';
import { MarcaService } from 'src/app/services/marca.service';

@Component({
  selector: 'app-card-inicio',
  templateUrl: './card-inicio.component.html',
  styleUrls: ['./card-inicio.component.css']
})
export class CardInicioComponent {

  constructor(private router: Router,
              private carroService: CarroService,
              private corService: CorService,
              private marcaService: MarcaService
  ){}

  redirecionar(rota: string) {
    this.router.navigate([rota])
  }

  buscarDados() {
    // this.corService.buscarCores();
    // this.carroService.buscarCarros();
    this.marcaService.buscarMarcas();
  }
}
