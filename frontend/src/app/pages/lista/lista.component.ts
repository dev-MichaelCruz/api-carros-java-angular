import { CarroService } from './../../services/carro-service.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
// import { Observable } from 'rxjs';
import { Carro } from 'src/app/model/Carro';
import { Cor } from 'src/app/model/Cor';
import { Marca } from 'src/app/model/Marca';

@Component({
  selector: 'app-lista',
  templateUrl: './lista.component.html',
  styleUrls: ['./lista.component.css']
})
export class ListaComponent implements OnInit {

  carregando!: boolean;

  listaCarros: Carro[] = []

  novaCor!: string;

  selId!: number;
  selNome!: string;
  selModelo!: string;
  selAnoFab!: number;
  selAnoMod!: number;
  selMarca!: string;
  selCores!: Cor[]

  constructor(private router: Router,
              private carroService: CarroService
  ) { }

  ngOnInit(): void {
    // setTimeout(() => {
    //   this.carregando = true
    //   this.carroService.buscarCarros().subscribe({
    //     next: (lista: Carro[]) => {
    //       lista.map( (carro: Carro) => {
    //         this.listaCarros.push(carro)
    //       })
    //     }
    //   })
    // }, 2000);
    // this.carregando =false
    this.atualizarTabela();
  }

  async buscarDados(index: number): Promise<any> {
    const carroExclusao = this.listaCarros[index]

    this.selId = carroExclusao.id;
    this.selNome = carroExclusao.nome;
    this.selModelo = carroExclusao.modelo
    this.selAnoFab = carroExclusao.anoFabricacao;
    this.selAnoMod = carroExclusao.anoModelo;
    this.selMarca = carroExclusao.marca.nome
    this.selCores = carroExclusao.cores
    console.log(this.selCores);
  }


  excluirCarro(id: number): void {
    this.carroService.excluirCarro(id)
    this.atualizarTabela();
    this.redirecionar('')
  }

  redirecionar(rota: string) {
    this.router.navigate([rota])
  }

  adicionarCor(nome: string){
    this.selCores.push(new Cor(nome));
    this.novaCor = ''
  }

  excluirCor(index: number){
    this.selCores.splice(index, 1);
  }

  atualizarCarro(){
    const carroAtualizado = new Carro(
      this.selNome, this.selAnoFab, this.selAnoMod, this.selModelo, new Marca(this.selMarca), this.selCores
    )
    this.carroService.atualizarCarro(this.selId, carroAtualizado)
  }

  atualizarTabela(){
    setTimeout(() => {
      this.carregando = true
      this.carroService.buscarCarros().subscribe({
        next: (lista: Carro[]) => {
          lista.map( (carro: Carro) => {
            this.listaCarros.push(carro)
          })
        }
      })
    }, 2000);
    this.carregando =false
  }
}
