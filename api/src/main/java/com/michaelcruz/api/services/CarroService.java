package com.michaelcruz.api.services;

import com.michaelcruz.api.entities.Carro;
import com.michaelcruz.api.entities.Cor;
import com.michaelcruz.api.entities.Marca;
import com.michaelcruz.api.repositories.CarroRepository;
import com.michaelcruz.api.repositories.CorRepository;
import com.michaelcruz.api.repositories.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public void atualizarCarro(Long id, Carro novoCarro) {
        Optional<Carro> carroOptional = carroRepository.findById(id);

        if (carroOptional.isPresent()) {

            Carro carroAtual = carroOptional.get();

            carroAtual.setNome(novoCarro.getNome());
            carroAtual.setAnoFabricacao(novoCarro.getAnoFabricacao());
            carroAtual.setAnoModelo(novoCarro.getAnoModelo());
            carroAtual.setModelo(novoCarro.getModelo());

            if (novoCarro.getMarca() != null) {
                marcaService.adicionarMarca(novoCarro.getMarca());
                carroAtual.setMarca(novoCarro.getMarca());
            }
            if (novoCarro.getCores() != null) {
                for (Cor cor : novoCarro.getCores()) {
                    List<Cor> coresAtual = new ArrayList<>();
                    coresAtual.add(cor);
                    corService.adicionarCor(coresAtual);
                }
                carroAtual.setCores(novoCarro.getCores());
            }

            carroRepository.save(carroAtual);
        }
    }
}
