package com.michaelcruz.api.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "carro")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcarro")
    private Long id;

    @Column(name = "nomecarro")
    private String nome;

    @Column(name = "anofabricacaocarro")
    private int anoFabricacao;

    @Column(name = "anomodelocarro")
    private int anoModelo;

    @Column(name = "modelocarro")
    private String modelo;

    @ManyToOne
    @JoinColumn(name = "marca_idmarca")
    private Marca marca;

    @ManyToMany
    @JoinTable(name = "carro_cor",
            joinColumns = @JoinColumn(name = "carro_idcarro"),
            inverseJoinColumns = @JoinColumn(name = "cor_idcor"))
    private List<Cor> cores;

}