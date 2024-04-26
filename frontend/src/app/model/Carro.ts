import { Cor } from "./Cor";
import { Marca } from "./Marca";

export class Carro {
  id: number = 0;
  nome: string;
  anoFabricacao: number;
  anoModelo: number;
  modelo: string;
  marca: Marca;
  cores: Cor[];

  constructor(nome: string,
              anoFabricacao: number,
              anoModelo: number,
              modelo: string,
              marca: Marca,
              cores: Cor[]){

    this.nome = nome;
    this.anoFabricacao = anoFabricacao;
    this.anoModelo = anoModelo;
    this.modelo = modelo;
    this.marca = marca;
    this.cores = cores
  }
}
