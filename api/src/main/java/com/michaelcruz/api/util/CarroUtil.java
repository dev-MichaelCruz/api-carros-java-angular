package com.michaelcruz.api.util;

import com.michaelcruz.api.entities.Carro;
import com.michaelcruz.api.repositories.CarroRepository;
import com.michaelcruz.api.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CarroUtil {

    @Autowired
    private CarroRepository carroRepository;

    public boolean verificarCadastro(Carro carro) {
        return carroRepository.findByNome(carro.getNome()).isPresent();
    }

}
