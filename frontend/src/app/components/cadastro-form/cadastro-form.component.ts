import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Cor } from 'src/app/model/Cor';
import { CorService } from 'src/app/services/cor.service';

@Component({
  selector: 'app-cadastro-form',
  templateUrl: './cadastro-form.component.html',
  styleUrls: ['./cadastro-form.component.css']
})
export class CadastroFormComponent implements OnInit {

  constructor(private router: Router, private corService: CorService) { }

  novaCor: string = ''
  listaCores: Cor[] = []

  ngOnInit(): void {

  }

  adicionarCorNaLista(nome: string) {
    this.listaCores.push(new Cor(nome));
    this.novaCor = ``
  }

  submeterCores(){
    this.corService.adicionarCor(this.listaCores);
  }

  redirecionar(rota: string) {
    this.router.navigate([rota])
  }

}
