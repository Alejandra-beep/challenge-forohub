package com.alura.challenge.forohub.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class UsuarioController {
    @Autowired
    private ServicioDeUsuario servicioDeUsuario;

    @GetMapping
    public ResponseEntity<ArrayList<UsuarioModelo>> listUsers() {
        ArrayList<UsuarioModelo> arrayList = (ArrayList<UsuarioModelo>) this.servicioDeUsuario.listaUsuarios();
        return ResponseEntity.ok(arrayList);
    }
}
