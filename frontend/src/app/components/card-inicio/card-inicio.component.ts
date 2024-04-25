import { Router } from '@angular/router';
import { CarroServiceService } from './../../services/carro-service.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-card-inicio',
  templateUrl: './card-inicio.component.html',
  styleUrls: ['./card-inicio.component.css']
})
export class CardInicioComponent {

  constructor(private router: Router){}

  redirecionar(rota: string) {
    this.router.navigate([rota])
  }
}
