package com.michaelcruz.api.util;

import com.michaelcruz.api.entities.Carro;
import com.michaelcruz.api.repositories.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CarroUtil {

    @Autowired
    private CarroRepository carroRepository;

    public boolean verificarCadastro(Carro carro) {

        Optional<Carro> carroOptional = carroRepository.findByNome(carro.getNome());

        if (carroOptional.isPresent()) {
            if (carro.getAnoFabricacao() == carroOptional.get().getAnoFabricacao()
                && carro.getAnoModelo() == carroOptional.get().getAnoModelo()
                && carro.getModelo().equals(carroOptional.get().getModelo())
                && carro.getMarca() == carroOptional.get().getMarca()){
                return true;
            }
        }
        return false;
    }
}
