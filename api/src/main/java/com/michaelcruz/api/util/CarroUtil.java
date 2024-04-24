package com.michaelcruz.api.util;

import com.michaelcruz.api.entities.Carro;
import com.michaelcruz.api.entities.Cor;
import com.michaelcruz.api.repositories.CarroRepository;
import com.michaelcruz.api.services.CorService;
import com.michaelcruz.api.services.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CarroUtil {

    @Autowired
    private CarroRepository carroRepository;
    @Autowired
    private MarcaService marcaService;
    @Autowired
    private CorService corService;

    public boolean verificarCadastro(Carro carro) {
        return carroRepository.findByNome(carro.getNome()).isPresent();
    }

    public boolean verificarDadosCarro(Carro carro) {

        Optional<List<Carro>> carroOptionalList = carroRepository.findByNome(carro.getNome());

        for (Carro carroOptional : carroOptionalList.get()) {
            if (carroOptional.getId() == carro.getId()
                    && carroOptional.getNome().equals(carro.getNome())
                    && carroOptional.getAnoFabricacao() == carro.getAnoFabricacao()
                    && carroOptional.getAnoModelo() == carro.getAnoModelo()
                    && carroOptional.getModelo().equals(carro.getModelo())){

                return true;
            }
        }
        return false;
    }

    public void confirmarAdicao(Carro carro) {
        marcaService.adicionarMarca(carro.getMarca());
        corService.adicionarCor(carro.getCores());
        carroRepository.save(carro);
    }

}
