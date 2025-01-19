package com.example.pruebaHorarios.entities;

import jakarta.persistence.*;

@Entity
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int numMatricula;

    @ManyToOne
    @JoinColumn(name = "id_alumno", nullable = false)
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "id_ciclo", nullable = false)
    private Ciclo cicloFormativo;

    @ManyToOne
    @JoinColumn(name = "id_modulo", nullable = false)
    private Modulo modulo;

    // Constructor vacío (necesario para JPA)
    public Matricula() {
    }

    // Constructor con parámetros
    public Matricula(int numMatricula, Alumno alumno, Ciclo cicloFormativo, Modulo modulo) {
        this.numMatricula = numMatricula;
        this.alumno = alumno;
        this.cicloFormativo = cicloFormativo;
        this.modulo = modulo;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(int numMatricula) {
        this.numMatricula = numMatricula;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Ciclo getCicloFormativo() {
        return cicloFormativo;
    }

    public void setCicloFormativo(Ciclo cicloFormativo) {
        this.cicloFormativo = cicloFormativo;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    // Sobrescribir el método toString para depuración
    @Override
    public String toString() {
        return "Matricula{" +
                "id=" + id +
                ", numMatricula=" + numMatricula +
                ", alumno=" + alumno.getNombreUsuario() +
                ", cicloFormativo=" + cicloFormativo.getNombre() +
                ", modulo=" + modulo.getNombre() +
                '}';
    }
}
