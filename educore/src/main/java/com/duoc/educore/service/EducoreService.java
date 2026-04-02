package com.duoc.educore.service;
import com.duoc.educore.model.Inscripcion;
import com.duoc.educore.repository.EducoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class EducoreService {

    @Autowired
    private EducoreRepository repository;

    public Inscripcion crear(Inscripcion inscripcion) {
        if (inscripcion.getNombreEstudiante() == null ||
                inscripcion.getNombreEstudiante().isBlank()) {
            throw new IllegalArgumentException("El nombre del estudiante no puede estar vacío");
        }
        if (inscripcion.getCurso() == null ||
                inscripcion.getCurso().isBlank()) {
            throw new IllegalArgumentException("El curso no puede estar vacío");
        }
        if (inscripcion.getEstado() == null ||
                inscripcion.getEstado().isBlank()) {
            throw new IllegalArgumentException("El estado no puede estar vacío");
        }
        return repository.save(inscripcion);
    }
    public List<Inscripcion> listarTodos() {
        return repository.findAll();
    }
    public Inscripcion buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inscripción no encontrada con ID: " + id));
    }
    public List<Inscripcion> buscarPorEstado(String estado) {
        List<String> estadosValidos = List.of("ACTIVO", "INACTIVO", "PENDIENTE");
        if (!estadosValidos.contains(estado.toUpperCase())) {
            throw new IllegalArgumentException(
                    "Estado inválido. Los valores permitidos son: ACTIVO, INACTIVO, PENDIENTE"
            );
        }
        return repository.findByEstado(estado);
    }
    public Inscripcion actualizar(Long id, Inscripcion nueva) {
        if (nueva.getNombreEstudiante() == null ||
                nueva.getNombreEstudiante().isBlank()) {
            throw new IllegalArgumentException("El nombre del estudiante no puede estar vacío");
        }
        if (nueva.getCurso() == null ||
                nueva.getCurso().isBlank()) {
            throw new IllegalArgumentException("El curso no puede estar vacío");
        }
        return repository.update(id, nueva)
                .orElseThrow(() -> new RuntimeException("Inscripción no encontrada con ID: " + id));
    }
    public void eliminar(Long id) {
        boolean eliminado = repository.deleteById(id);
        if (!eliminado) {
            throw new RuntimeException("Inscripción no encontrada con ID: " + id);
        }
    }
}