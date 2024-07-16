package com.alura.challenge.forohub.autenticacion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistraRequest {
    String nombre;
    String apellido;
    String contraseña;
    Boolean disponible;
}
