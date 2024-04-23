package com.michaelcruz.api.services;

import com.michaelcruz.api.entities.Carro;
import com.michaelcruz.api.entities.Cor;
import com.michaelcruz.api.entities.Marca;
import com.michaelcruz.api.repositories.CarroRepository;
import com.michaelcruz.api.repositories.CorRepository;
import com.michaelcruz.api.repositories.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;
    @Autowired
    private CorService corService;
    @Autowired
    private MarcaService marcaService;

    public List<Carro> listarCarros() {
        return carroRepository.findAll();
    }

    public void adicionarCarro(Carro carro) {
        marcaService.adicionarMarca(carro.getMarca());
        corService.adicionarCor(carro.getCores());
        carroRepository.save(carro);
    }
}
