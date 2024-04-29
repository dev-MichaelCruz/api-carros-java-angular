package com.michaelcruz.api.controllers;

import com.michaelcruz.api.entities.Carro;
import com.michaelcruz.api.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carros")
@CrossOrigin(value = "http://localhost:4200",
             methods = {RequestMethod.GET,
                        RequestMethod.POST,
                        RequestMethod.PUT,
                        RequestMethod.DELETE})
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping
    public List<Carro> listarCarros(){
        return carroService.listarCarros();
    }

    @PostMapping
    public ResponseEntity adicionarCarro(@RequestBody Carro carro){
        return this.carroService.adicionarCarro(carro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carro> atualizarCarro(@PathVariable("id") Long id, @RequestBody Carro carro){
        return this.carroService.atualizarCarro(id, carro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluirCarro(@PathVariable("id") Long id) throws Exception{
        this.carroService.excluirCarro(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
