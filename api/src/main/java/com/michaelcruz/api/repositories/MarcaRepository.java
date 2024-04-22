package com.michaelcruz.api.repositories;

import com.michaelcruz.api.entities.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
}
