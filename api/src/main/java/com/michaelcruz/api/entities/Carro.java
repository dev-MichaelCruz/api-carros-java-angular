package com.michaelcruz.api.entities;

import com.michaelcruz.api.enums.EnumMarca;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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
}