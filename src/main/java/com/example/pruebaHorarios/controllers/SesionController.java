package com.example.pruebaHorarios.controllers;

import com.example.pruebaHorarios.entities.Sesion;
import com.example.pruebaHorarios.services.SesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sesiones")
public class SesionController {

    @Autowired
    private SesionService sesionService;

    // Crear una nueva sesión
    @PostMapping
    public ResponseEntity<Sesion> crearSesion(@RequestBody Sesion sesion) {
        Sesion nuevaSesion = sesionService.crearSesion(sesion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaSesion);
    }

    // Obtener todas las sesiones
    @GetMapping
    public ResponseEntity<List<Sesion>> obtenerSesiones() {
        List<Sesion> sesiones = sesionService.obtenerSesiones();
        return ResponseEntity.ok(sesiones);
    }

    // Obtener sesiones por día
    @GetMapping("/dia/{dia}")
    public ResponseEntity<List<Sesion>> obtenerSesionesPorDia(@PathVariable String dia) {
        List<Sesion> sesiones = sesionService.obtenerSesionesPorDia(dia);
        return ResponseEntity.ok(sesiones);
    }

    // Obtener sesiones por ID de módulo
    @GetMapping("/modulo/{idModulo}")
    public ResponseEntity<List<Sesion>> obtenerSesionesPorModulo(@PathVariable int idModulo) {
        List<Sesion> sesiones = sesionService.obtenerSesionesPorModulo(idModulo);
        return ResponseEntity.ok(sesiones);
    }

    // Obtener sesión por ID
    @GetMapping("/{idSesion}")
    public ResponseEntity<Sesion> obtenerSesionPorId(@PathVariable int idSesion) {
        Optional<Sesion> sesion = sesionService.obtenerSesionPorId(idSesion);
        return sesion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Eliminar una sesión
    @DeleteMapping("/{idSesion}")
    public ResponseEntity<Void> eliminarSesion(@PathVariable int idSesion) {
        sesionService.eliminarSesion(idSesion);
        return ResponseEntity.noContent().build();
    }
}