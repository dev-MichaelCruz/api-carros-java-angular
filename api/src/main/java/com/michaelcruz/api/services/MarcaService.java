package com.michaelcruz.api.services;

import com.michaelcruz.api.entities.Marca;
import com.michaelcruz.api.repositories.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> listarMarcas() {
        return marcaRepository.findAll();
    }

    public void adicionarMarca(Marca marca) {

        Optional<Marca> optionalMarca = marcaRepository.findByNome(marca.getNome());

        if (optionalMarca.isPresent()) {
            marca.setId(optionalMarca.get().getId());
            this.marcaRepository.save(marca);

        } else {
            this.marcaRepository.save(marca);
        }
    }
}
