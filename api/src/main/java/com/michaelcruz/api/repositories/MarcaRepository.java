package com.michaelcruz.api.repositories;

import com.michaelcruz.api.entities.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MarcaRepository extends JpaRepository<Marca, Long> {

    Optional<Marca> findByNome(String nome);
}
