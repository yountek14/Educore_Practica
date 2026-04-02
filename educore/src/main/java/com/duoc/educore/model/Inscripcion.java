package com.duoc.educore.model;

public class Inscripcion {
    private Long id;
    private String nombreEstudiante;
    private String curso;
    private String estado;                                   // ACTIVO, INACTIVO, PENDIENTE
    private String fechaInscripcion;
    private String modalidad;                             // Presencial, Online

    public Inscripcion(){}

    public Inscripcion(Long id, String nombreEstudiante, String curso, String estado, String fechaInscripcion, String modalidad) {
        this.id = id;
        this.nombreEstudiante = nombreEstudiante;
        this.curso = curso;
        this.estado = estado;
        this.fechaInscripcion = fechaInscripcion;
        this.modalidad = modalidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(String fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }
}
