package com.alura.challenge.forohub.autenticacion;

import com.alura.challenge.forohub.usuario.UsuarioModelo;
import com.alura.challenge.forohub.usuario.UsuarioRepository;
import com.alura.challenge.forohub.usuario.RolDeUsuario;
import com.alura.challenge.forohub.jsonwebtoken.ServicioDeAutenticacion;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioAutenticacion {
    private final ServicioDeAutenticacion servicioDeAutenticacion;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public RespuestaDeAutenticacion register(RegistraRequest request) {
        UsuarioModelo usuarioModelo = UsuarioModelo.builder()
                .nombre(request.getNombre())
                .apellido(request.getApellido())
                .contraseña(passwordEncoder.encode(request.getContraseña()))
                .disponible(true)
                .rol(RolDeUsuario.USER)
                .build();
        usuarioRepository.save(usuarioModelo);
        return RespuestaDeAutenticacion.builder()
                .token(servicioDeAutenticacion.getToken(usuarioModelo))
                .build();
    }

    public RespuestaDeAutenticacion login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsuario(), request.getContraseña()));
        UserDetails user = usuarioRepository.findByUsername(request.getUsuario()).orElseThrow();
        String token = servicioDeAutenticacion.getToken(user);
        return RespuestaDeAutenticacion.builder()
                .token(token)
                .build();
    }
}
