package com.alura.challenge.forohub.sujeto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SujetoDTO(
        @JsonAlias("id_usuario") Long id_usuario,
        @JsonAlias("curso") String curso,
        @JsonAlias("titulo") String titulo,
        @JsonAlias("mensaje") String mensaje,
        @JsonAlias("disponible") Boolean disponible
) {
}
