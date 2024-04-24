package com.michaelcruz.api.services;

import com.michaelcruz.api.entities.Carro;

import java.util.List;

public interface CarroService {

    List<Carro> listarCarros();
    void adicionarCarro(Carro carro);
    void excluirCarro(Long id);
    void atualizarCarro(Long id, Carro carro);
}
