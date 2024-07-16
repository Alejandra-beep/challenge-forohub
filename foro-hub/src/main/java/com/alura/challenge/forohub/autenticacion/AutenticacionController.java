package com.alura.challenge.forohub.autenticacion;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AutenticacionController {
    private final ServicioAutenticacion authService;

    @PostMapping(value = "register")
    public ResponseEntity<RespuestaDeAutenticacion> register(@RequestBody RegistraRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping(value = "login")
    public ResponseEntity<RespuestaDeAutenticacion> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}
