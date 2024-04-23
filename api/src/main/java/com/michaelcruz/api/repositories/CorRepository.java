package com.michaelcruz.api.repositories;

import com.michaelcruz.api.entities.Cor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CorRepository extends JpaRepository<Cor, Long> {

    Optional<Cor> findByNome(String nome);
}
