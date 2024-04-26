import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Cor } from 'src/app/model/Cor';
import { CarroService } from 'src/app/services/carro-service.service';
import { Carro } from 'src/app/model/Carro';
import { Marca } from 'src/app/model/Marca';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-cadastro-form',
  templateUrl: './cadastro-form.component.html',
  styleUrls: ['./cadastro-form.component.css']
})
export class CadastroFormComponent implements OnInit {

  cadastroCarroForm: FormGroup = new FormGroup({})

  novaCor: string = '';
  listaCores: Cor[] = []

  nomeCarro!: string;
  anoFabricacao!: number;
  anoModelo!: number;
  modelo!: string;
  marcaNome!: string;

  constructor(private router: Router,
              private carroService: CarroService,
              private formBuilder: FormBuilder) { }

  ngOnInit(): void {

    this.cadastroCarroForm = this.formBuilder.group({
      nomeCarro: ['', Validators.required],
      anoFabricacao: ['', Validators.required],
      anoModelo: ['',Validators.required],
      modelo: ['', Validators.required],
      marcaNome: ['', Validators.required]
    })
  }

  adicionarCorNaLista(nome: string) {
    this.listaCores.push(new Cor(nome));
    this.novaCor = ``
  }

  // finalizarCadastro(){
  //   this.adicionarCarro();

  // }

  adicionarCarro(){
    const marca = new Marca(this.marcaNome)
    const novoCarro = new Carro(this.nomeCarro, this.anoFabricacao, this.anoModelo, this.modelo, marca, this.listaCores)

    this.carroService.adicionarCarro(novoCarro)
    this.redirecionar('lista')
  }

  excluirCor(index: number){
    this.listaCores.splice(index, 1);
  }

  async redirecionar(rota: string) {
    this.router.navigate([rota])
  }
}
