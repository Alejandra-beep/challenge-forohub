package com.alura.challenge.forohub.sujeto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ServicioSujeto {
    @Autowired
    SujetoRepository sujetoRepository; //hacemos inyeccion de depencias

    public SujetoModelo registraSujeto(SujetoModelo request) {
        return sujetoRepository.save(request);
    }

    public ArrayList<SujetoModelo> listaSujeto() {
        return (ArrayList<SujetoModelo>) sujetoRepository.findAll();
    }

    public Optional<SujetoModelo> obtenerSujeto(Long id) {
        return sujetoRepository.findById(id);
    }

    //metodo para actualizar
    public SujetoModelo actualizaSujeto(Long id, SujetoModelo request) {
        SujetoModelo sujetoModelo= sujetoRepository.findById(id).get();
        sujetoModelo.setId_sujeto(request.getId_sujeto());
        sujetoModelo.setCurso(request.getCurso());
        sujetoModelo.setTitulo(request.getTitulo());
        sujetoModelo.setMensaje(request.getMensaje());
        sujetoRepository.save(sujetoModelo);
        return sujetoModelo;
    }

    //metodo para eliminar
    public Boolean eliminaSujeto(Long id) {
        try {
            sujetoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
