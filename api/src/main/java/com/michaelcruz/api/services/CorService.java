package com.michaelcruz.api.services;

import com.michaelcruz.api.entities.Cor;
import com.michaelcruz.api.repositories.CorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CorService {

    @Autowired
    private CorRepository corRepository;

    public void adicionarCor(List<Cor> cores){

        for (Cor cor : cores) {
            Optional<Cor> corExistente = corRepository.findByNome(cor.getNome());

            if(corExistente.isPresent()){
                cor.setId(corExistente.get().getId());
                corRepository.save(cor);
            } else {
                corRepository.save(cor);
            }
        }

    }

}
