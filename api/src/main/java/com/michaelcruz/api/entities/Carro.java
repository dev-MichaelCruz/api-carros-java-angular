package com.michaelcruz.api.entities;

import jakarta.persistence.*;
import lombok.Data;

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

    @OneToOne
    @JoinColumn(name = "marca_idmarca")
    private Marca marca;

    @ManyToOne
    @JoinTable(name = "carro_cor",
            joinColumns = @JoinColumn(name = "carro_idcarro"),
            inverseJoinColumns = @JoinColumn(name = "cor_idcor"))
    private Cor cor;

}