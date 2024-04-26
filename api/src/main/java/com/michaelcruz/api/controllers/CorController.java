package com.michaelcruz.api.controllers;

import com.michaelcruz.api.entities.Cor;
import com.michaelcruz.api.services.CorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cores")
@CrossOrigin(value = "http://localhost:4200",
        methods = {RequestMethod.GET,
                RequestMethod.POST,
                RequestMethod.PUT,
                RequestMethod.DELETE})
public class CorController {

    @Autowired
    private CorService corService;

    @GetMapping
    public List<Cor> listarCores() {
        return this.corService.listarCores();
    }

    @PostMapping
    public void adicionarCores(@RequestBody List<Cor> cores) {
        this.corService.adicionarCor(cores);
    }
}
