package com.alura.challenge.forohub.usuario;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UsuarioDTO(
        @JsonAlias("nombre") String nombre,
        @JsonAlias("apellido") String apellido,
        @JsonAlias("contraseña") String contraseña,
        @JsonAlias("Disponible") Boolean disponible
) {
}
