import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cadastro-form',
  templateUrl: './cadastro-form.component.html',
  styleUrls: ['./cadastro-form.component.css']
})
export class CadastroFormComponent {

constructor(private router: Router) { }

  redirecionar(rota: string) {
    this.router.navigate([rota])
  }

}
