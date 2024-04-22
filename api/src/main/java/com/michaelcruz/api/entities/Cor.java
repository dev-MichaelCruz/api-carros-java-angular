package com.michaelcruz.api.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Cor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCor;

    @Column(name = "nomecor")
    private String nomeCor;
}
