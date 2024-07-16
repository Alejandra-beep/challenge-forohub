package com.alura.challenge.forohub.sujeto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/sujetos")
public class SujetoController {
    @Autowired
    private ServicioSujeto servicioSujeto; //llamamos la clase ServicioSujeto

    //para registrar
    @PostMapping
    public ResponseEntity<SujetoModelo> registroSujeto(@RequestBody SujetoModelo request) {
        SujetoModelo subjetoModelo = this.servicioSujeto.registraSujeto(request);
        return ResponseEntity.ok(subjetoModelo);
    }

    //para listar sujetos
    @GetMapping
    public ResponseEntity<ArrayList<SujetoModelo>> listaSujetos() {
        ArrayList<SujetoModelo> arrayList = (ArrayList<SujetoModelo>) this.servicioSujeto.listaSujeto();
        return ResponseEntity.ok(arrayList);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity obtenerSujeto(@PathVariable("id") Long id) {
        Optional<SujetoModelo> subjectoModelo = this.servicioSujeto.obtenerSujeto(id);
        if (subjectoModelo == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(subjectoModelo);
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<SujetoModelo> updateSubject(@PathVariable("id") Long id, @RequestBody SujetoModelo request) {
        SujetoModelo subjectModel = this.servicioSujeto.actualizaSujeto(id, request);
        if (subjectModel == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(subjectModel);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteSubject(@PathVariable("id") Long id) {
        boolean eliminado = this.servicioSujeto.eliminaSujeto(id);
        if (eliminado) {
            return ResponseEntity.ok(id);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
