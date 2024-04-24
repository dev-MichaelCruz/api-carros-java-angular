package com.michaelcruz.api.repositories;

import com.michaelcruz.api.entities.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarroRepository extends JpaRepository<Carro, Long> {

    Optional<Carro> findByNome(String nome);
}
