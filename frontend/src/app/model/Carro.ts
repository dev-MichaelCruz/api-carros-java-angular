import { Cor } from "./Cor";
import { Marca } from "./Marca";

export interface Carro {
  id?: number;
  nome: string;
  anoFabricacao: number;
  anoModelo: number;
  modelo: string;
  marca: Marca;
  cores: Cor[];
}
