package com.michaelcruz.api.controllers;

import com.michaelcruz.api.entities.Marca;
import com.michaelcruz.api.services.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/marcas")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @GetMapping
    public List<Marca> listarMarcas() {
        return this.marcaService.listarMarcas();
    }

    @PostMapping
    public void adicionarMarca(@RequestBody Marca nomeMarca) {
        this.marcaService.adicionarMarca(nomeMarca);
    }
}
