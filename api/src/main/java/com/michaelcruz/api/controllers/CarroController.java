package com.michaelcruz.api.controllers;

import com.michaelcruz.api.entities.Carro;
import com.michaelcruz.api.services.CarroService;
import com.michaelcruz.api.services.CarroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carros")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping
    public ResponseEntity<List<Carro>> listarCarros(){
        return ResponseEntity.ok(carroService.listarCarros());
    }

    @PostMapping
    public ResponseEntity<Carro> adicionarCarro(@RequestBody Carro carro){
        this.carroService.adicionarCarro(carro);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carro> atualizarCarro(@PathVariable("id") Long id, @RequestBody Carro carro){
        this.carroService.atualizarCarro(id, carro);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluirCarro(@PathVariable("id") Long id) throws Exception{
        this.carroService.excluirCarro(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
