package com.alura.challenge.forohub.sujeto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SujetoRepository extends JpaRepository<SujetoModelo, Long> {
}
