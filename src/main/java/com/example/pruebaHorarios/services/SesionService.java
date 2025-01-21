package com.example.pruebaHorarios.services;

import com.example.pruebaHorarios.entities.Sesion;
import com.example.pruebaHorarios.repositories.SesionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SesionService {

    @Autowired
    private SesionRepository sesionRepository;

    // Crear o agregar una nueva sesión
    public Sesion crearSesion(Sesion sesion) {
        return sesionRepository.save(sesion);
    }

    // Obtener todas las sesiones
    public List<Sesion> obtenerSesiones() {
        return sesionRepository.findAll();
    }

    // Obtener sesiones por día
    public List<Sesion> obtenerSesionesPorDia(String dia) {
        return sesionRepository.findByDia(dia);
    }

    // Obtener sesiones por ID de módulo
    public List<Sesion> obtenerSesionesPorModulo(int moduloId) {
        return sesionRepository.findByModuloId(moduloId);
    }

    // Obtener una sesión por ID
    public Optional<Sesion> obtenerSesionPorId(int idSesion) {
        return sesionRepository.findById(idSesion);
    }

    // Eliminar una sesión
    public void eliminarSesion(int idSesion) {
        sesionRepository.deleteById(idSesion);
    }
}