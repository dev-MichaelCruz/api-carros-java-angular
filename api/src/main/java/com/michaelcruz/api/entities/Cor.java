package com.michaelcruz.api.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cor")
public class Cor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcor")
    private Long id;

    @Column(name = "nomecor")
    private String nome;

    public Cor() {}

    public Cor(String nome) {
        this.nome = nome;
    }
}
