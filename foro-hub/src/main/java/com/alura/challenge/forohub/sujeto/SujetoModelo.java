package com.alura.challenge.forohub.sujeto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sujetos")
public class SujetoModelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long id_sujeto;
    private String curso;
    private String titulo;
    private String mensaje;
    private Boolean disponible;
}
