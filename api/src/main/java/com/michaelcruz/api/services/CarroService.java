package com.michaelcruz.api.services;

import com.michaelcruz.api.entities.Carro;
import com.michaelcruz.api.entities.Cor;
import com.michaelcruz.api.repositories.CarroRepository;
import com.michaelcruz.api.util.CarroUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    private final CarroRepository carroRepository;
    private final CorService corService;
    private final MarcaService marcaService;
    private final CarroUtil carroUtil;

    @Autowired
    public CarroService(CarroRepository carroRepository,
                        CorService corService,
                        MarcaService marcaService,
                        CarroUtil carroUtil) {
        this.carroRepository = carroRepository;
        this.corService = corService;
        this.marcaService = marcaService;
        this.carroUtil = carroUtil;
    }

    public List<Carro> listarCarros() {
        return carroRepository.findAll();
    }

    public void adicionarCarro(Carro carro) {

        if(carroUtil.verificarCadastro(carro)) {
            Long carroId = carroRepository.findByNome(carro.getNome()).get().getId();
            atualizarCarro(carroId, carro);
        } else {
            marcaService.adicionarMarca(carro.getMarca());
            corService.adicionarCor(carro.getCores());
            carroRepository.save(carro);
        }
    }

    public void atualizarCarro(Long id, Carro novoCarro) {

        Optional<Carro> carroOptional = carroRepository.findById(id);


        if (carroOptional.isPresent()) {

            Carro carroAtual = carroOptional.get();

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

    public ResponseEntity excluirCarro(Long id){
        try {
            carroRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
