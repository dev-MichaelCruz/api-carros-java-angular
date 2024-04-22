package com.michaelcruz.api.repositories;

import com.michaelcruz.api.entities.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {
}
