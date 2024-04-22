package com.michaelcruz.api.controllers;

import com.michaelcruz.api.entities.Carro;
import com.michaelcruz.api.repositories.CarroRepository;
import com.michaelcruz.api.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carros")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping
    public List<Carro> listarCarros(){
        return this.carroService.listarCarros();
    }

    @PostMapping
    public void adicionarCarro(@RequestBody Carro carro){
        this.carroService.adicionarCarro(carro);
    }
}
