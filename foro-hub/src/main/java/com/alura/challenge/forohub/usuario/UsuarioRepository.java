package com.alura.challenge.forohub.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioModelo, Long> {
    Optional<UsuarioModelo> findByUsername(String username);
}
