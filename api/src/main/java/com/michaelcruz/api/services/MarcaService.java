package com.michaelcruz.api.services;

import com.michaelcruz.api.entities.Marca;
import com.michaelcruz.api.repositories.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> listarMarcas() {
        return marcaRepository.findAll();
    }

    public void adicionarMarca(Marca marca) {
        this.marcaRepository.save(marca);
    }
}
