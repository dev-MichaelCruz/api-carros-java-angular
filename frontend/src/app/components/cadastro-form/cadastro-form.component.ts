import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Cor } from 'src/app/model/Cor';
import { CarroService } from 'src/app/services/carro-service.service';
import { Carro } from 'src/app/model/Carro';
import { Marca } from 'src/app/model/Marca';

@Component({
  selector: 'app-cadastro-form',
  templateUrl: './cadastro-form.component.html',
  styleUrls: ['./cadastro-form.component.css']
})
export class CadastroFormComponent implements OnInit {

  constructor(private router: Router, private carroService: CarroService) { }

  novaCor: string = ''
  listaCores: Cor[] = []

  nomeCarro!: string;
  anoFabricacao!: number;
  anoModelo!: number;
  modelo!: string;
  marcaNome!: string;

  ngOnInit(): void {

  }

  adicionarCorNaLista(nome: string) {
    this.listaCores.push(new Cor(nome));
    this.novaCor = ``
  }

  adicionarCarro(){
    const marca = new Marca(this.marcaNome)
    const novoCarro = new Carro(this.nomeCarro, this.anoFabricacao,
      this.anoModelo, this.modelo, marca, this.listaCores)

    this.carroService.adicionarCarro(novoCarro)
  }

  redirecionar(rota: string) {
    this.router.navigate([rota])
  }

}
