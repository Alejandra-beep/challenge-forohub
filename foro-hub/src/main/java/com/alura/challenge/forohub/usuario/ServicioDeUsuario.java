package com.alura.challenge.forohub.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioDeUsuario {
    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModelo> listaUsuarios() {
        return (ArrayList<UsuarioModelo>) usuarioRepository.findAll();
    }
}
