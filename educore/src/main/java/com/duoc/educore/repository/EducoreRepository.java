package com.duoc.educore.repository;
import com.duoc.educore.model.Inscripcion;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class EducoreRepository {
    private List<Inscripcion> inscripciones = new ArrayList<>();
    private Long contadorId = 1L;

    public Inscripcion save(Inscripcion inscripcion) {
        inscripcion.setId(contadorId++);
        inscripciones.add(inscripcion);
        return inscripcion;
    }
    public List<Inscripcion> findAll() {
        return inscripciones;
    }
    public Optional<Inscripcion> findById(Long id) {
        return inscripciones.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst();
    }
    public List<Inscripcion> findByEstado(String estado) {
        return inscripciones.stream()
                .filter(i -> i.getEstado().equalsIgnoreCase(estado))
                .toList();
    }
    public boolean deleteById(Long id) {
        return inscripciones.removeIf(i -> i.getId().equals(id));
    }
    public Optional<Inscripcion> update(Long id, Inscripcion nueva) {
        return findById(id).map(existente -> {
            existente.setNombreEstudiante(nueva.getNombreEstudiante());
            existente.setCurso(nueva.getCurso());
            existente.setEstado(nueva.getEstado());
            existente.setFechaInscripcion(nueva.getFechaInscripcion());
            existente.setModalidad(nueva.getModalidad());
            return existente;
        });
    }
}