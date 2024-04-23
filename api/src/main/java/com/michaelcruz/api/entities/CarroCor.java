package com.michaelcruz.api.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "carro_cor")
public class CarroCor {

    @Id
    @ManyToOne
    @JoinColumn(name = "carro_idcarro")
    private Carro carro;

    @Id
    @ManyToOne
    @JoinColumn(name = "cor_idcor")
    private Cor cor;
}