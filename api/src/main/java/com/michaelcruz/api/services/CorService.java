package com.michaelcruz.api.services;

import com.michaelcruz.api.entities.Cor;
import com.michaelcruz.api.repositories.CorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorService {

    @Autowired
    private CorRepository corRepository;

    public void adicionarCor(Cor cor){
        corRepository.save(cor);
    }

}
