package com.michaelcruz.api.entities;

import com.michaelcruz.api.enums.EnumMarca;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcarro;

    @Column(name = "nomecarro", nullable = false)
    private String nomeCarro;

    @Column(name = "anofabricacaocarro", nullable = false)
    private int anoFabricacaoCarro;

    @Column(name = "anomodelocarro", nullable = false)
    private String anoModeloCarro;

    @Column(name = "marcacarro")
    private EnumMarca marcaCarro;

    @ManyToMany
    @JoinTable(name = "idcor")
    private List<Cor> cores;
}
